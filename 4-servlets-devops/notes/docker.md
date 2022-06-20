> *I reccomend this resource for understanding the basics of virtualization vs. containerization.  Read:* [What is Docker? In Simple English](https://blog.usejournal.com/what-is-docker-in-simple-english-a24e8136b90b#:~:text=Terms%20definition,all%20out%20as%20one%20package)    🔍 <br>
> :star: [Here](https://kodekloud.com/courses/970256/lectures/18323815) is a resource to a Docker Commamds Lab.

<br>

## Docker
*Docker is an open platform for developing, shipping, and running applications. Docker enables you to separate your applications from your infrastructure so you can deliver software quickly.*

- The first half of this document contains guides on how to run a Docker container in an EC2.
- The second half guides you in how to create both a Tomcat or Postgres container running on your local machine (as long as you have Docker Desktop installed).

<br>
<br>

## *Running* `nsnake` *Container in an EC2* 🐍

1. SSH into an EC2 instance.  You will only need 1 security rule which is supplied to you by default (SSH port 20).

2. Once you've ssh's in, run the following commands:

``` sh
# Install Docker
sudo yum install docker

# Create a group of users within your EC@ instance with Docker permissions
sudo groupadd docker
sudo usermod -a -G docker ec2-user
sudo service docker start

# Make a folder to contain your Dockerfile -> cd into it
mkdir snakedocker
cd snakedocker

# Use the nano command to open up a text editor
nano Dockerfile

# The following commands go inside your Dockerfile

# FROM speifies the base image, running an ubuntu OS
FROM ubuntu:18.04

# RUN specifies the duty of the container.  It should install this software
RUN apt-get update && apt-get install -y libncurses5-dev && apt-get install -y nsnake

# CMD specifies the instruction that is to be executed when a Docker container starts
# In this case, we are running the executable located at /usr/games/nsnake within the nginx container
CMD ["/usr/games/nsnake"]
```

3. Exit the `nano` text editor with the keyboard commands `ctrl` + `X`, then press `Y` to save.

4. Build the image from the `Dockerfile` with the following command: 
    >`sudo docker build -t snake:auto .`
    
5. Finally, run the image with the following command and you'll load up the game thanks to the `CMD` command.
    >`sudo docker run -it snake:auto` <br>
        the `-it` flag allows you to interact with the executable file, which, in this case, is the game itself.

<br>

## Creating a Postgres Container with Docker
```sh
# Minimalist postgres database, default username 'postgres'
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name testdb postgres

# Connect. If --name not used earlier, use generated container name or id in place of testdb
docker exec -it testdb psql -U postgres

# This will take you to psql shell where you can construct a table.
# You can view this data if you open DBeaver and connect to port 5432 of localhost
# ! Note that your postgres db engine on your local machine must be turned off in 
# order to view the data from your postgres container !
 
# Go to Services -> turn off postgres

# By default, schema will be set to public, but you can set this to whatever custom schema you
# want to view in psql shell with the following commands:

SET search_path TO myschema;

\l - to display databases
\c - connect to new database
```

<br>


## Creating a Tomcat Container to Deploy a WAR
```sh
# Basic setup for Tomcat Container
# Pull from Docker hub and expose to port 8080 of localhost
docker run -d --name tomcat --rm -it -p 8080:8080 tomcat

# Cd into your project, run Maven package
mvn package

# While still in root directory of project, hand off the war file to tomcat to deploy
docker cp target/HelloFrontController.war tomcat:/usr/local/tomcat/webapps

# You can now see your web app hosted within your container if you go to localhost:8080/HelloFrontController-0.0.1-SNAPSHOT
```

<br>
