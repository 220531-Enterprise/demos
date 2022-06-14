# JMeter Testing our Web Server to measure Throughput:
[Apache JMeter](https://github.com/jmeter-maven-plugin/jmeter-maven-plugin) is an Apache project that can be used as a load testing tool for analyzing and measuring the performance of a web service.  We will use JMeter to simulate 200 HTTP requests to our web server at once.  The words that will be sent in the query parameter are included in a CSV file.

- First, add the plugin to your `pom.xml`:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.lazerycode.jmeter</groupId>
            <artifactId>jmeter-maven-plugin</artifactId>
            <version>3.4.0</version>
            <executions>
                <!-- Generate JMeter configuration -->
                <execution>
                    <id>configuration</id>
                    <goals>
                        <goal>configure</goal>
                    </goals>
                </execution>
                <!-- Run JMeter tests -->
                <execution>
                    <id>jmeter-tests</id>
                    <goals>
                        <goal>jmeter</goal>
                    </goals>
                </execution>
                <!-- Fail build on errors in test -->
                <execution>
                    <id>jmeter-check-results</id>
                    <goals>
                        <goal>results</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
<br>

- To open the JMeter GUI run this command in your project terminal: `mvn jmeter:configure jmeter:gui`.  Do the following once the gui has opened:

    1. Name the Test Plan `Word Count`
    2. Right click on the test plan in the left side > `Add` > `Thread Group`
        - A thread group is a group of Jmeter Threads that are going to send Http Requests to our Http Server.
    3. In `Number of Threads`, make it 200.
    4. Right click on `Thread Group` > `Add` > `Logic Controller` > `While Controller`
        - In `Condition (fucntion or variable)`, add the following `jexl` function: 
        ```javascript
        ${__jexl3("${WORD}" != "<EOF>")}
        ```
    5. Right click on `While Controller` > `Add` > `Config Element` > `CSV Data Set Config
        - Inside the while loop, we add a CSV Data Set Config which reads the words from a file and feed it into a variable.
    6. In  `CSV Data Set Config`, in the `Filename:` input, click `Browse` and select the `search_words.csv` document from wherever it's stored on your computer.  Make sure that you have the following configurations:

        ```
        Variable Names: WORD
        Delimeter: \n
        Allow quoted data?: FALSE
        Recycle on EOF? FALSE
        Stop thread on EOF? TRUE
        Sharing Mode: All threads
        ```
    
    7. Right click on `While Controller` > `Add` > `Sampler` > `HTTP Request`.  Config details should be as follows:

        ```
        protocol: http
        Server Name or IP: localhost
        PortNumber: 8000
        GET Path: /search?word=${WORD}
        ```
    
    8. Right click on `While Controller` and add two `Listeners` : (1) `View Results Tree` and (2) `Summary Report`.

Note that when you change the thread pool to `1` in your application and run it -- then run JMeter -- the throughput is significantly less than when you change the pool to `4` and run both the tests and app again, concurrently.  This is because, due to more threads, we are able to process more data at a time. **Make sure that you clean your results between test runs**.

<br>

# Measuring Throughput
> *What's Throughput?*
>  - Throughput is The **number of tasks** completed in a given period of time, measured in tasks per time unit.  (Throughput = # of tasks / time). `Throughput = N/T`.
>
> - **By servicing each task on a different thread, in parallell, we improve throughput by `N`.**
> - `N` = # of threads *or* cores in cpu

<br>

### Thread Pooling
Creating the thread once and re-using them for future tasks, instead of recreating and restarting thehm. Thread Pools us achieve optimal throughput. 

- Once threads are created, they sit in a pool.
- Tasks are lined up in a queue and distributed to each thread within the pool.
    - If all threads within pool are busy, the tasks wait in the queue for one to free up.

> JDK comes with a few implementations of thread pools, including `Fixed Thread Pool Executor` which creates a thread pool with a fixed # of threads in the pool.

```java
int numberOfThreads = 4;
Executor executor = Executor.newFixedThreadPool(numberOfThreads);

Runnable task = ...;
executor.execute(task);
```
<br>

### Optimizing for Throughput: HTTP Server + Measure Throughput with Apache Jmeter :chart_with_upwards_trend:

- Http Server will send a flow of requests as input.
- Http Server will load a large book from the disc (War and Peace).
- Application acts as a search engine: Client sends us a word like "talk" and the application will search for that word in the book and count how many times that word appears in the novel.
    - The Http Request: `http://127.0.0.1:8000/search?word=talk` :arrow_right: Http Server
- Http Server sends the count of how many times that appears as a response to the user.
    - HttpResponse: `status: 200, body: 3443` :arrow_right:  Client