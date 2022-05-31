## ABOUT

This project is a Spring Boot knowledge showcase. It includes various basic back-end aspects such as: Restful API, controllers, services, models, repositories, ORM Hibernate, Maven, authentication and authorisation processes by storing user's Sessions in database via Spring Security, email sending by JavaMail library, SQL queries, associated tables, Hibernate inheritance, validation via JPA Validator, CRUD functionality and pagination.

## TIPS

Testing is made with Postman. For authentication purpose use basic auth. Currently secured routes have 2 roles: `user` and `admin`;\
For mail sending used Gmail SMTP. Provide existing account credentials in `application.properties`;\
All controllers are stored in the corresponding package, example, `user` -> `controller` / `service` / `model`;\
In creation process has been used MySQL database.
Pagination parameters are used as URL queries, example, `http://localhost:8080/user/showUsers?size=2&page=1&sortBy=user_id`. Uses default parameters if empty;\
Body requests have to be in JSON format;\
Business logic is located in controllers directory;
Project has a custom exception handler for JPA validator to provide a more appealing response;\
Application properties are stored in `application.properties`;
