# MicroservicesUsingSpringBoot
A modern architecture for a hotel review system, built using Spring Boot and Spring Cloud which is designed to manage various aspects of a hotel, including adding users, hotels, and handling user ratings.


## Features and Services

### User Service
* Users can sign up and log in using secure authentication mechanisms (JWT).
* Users can rate the hotels with detailed reviews.

### Hotel Service
* New hotels can be added with detailed information (e.g., name, location, amenities).

### Rating Service
* Users can rate hotels and leave reviews.
* Get all ratings, or filter ratings by user ID or hotel ID.

### Service Registry
* Service Discovery: Use Eureka Server for registering and discovering microservices, enabling dynamic scaling and fault tolerance.

### Configuration Server
* Use Spring Cloud Config Server to manage and serve configurations for all microservices from a central place, supporting dynamic updates.

### API Gateway
* Use Spring Cloud Gateway as an entry point to route requests to appropriate microservices, providing features like load balancing, rate limiting, and security.

## Architecture
The system architecture involves several components working together seamlessly:

Microservices: Each service (User Service, Hotel Service, Rating Service) is an independent Spring Boot application, communicating via REST APIs.

Database: Each microservice has its own database to ensure data autonomy and scalability (mySQL, PostgreSQL for relational data, MongoDB for non-relational data).

Service Registry (Eureka Server): Manages the discovery of microservices, enabling them to find and communicate with each other dynamically.

Configuration Server (Spring Cloud Config Server): Stores configuration files in a Git repository, allowing microservices to fetch their configuration properties dynamically.

API Gateway (Spring Cloud Gateway): Acts as a reverse proxy to route client requests to the appropriate microservice, also handling cross-cutting concerns such as authentication, logging, and rate limiting.

Circuit Breaker (Resilience4j): Implements fault tolerance by providing fallback mechanisms for microservices, preventing cascading failures.

Security: Use Spring Security with OAuth2 for securing the endpoints, ensuring only authorized users can access specific resources.