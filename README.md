# Task

## Creating a backend
Using Java 17 or up. Spring framework is recommended, but not mandatory. 

### Getting Started
You are to create a REST API for managing users. Your service will be responsible for the following:
- Creating new users
- Listing all available users
- Listing a single user
- Updating an existing user
- Deleting an existing user

Your users should store the following information:
- A username
- A first name
- A last name
- An email
- A phone number

### Initialization
Your service will need to perform the following:
- Present a REST API (producing and consuming JSON)
- Persist users through restarts


### Exposing an API
Your service should present the following API endpoint:
- POST /users - create a new user
- GET /users - get a list of users
- GET /users/{id}
- PUT /users/{id}
- DELETE /users/{id}


### My Choices
I decided to create this API using the following dependencies
- Spring Web
- Spring Boot Dev Tools
- Spring Data JPA
- MySQL Driver

I did not use DTO because there's no sensible information ( like passwords ) 
or other tables that need to create relations when returning data from API.

 ### Tests

I used Postman to test all the endpoints. The collection is included 
in this repository.