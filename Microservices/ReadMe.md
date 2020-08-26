# Spring Boot Project

## Microservices

### Concepts Covered in this project.

* WebClient.
* Microservice Communication. 
* Eureka Server discovery.
* Eureka Client registration.

![](https://github.com/SubhashKonar/SpringBoot/blob/master/Microservices/communication-diagram.jpg)


Microservices - also known as the microservice architecture - is an architectural style that structures an application as a collection of services that are

1. Highly maintainable and testable
2. Loosely coupled
3. Independently deployable


The microservice architecture enables the rapid, frequent and reliable delivery of large, complex applications. It also enables an organization to evolve its technology stack.

___

### Service Description

* m-background-verify-service
	*	Main service which will be used by client to background verify the Individual .  Which will call CIBIL / University to gather information.
* m-cibil-service 
	*	Cibil Serivce will communicate with NSDL Service to verify the pan and Cibil Score will be fetched from DB.
* m-nsdl-service
	*	Pan Validaion service.
* m-university-service
	*	Service to validate the Degree Certificate and University Code against the individual.
* m-eureka-server
	*	Discovery Server for service registration and discovery by MicroServices to fetch the URI of other services.
