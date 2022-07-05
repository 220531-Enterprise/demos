# Spring Framework
---
The Spring Framework is an application framework and inversion of control container for the Java platform. One of the core functions of the Spring Framework is _**dependency injection**_, which is accomplished through the use of a _**inversion of control**_ container, known as the `ApplicationContext`.  The framework integrates with other specifications, namely:

- Dependency Injection (JSR 330)
- Servlet API (JSR 340)
- Bean Validation (JSR 303)
- JPA (JSR 338)

## Main Goals of Spring
---
The main goals of the Spring Framework include:
- Lightweight development with Java POJOs
- Dependency injection to promote loose coupling
- Declarative programming with Aspect-Oriented Programming (AOP)
- Minimize boilerplate Java code

## Terminology
---
Important Terminology
	
- **Beans**
  - instances which are managed by the Spring Framework

- **Dependency Injection**
  - the process of the Spring Framework actually injecting an instance of a dependency into a component (through auto-wiring or manual bean wiring)

- **Autowiring**
  - the process in which the Spring Framework identifies dependencies within a component, finds the corresponding component implementations and instantiates the dependency (or grabs an existing instance)

- **Inversion of Control**
  - the concept of the Spring Framework managing beans and performing dependency injection
  - developers hand over control over aspects of the application to the Spring Framework


- **IOC Container**
  - a general term that is used to refer to anything that is implementing Inversion of Control


- **Application Context**
  - the primary IOC container of the Spring Framework alternative to the Bean Factory IOC container implementation
  
- **Declarative Programming**
  - The ability to write code that says (declares) what we want to do, rather than how to do it.
  - Think of Java as being an imperative language, and SQL as a declarative language.
  - [Imperative vs Declarative](https://tylermcginnis.com/imperative-vs-declarative-programming/)

## Dependency Injection
---
Dependency injection is a technique whereby one object supplies the dependencies of another object. A dependency is an object is used as part of the operation of another object. Dependencies can be either mandatory or optional. The Spring Framework's `ApplicationContext` is an inversion of control container, also known as the _bean container_. This container is responsible for managing the lifecycle of all beans contained within it and providing them to the application code when requested.


# Spring Framework Modules
---
![Spring Framework Modules and Sub-modules](https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/images/spring-overview.png "Spring Framework Modules and Sub-modules")
### Core Container
- Factory for creating beans
- Manages bean dependencies

#### Sub-modules:
- Beans
- Core
- SpEL (Spring Expression Language)
- Context
---

### Infrastructure
- Allows developers to add functionality to objects declaratively
- Logging, security, transactions, etc.

#### Sub-modules:
- AOP
- Aspects
- Instrumentation (used for remote monitoring of applications)
- Messaging
---

### Integration (Data Access Layer)

- Allows developers to communicate with DBs (relational or non-relational)
- Also allows functionality for communicating with a messaging queue

#### Sub-modules:
- JDBC
- ORM (Works very well with Hibernate)
- Transactions (Makes heavy use of AOP)
- OXM (Object XML Mapping)
- JMS (Java Message Service)
---

### Web Layer (MVC)

- Home of the Spring MVC framework

#### Sub-modules:
- Servlet
- WebSocket
- Web
- Portlet
---

### Test Layer
- Supports Test-Driven-Development (TDD)
- Allows for the mocking of objects and out-of-container testing

#### Sub-modules:
- Unit
- Integration
- Mock
