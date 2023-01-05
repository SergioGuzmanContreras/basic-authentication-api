# BASIC AUTHENTICATION API

### Description

    Project with basic authentication configuration, with documentation in openapi (swagger) and creation of a table in h2 
    memory database, with jpa for product consultation, with sample GET, POST, PUT and DELETE operations.

#### Prerequisites

    Have installed gradle 7.6 or higher and Java 17

#### Operate

    To build, go into the root folder and run the command

        ./gradlew clean test build

    Enter the folder that generates the executable

        /build/libs

    Raise the project with the command

        java -jar basic-authentication-proyect-0.0.1.jar

    When the console shows the legend

        Started BasicAuthenticationProyectApplication in 5.799 seconds (JVM running for 6.224)

    The service is already up, you can view the open api console with the following route

        http://localhost:8085/doc/swagger-ui.html

## TECHNOLOGIES

* [Java 17]
* [Gradle 7.6]    
* [Spring boot 2.7.7 (data-jpa, security, web)]
* [springdoc-openapi-ui 1.6.14]    
* [h2database 2.1.214]   

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.7/gradle-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#web.security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

