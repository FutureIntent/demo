## ABOUT

This project has no UI!!!
This project is a blog prototype. User has ability to register and authenticate/authorise by providing existing credentials. Authorised user has access to secured routes, which give user CRUD functionality such as: show different users, update current user's data, delete current user, register new user. Users can create their own posts by providing `title` and `content` on a special route. Authenticated users can view users posts, update own posts and delete them. All `GET` routes use pagination, provide URL queries or default properties will be set.

This project is a Spring Boot knowledge showcase. It includes various basic back-end aspects such as: Restful API, controllers, services, models, repositories, ORM Hibernate, Maven, authentication and authorisation processes by storing user's Sessions in database via Spring Security, email sending by JavaMail library, SQL queries, associated tables, Hibernate inheritance, validation via JPA Validator, CRUD functionality and pagination.


### DEMONSTRATIONAL PURPOSE

Project has an opportunity to add products by using Hibernate inheritance. Only user with role `admin` can create products.
Also, there is a controller to send email messages. Email properties can be adjusted in `application.properties` and `mail` -> `EmailServiceImpl.java`.

## TIPS

1. Testing is made with Postman. For authentication purpose use basic auth. Currently secured routes have 2 roles: `user` and `admin`;
2. For mail sending used Gmail SMTP. Provide existing account credentials in `application.properties`;
3. All controllers are stored in the corresponding package, example, `user` -> `controller` / `service` / `model`;
4. In creation process has been used MySQL database.
5. Pagination parameters are used as URL queries, example, `http://localhost:8080/user/showUsers?size=2&page=1&sortBy=user_id`. Uses default parameters if empty;
6. Body requests have to be in JSON format;
7. Business logic is located in controllers directory;
8. Project has a custom exception handler for JPA validator to provide a more appealing response;
9. Application properties are stored in `application.properties`;
