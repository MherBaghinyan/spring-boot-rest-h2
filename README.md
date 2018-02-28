# spring-boot-rest-h2

Spring boot MVC app with embadded h2 database.

## Modules:
*        /core-data
*       /core-services	
*       /web-api

main class: /web-api/ com.banking.Application.java

## Requirements
For building and running the application you need:

JDK 1.8
Maven 3

To test the endpoints Swagger UI is used. http://localhost:5454/swagger-ui.html

## Request URLs:

get bank account
http://localhost:5454/api/account/{id}
create bank account
http://localhost:5454/api/account/new
edit bank account details
http://localhost:5454/api/account/edit
delete bank account
http://localhost:5454/api/account/{id}


