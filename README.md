# Folder Structure
Folder | Description
------------ | -------------
docker | Docker files that used to support example projects
example-backend-01 | Example application with REST API

## Notes
- Lombok (For view code without error), Lombok needs to be installed on your IDE (Eclipse/IntelliJ IDEA), please see this link https://www.baeldung.com/lombok-ide .
For my personal usage, I used Eclipse 2020-06 with lombok-1.18.4.jar.
- Make sure that you start docker before run code analysis (SonarQue).
- If you use Docker Toolbox for Windows, docker will run at http://192.168.99.100. That means you need to modify the configuration on examples from http://localhost to http://192.168.99.100 such as setting for SonarQue needs to be http://192.168.99.100:9000 (not http://localhost:9000).
