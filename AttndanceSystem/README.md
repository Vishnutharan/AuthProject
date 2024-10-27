# Spring Boot Demo Application (No Database)

This is a demo Spring Boot application that doesn't require a database connection.

## Features
- Basic REST endpoints
- Excludes database configuration to simplify setup


Configure Application: In src/main/resources/application.properties, ensure the following line is added to exclude database auto-configuration:

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
