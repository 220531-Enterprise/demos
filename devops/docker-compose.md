# Running Multiple Containers on the Same Server
The following is a docker-compose.yml file which will run 2 containers at the same time:

<br>

1. An Angular App running on `http://<ip-address>:80`
2. A Spring Boot API running on `http://<ip-address>:5000/api`

<br>

Create a `docker-compose.yml` on either an EC2 or on your localhost:
*Make sure that the **Angular App's `environment.prod.ts` file contains the correct URL to the server where you're deploying these apps***

<br>

```yml
version: "3.8"

services:

  ui:
  # Official image name from Dockerhub to local repo
   image: sophiagavrila/rolodex-ui:auto
   # Default ports that angular container with Nginx runs on
   ports:
      - "8080:80" # first one is exposed, 2nd is internal port on the container
   networks:
    - demo

  myapi:
    image: sophiagavrila/my-api:auto
    mem_limit: 700m
    ports:
      - "5000:5000"
    networks:
      - demo
    deploy:
      restart_policy:
        condition: on-failure
        delay: 30s
        max_attempts: 3
        window: 120s
  
networks:
  demo:
```

<br>

Run it with the command:

```sh
docker-compose up
```

Stop it with the command:

```sh
docker-compose stop
```
