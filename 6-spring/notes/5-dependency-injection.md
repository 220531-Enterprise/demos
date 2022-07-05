# Spring Dependency Injection
---

## Dependency Injection (DI)

A process whereby objects define their dependencies (that is, the other objects they work with) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control) of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes or a mechanism such as the Service Locator pattern.

---
### Constructor-Based DI

Constructor-based DI is accomplished by the container invoking a constructor with a number of arguments, each representing a dependency. Calling a static factory method with specific arguments to construct the bean is nearly equivalent, and this discussion treats arguments to a constructor and to a static factory method similarly. See `BaseballCoach.java` in the `spring-intro` and `spring-annotations` demo projects.

---
### Setter-Based DI

Setter-based DI is accomplished by the container calling setter methods on your beans after invoking a no-argument constructor or a no-argument static factory method to instantiate your bean. See `FootballCoach.java` in the `spring-intro` and `spring-annotations` demo projects.

---
### Constructor or Setter Injection?

Since you can mix constructor-based and setter-based DI, it is a good rule of thumb to use constructors for mandatory dependencies and setter methods or configuration methods for optional dependencies. Note that use of the @Required annotation on a setter method can be used to make the property be a required dependency. Use the DI style that makes the most sense for a particular class.

---
### Field-Level Injection

Using the `@Autowired` annotation, you can opt to include the annotation on the field declaration. Depending on your needs, you should primarily use constructor injection or some mix of constructor and setter injection. Field injection has many drawbacks and should be avoided. The only advantage of field injection is that it is more convenient to write, which does not outweigh all the cons.

Drawbacks of using Field-Level DI:

- You cannot create immutable objects, as you can with constructor injection

- Your classes have tight coupling with your DI container and cannot be used outside of it

- Your classes cannot be instantiated (for example in unit tests) without reflection. You need the DI container to instantiate them, which makes your tests more like integration tests

- Your real dependencies are hidden from the outside and are not reflected in your interface (either constructors or methods)

---
## References

[Spring Core Technologies Documentation](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html)

[Field Dependency Injection Considered Harmful](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful)
