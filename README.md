# UserManagement
This Spring Boot project includes an application for managing users and exposes the following operations over a REST interface:

- get all users (mapped to `/` for a `GET` request)
- get user by email (mapped to `/get-user/{email}` for a `GET` request)
- create user (mapped to `/create-user` for a `POST` request)
- update user (mapped to `/update-user/{email}` for a `PUT` request)
- delete user (mapped to `/delete-user/{email}` for a `DELETE` request)


The project includes also:
- SQL script for creating a table containing the users (`db-create.sql`)
- a packaged version of the application as a WAR file (`UserManagement.war`)


# API documentation

1. Get all users
  - Request:
  ```
  GET http://<server>:<port>/UserManagement/
  ```
  - Example Result:
  ```JSON
  [
      {
          "firstName": "Ivan",
          "lastName": "Ivanov",
          "email": "ivan.ivanov@sap.com",
          "role": "Admin",
          "password": "password"
      },
      {
          "firstName": "Maria",
          "lastName": "Ivanova",
          "email": "maria.ivanova@abv.com",
          "role": "Admin",
          "password": "password"
      }
  ]
  ```
2. Get user by email
  - Request:
  ```
  GET http://<server>:<port>/UserManagement/get-user/ivan.ivanov@sap.com
  ```

  - Example Result:

    ```JSON
    {
      "firstName": "Ivan",
      "lastName": "Ivanov",
      "email": "ivan.ivanov@sap.com",
      "role": "Admin",
      "password": "password"
    }
    ```

3. Create user
  - Request URL:
  ```
  POST http://<server>:<port>/UserManagement/
  ```

  - Request Body:
  ```JSON
  {
      "firstName": "Iva",
      "lastName": "Ivanova",
      "email": "iva.ivanova@sap.com",
      "role": "User",
      "password": "password"
  }
  ```
  - Example Result:
  ```
  HTTP Status 201 Created
  User created in DB
  ```

4. Update user
  - Request URL:
  ```
  PUT http://<server>:<port>/UserManagement/update-user/iva.ivanova@sap.com
  ```

  - Request Body:
  ```JSON
  {
      "firstName": "Iva",
      "lastName": "Petrova",
      "email": "iva.ivanova@sap.com",
      "role": "User",
      "password": "password"
  }
  ```

  - Example Result:

    ```
    HTTP Status 200 OK
    User updated in DB
    ```

5. Delete user
  - Request:
  ```
  DELETE http://<server>:<port>/UserManagement/delete-user/iva.ivanova@sap.com
```

  - Example Result:

    ```
    HTTP Status 200 OK
    User deleted from DB
    ```
