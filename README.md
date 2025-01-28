<<<<<<< HEAD
# Spring Boot + Spring data JPA + PostgreSQL

Article link : https://mkyong.com/spring-boot/spring-boot/spring-boot-spring-data-jpa-postgresql/

## Technologies used:
Technologies used:
* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6  is the default JPA implementation)
* Spring Security
* Spring MVC
* Liquibase
* MapStruct
* PostgreSQL 15
* Maven
* Java 17
* JUnit (Need to add.)
* Docker
* [REST Assured](https://rest-assured.io/) and [Testcontainers](https://testcontainers.com/) (for Spring integration tests using a container)

## How to run it
```

$ git clone https://github.com/ilya-ovramets/petProjectSpring.git

$ cd .\petProjectSpring\

$ mvn clean package

$ docker run --name pg1 -p 5555:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=todo_test -d postgres

$ mvn spring-boot:run

```
=======
# petProjectSpring
> 574eb43cb9b2629ae1d9e08deae61b199b9c8e0a
