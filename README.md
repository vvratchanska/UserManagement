# UserManagement
This Spring Boot project includes an application for managing users and exposes the following operations over a REST interface:
- get all users (mapped to "/" for a GET request)
- get user by email (mapped to "/get-user/{email}" for a GET request)
- create user (mapped to "/create-user" for a POST request)
- update user (mapped to "/update-user" for a PUT request)
- delete user (mapped to "/delete-user/{email}" for a DELETE request)


THe project includes also:
- SQL script for creating a table containing the users
- a packaged version of the application as a WAR file