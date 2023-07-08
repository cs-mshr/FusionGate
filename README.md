# Management Software Project

This project is an implementation of a management software system using microservices architecture. It consists of two microservices with a common API Gateway to handle client requests. The project is set up with the following features:

- **Microservices:** The system is divided into two microservices: Student Management and Teacher Management. These microservices are responsible for handling CRUD operations for student and teacher data respectively.

- **API Gateway:** An API Gateway is implemented to provide a single entry point for client requests and to route them to the appropriate microservice. This allows for centralized routing and improves scalability.

- **OpenFeign:** OpenFeign is used for inter-microservice communication. It simplifies the process of making HTTP requests between microservices by providing a declarative interface and automatically handling request mapping and serialization.

- **Redis Cache:** Redis cache is implemented to improve response time and reduce server load. By caching frequently accessed data, the system avoids hitting the database for every request, resulting in improved performance.

- **Resilience4j:** Resilience4j is utilized for implementing circuit breaker, rate limiting, and retry mechanisms. These features enhance server health and resilience by providing fault tolerance and preventing cascading failures.

- **Kafka:** Kafka is set up as a message broker for handling asynchronous communication. A Kafka consumer and producer are implemented to receive requests from an external API using a web client. The API details are as follows:

  - Base URL: https://info.payu.in/merchant/postservice.php?form=2
  - HTTP Method: POST
  - Content-Type: x-www-urlencoded
  - API Details:
    - key: JEnhDf
    - command: get_Transaction_Details
    - var1: 2022-08-05
    - var2: 2022-08-06
    - hash: eb76c2a2ae354161808d39d45e2c333434302d6185aa55f9605074e32deb9468cab2451a70c581eddcbd183415d877032e5ddc0ac8b5c2c225c17d7cc6a327c5

- **Swagger API Documentation:** The API endpoints and their details are documented using Swagger. You can access the Swagger UI to explore the available endpoints, request/response models, and make test requests. The Swagger documentation can be accessed at `[local/swagger-ui.html](http://localhost:8080/swagger-ui/index.html#/)`,`[local/swagger-ui.html](http://localhost:8081/swagger-ui/index.html#/)`.

Feel free to explore the project and refer to the documentation for more details on each component and its configuration.

For any further questions or clarifications, please reach out to the project maintainer.

![Screenshot from 2023-07-08 01-49-22](https://github.com/cs-mshr/paynav-project/assets/95642555/719238a4-db60-41d3-a587-aa7c5631e2fc)


![Screenshot from 2023-07-08 01-49-08](https://github.com/cs-mshr/paynav-project/assets/95642555/ca3e1085-e43b-42a6-ae4b-359bbd7742bc)


![Screenshot from 2023-07-08 01-48-57](https://github.com/cs-mshr/paynav-project/assets/95642555/1a52dfef-f373-467c-9d09-a4b199cce8b8)
# paynav-project
# paynav-project
# paynav-project
