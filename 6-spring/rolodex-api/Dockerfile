FROM openjdk:8-jdk-alpine

COPY /target/rolodex-api.jar rolodex-api.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "rolodex-api.jar"]

# docker build -t my-api:auto .
# docker run -d -p 5000:5000 my-api:auto