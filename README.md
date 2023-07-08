# Management Software Project

This project is an implementation of a management software system using microservices architecture. It consists of two microservices with a common API Gateway to handle client requests. The project is set up with the following features:

- **Microservices:** The system is divided into two microservices: Student Management and Teacher Management. These microservices are responsible for handling CRUD operations for student and teacher data respectively.

- **API Gateway:** An API Gateway is implemented to provide a single entry point for client requests and to route them to the appropriate microservice. This allows for centralized routing and improves scalability.

- **OpenFeign:** OpenFeign is used for inter-microservice communication. It simplifies the process of making HTTP requests between microservices by providing a declarative interface and automatically handling request mapping and serialization.

- **Redis Cache:** Redis cache is implemented to improve response time and reduce server load. By caching frequently accessed data, the system avoids hitting the database for every request, resulting in improved performance.

- **Resilience4j:** Resilience4j is utilized for implementing circuit breaker, rate limiting, and retry mechanisms. These features enhance server health and resilience by providing fault tolerance and preventing cascading failures.

- **Kafka:** Kafka is set up as a message broker for handling asynchronous communication. A Kafka consumer and producer are implemented to receive requests from an external API using a web client. The API details are as follows:
![Screenshot from 2023-07-08 02-49-05](https://github.com/cs-mshr/project-paynav/assets/95642555/45a98958-5c67-4aac-8530-cec85d5bb888)



- **Swagger API Documentation:** The API endpoints and their details are documented using Swagger. You can access the Swagger UI to explore the available endpoints, request/response models, and make test requests. The Swagger documentation can be accessed at `[local/swagger-ui.html](http://localhost:8080/swagger-ui/index.html#/)`,`[local/swagger-ui.html](http://localhost:8081/swagger-ui/index.html#/)`.

Feel free to explore the project and refer to the documentation for more details on each component and its configuration.
![Screenshot from 2023-07-08 01-48-57](https://github.com/cs-mshr/project-paynav/assets/95642555/d8fc5b54-2465-4a52-9362-be9b1844f667)
![Screenshot from 2023-07-08 01-49-08](https://github.com/cs-mshr/project-paynav/assets/95642555/8564a7dc-3855-48b1-889b-971c5f715430)
![Screenshot from 2023-07-08 01-49-22](https://github.com/cs-mshr/project-paynav/assets/95642555/28924bed-b69b-4323-aca6-4e8340034c39)

For any further questions or clarifications, please reach out to the project maintainer.
