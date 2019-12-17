Task Web Project - Courier Exchange
- The application is implemented using Servlet and JSP technologies.
- The application architecture follows the MVC pattern.

Application Functionality:
The customer is registered in the system and creates a new order according to his requirements. He chooses the type of transport for transportation, distance and fare (express or regular).
The courier is registered in the system and indicates the type of transport on which he can carry out transportation. (truck, car or without transport). Further, from the list of available orders, he can choose the transportation that he wants to carry out.
After completion of transportation, the customer evaluates the quality of the services provided. This indicator affects the rating of the courier.
The administrator manages users, can change their role, type of transport and rating.

Database:
- Information about the subject area is stored in the database.
- Some of the data in the database is stored in Cyrillic, utf-8 encoding is used.
- Database Access Technology - JDBC.
- To work with the database, the application has a thread-safe connection pool.
- Work with data in the application is carried out through the DAO template.
- Implemented protection against sql injection.

Basic features of the application:
- The application interface is fully localized; choice of languages: EN | RU.
- The application correctly handles emerging exceptions, including maintaining their logs.
As a logger used Log4J2.
- When implementing the business logic of the application, design patterns are used
(GoF templates: Factory Method, Command, Builder, State, Observer, Singleton, Proxy etc).
- A session is used to store user information between requests.
- To intercept and adjust the objects of the request (request) and response (response), a filter is applied.
- When implementing JSP pages, JSTL library tags are used.
- The application does not use scriptlets.
- When implementing the user interface, front-end development technologies are used (html, css, js)
- Implemented protection against cross site scripting (xss).
- Implemented your own tag.
- Validation of input data is performed on the client and on the server.
- The documentation for the project is framed according to the requirements of javadoc.
- The design of the code corresponds to the Java Code Convention.
- When deploying the application, the technology is Maven Maven.
- The application contains TestNG tests.