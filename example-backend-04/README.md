# example-backend-04

This project is the example backend service with messaging (Spring AMQP)

## Build
01_build_application.bat

## Test (Unit test)
02_test_application.bat

## Run code analysis for code coverage (SonarQue) 
03_run_code_coverage.bat
Note!!! Don't forget to start docker for SonarQue. Please see docker files in docker folder.

## Start Spring Boot Application by jar file
04_run_backendservice.bat
Note!!! Don't forget to start docker for RabbitMQ.
#### Access RabbitMQ -> http://localhost:15672/
#### Access Swagger document -> http://localhost:8081/swagger-ui/index.html.
