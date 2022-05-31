# Welcome to Java :coffee:
In this demo we'll create our first Java program...without an IDE, simply by writing some simple java source code in a plain text file (with a `.java` extension).

<br>

1. Confirm that the JDK is installed on your machine by opening your terminal and running `java -version`.  Additionally, ensure that the java compiler is installed by running `javac -version`.

> `javac` is the `Java Compiler` featured in the JDK which allows you to compile `.java` files into `.class` files.  These class files then run on the **Java Virtual Machine**.

<br>

2. Open up Gitbash on your computer (if you're on Windows) or a termianl if you're on Mac. Create a folder by running the command `mkdir FirstJavaProgram`. Then `cd` into this folder and create a document called `HelloWorld.java` with `nano HelloWorld.java`.

> *`nano` will open a terminal-based text editor traditionally used for UNIX-based systems*

3. Write the following code:

```java
public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello World!");

    } 

}
```

<br>

4. Save the file by typing `ctrl + X` and then press `Y`. In the terminal **COMPILE** the program with: `javac HelloWorld.java`.  You will notice that a `HelloWorld.class` file appears in the same directory where `HelloWorld.java` is located.
    
    > *What happened?* `javac` is the program that translates Java code into bytecode in the form of a `.class` file...or Class. The `.class` extenstion allows it to be executed by the *JVM*.

<br>

5. Execute the bytecode, **RUN**: `java HelloWorld`

    > `java` is the program that starts the JVM, which loads the `.class file`, verifies the bytecode and executes it.
    
<br>

6. You should see `Hello World!` in your Terminal!

<br>

## Viewing Bytecode of a Class File:
Bytecode is the intermediate representation of a Java program. The JVM transaltes bytecode into machine-level assembly instructions. The instructions within the `.class` file MUST be interpreted by the **JVM** in order to be executed.

1. To view the byte code of our custom `HelloWorld` class, in the terminal run: `javap -c HelloWorld.class`.

    > The `-c` option allows us to view disassembled code, i.e., the instructions that comprise the Java bytecode, for each of the methods in the class.  You can learn more about the `javap` command [here](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javap.html).
    
<br>

2. Similarly, we can use the `-v` argument to view verbose information like stack size.

3. We can also look into classes that come with the JDK (more specifically, libraries included in the **JRE**) like the `Object` class. Run: `javap -v java.lang.Object`.

<br>

## Java Archive Tool: `jar`
Besides `javac` and `java`, there’s another one in JDK which is also an important tool in Java programming. It is the **Java Archive tool** - hence the `jar` name for its executable file.

- A `JAR` is a package file format typically used to aggregate many Java class files and associated metadata and resources into one file for distribution.

- When building Java Applications we invoke the help of a build tool like [**Maven**](https://www.youtube.com/watch?v=2axtcJHP0RA) which assists us in building our project, packaging it as a JAR file, and incorporating any necessary dependencies.
