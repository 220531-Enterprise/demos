# Configuring Spring
---
### What does it mean to configure Spring?
Spring is a dependency injection framework, it accomplishes this through the use of an inversion of control container - specifically, the `ApplicationContext`. Configuring this container means that we will supply a registry containing all of our bean definitions. Bean definitions are simply a description of an object that we want Spring to manage for us, including the bean's dependencies. 

When the container spins up, it will create singleton instances of all of the beans (unless some other scope is specified) based off of the bean definitions we provide to it. If Spring has any issues creating the beans, it will throw a `BeanCreationException` with a detailed explanation as to why it could not create the bean.

---
### Project Dependencies

- `spring-core`
  - Provides basic classes for exception handling and version detection, and other core helpers that are not specific to any part of the framework.
  - [Documentation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/package-summary.html)


- `spring-beans`
  - This package contains interfaces and classes for manipulating Java beans.
  - [Documentation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/package-summary.html)


- `spring-context`
  - This package builds on the beans package to add support for message sources and for the Observer design pattern, and the ability for application objects to obtain resources using a consistent API.
  - [Documentation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/package-summary.html)

---
### XML Configuration
XML configuration is the earliest method used for configuring the Spring container. With this method of configuration, the bean registry is provided in XML format. The default canme for this configuration file is `beans.xml`. The root tag of the configuration file is the `<beans>` tag, which will contain the bean defintions - which are encapsulated by `<bean>` tags. The `ClassPathXmlApplicationContext` implementation of the `ApplicationContext` interface is used to load the bean registry XML file.

---
### Java Class Configuration
The central artifacts in Spring’s Java class configuration support are `@Configuration`-annotated classes and `@Bean`-annotated methods. 

The `@Bean` annotation is used to indicate that a method instantiates, configures, and initializes a new object to be managed by the Spring container. You can use `@Bean`-annotated methods with any Spring `@Component`. However, they are most often used with `@Configuration` beans.

Annotating a class with `@Configuration` indicates that its primary purpose is as a source of bean definitions. Furthermore, `@Configuration` classes let inter-bean dependencies be defined by calling other `@Bean` methods in the same class.

In much the same way that Spring XML files are used as input when instantiating a `ClassPathXmlApplicationContext`, you can use `@Configuration` classes as input when instantiating an `AnnotationConfigApplicationContext`. This allows for completely XML-free usage of the Spring container.

---
### Component Scanning
Classes annotated with `@Component`, or any of the sterotype or derivative annotations, are able to be detected by Spring using a technique known as **component-scanning**. To enable component scanning to autodetect these classes and register the corresponding beans with XML-based configuration you need to include the `<context:component-scan>`, which uses the `base-package` attribute to specify the root package to be scanned.

To enable component scanning with Java class configuration, you can annotate your `@Configuration` class with `@ComponentScan`. Within this annotation you will specificy the root package that you will want Spring to scan for component classes. Those classes are registered as Spring bean definitions within the container. `AnnotationConfigApplicationContext` exposes the `.scan()` method in order to pass a String value representing the package to be scanned.

---
### Stereotype annotations
Annotations denoting the roles of types or methods in the overall architecture (at a conceptual, rather than implementation, level):

- `@Component` (no specific layer)
- `@Controller` (Servlet-layer)
- `@Service` (Service-layer)
- `@Repository` (DAO-layer)
