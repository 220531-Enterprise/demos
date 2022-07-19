# How to Set Up an EC2 to Deploy a Spring Boot Backend
You have been provisioned with a `pem` key which allows you to ssh into your AWS Linux EC2 instance. To connect to it, follow all steps (connection is step 2).

<br>

#### 3 Steps to Deployment:
- Step 1: Dockerize your app (pre-req)
- Step 2: Connect to your instance
- Step 3: Clone your App & Build the JAR with Maven
- Step 4: Containerize, & Deploy your App

<br>

## 1. Pre-requisites: Dockerize You App :whale:
Be sure that your Spring Boot app has a `Dockerfile` in it's root directory. You can use the following code, but be sure to replace the `.jar` name with the name of the jar generated when you run `mvn clean package` on your app:

```Dockerfile
FROM openjdk:8-jdk-alpine

# Copy the JAR from the target folder into the container
COPY /target/your-app-0.0.1-SNAPSHOT.jar your-app-0.0.1-SNAPSHOT.jar 

ENTRYPOINT ["java", "-jar", "/your-app-0.0.1-SNAPSHOT.jar"]
```

<br>
<br>

## 2. Connect to your instance
1. Download the `pem` key I sent you via Slack > drag it to a folder on your desktop.

2. Right click on the folder with the pem key inside it > click `Git Bash Here`

3. Inside the Git Bash terminal, run the following command:

```
ssh -i "team-x-e211129.pem" ec2-user@<Your EC2 IP>.compute-1.amazonaws.com
```

> *The name of the pem key after `-i` corresponds **to the exact name of the pem key file I sent you***. *If you are on a Mac, you may need to run `chmod 400 team-1-e211129.pem` if your terminal shoots back a permissions error.  Then run the `ssh` command again.*

4. After running the above `ssh` command, type yes if prompted to continue connecting.
  
> *You must install the JDK 8, Maven ([the right version](https://memotut.com/aws-ec2-how-to-install-maven-on-amazon-linux-2-bcdf9/)), Git, and Docker on your instance.  All you need to do is deploy your containerized app as follows:*

<br>
<br>

## 3. Clone your App and Build the JAR file:
1. In the EC2 instance clone your Spring Boot app onto the instance by running `git clone https://github.com/your-project.git`

2. `cd` into the root direcotry of your project and build the `JAR` file by running:

```
mvn clean package
```

<br>
<br>

## 4. Containerize, & Deploy your App:
1. Start the Docker Daemon - run:

```
sudo service docker start
```

2. `cd` into the project's root directory, where the `Dockerfile` is located.
  
3. **Build a Docker Image** by running:

```
sudo docker build -t myapp:auto .
```

4. **Run the Container exposing the port your server is set to in your `application.properties` file**
> *The `-d` stands for "detached mode" so that you can still use your console*

```
sudo docker run -d -p 5000:5000 myapp:auto
```

<br>
<br>

### :tada: All done!
> *Your application is now running in a docker container accepting requests via the IPv4 address of your EC2 instance*


If you want to hit the endpoins supported by your Spring Rest Controllers, you would have to do so at the PORT and CONTEXT that you have specified...
