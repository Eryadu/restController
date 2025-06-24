


For Authentication, or Authorization , most of the time, data will send in headers.
 
Try this for Webclient in detail
## https://medium.com/@ayoubseddiki132/mastering-webclient-in-spring-boot-a-complete-guide-31482263bc92

Deep detail of how WebClient Error Handling work internally
## https://medium.com/@AlexanderObregon/the-technical-side-of-webclient-error-handling-in-spring-boot-6213b06ba6a0

## https://medium.com/thefreshwrites/resttemplate-feignclient-webclient-with-spring-boot-f34979040b9e


Microservice Example
## https://www.geeksforgeeks.org/spring-boot-webclient-with-example/

REST is Architectural style which define set of constraint and rule to create and design API and Client to use other APIs,
while WebClient and FeignClient are client libraries.

RestClient return the constructor, while WebClient use declarative approach, so we can use builder service here and its
constructor is private.

WebClient publish two publishers 1. Mono (1 object or none), 2. Flux (1 object or N objects)
Flux is used when whole code is in reactive programming, and it returned multiple objects/request,
Mono when it returned single object.

## Difference between REst and Feign client ? best
https://medium.com/@lahirurajapakshe.stack/feign-client-vs-rest-client-a-comprehensive-guide-ad227272537a

## REST Client, Web Client and Feign Client ? good
https://www.linkedin.com/pulse/webclient-vs-feign-client-resttemplate-which-one-should-talha-adeel-mbldf

## REST, WebClient, and Feign Client all deal with making HTTP requests, but they differ in their approach and use
cases. REST is an architectural style, while WebClient and Feign Client are specific implementations for building HTTP 
clients in Java. WebClient is a non-blocking, reactive client, while Feign Client offers a declarative way to define 
and consume REST APIs, particularly useful in microservices.

## REST (Representational State Transfer):
-- Concept:
REST is an architectural style for designing networked applications. It defines a set of constraints for how resources 
should be accessed and manipulated over HTTP.
-- Key Principles:
RESTful APIs use standard HTTP methods (GET, POST, PUT, DELETE) to perform operations on resources, identified by URIs.
-- Not a specific client:
REST is not a client library itself. It's a set of guidelines for building APIs and clients that interact with those APIs.

## WebClient:
-- Function:
WebClient is a non-blocking, reactive client in Spring WebFlux, designed for building highly scalable and 
performant applications.
-- Asynchronous and Reactive:
WebClient handles HTTP requests asynchronously, meaning it doesn't block the calling thread while waiting for
a response. It utilizes reactive programming concepts (like Mono and Flux) to manage the flow of data.
-- Use Cases:
WebClient is ideal for applications that need to handle a large number of concurrent requests with low latency, 
such as microservices or event-driven architectures.

## Feign Client:
-- Function:
Feign Client is a declarative web service client in Spring Cloud that simplifies the process of creating and
consuming REST APIs.
-- Declarative Approach:
With Feign, you define an interface that represents the API, annotating it with information about the endpoints, 
methods, and parameters. Feign then generates the necessary code to make the HTTP requests.
-- Use Cases:
Feign Client is particularly useful in microservices architectures where you need to interact with other services,
as it reduces boilerplate code and promotes cleaner code organization.

## In Summary:
REST is a set of architectural principles.
WebClient is a reactive, non-blocking HTTP client in Spring WebFlux.
Feign Client is a declarative HTTP client in Spring Cloud, simplifying the creation of REST clients.
When choosing between them, consider the following:
Legacy systems or when full control over requests is needed: RestTemplate or WebClient might be suitable.
Microservices architecture and ease of development: Feign Client is a good choice.
High-performance, non-blocking operations: WebClient is the preferred option. 