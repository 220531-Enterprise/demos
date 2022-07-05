# Spring Bean Wiring
---
### Manual bean wiring
Manual bean wiring is the process in which a bean's dependencies are associated with the parent bean through explicit configuration. If leveraging constructor injection, this is done in XML configuration by including a `constructor-arg` tag with a bean id specified in the `ref` attribute. If setter injection is done, then the parent bean definition will include a `property` tag that points to the appropriate field in the class declaration, along with a `ref` attribute that uses the appropriate bean id.

---
### Bean Autowiring
If we let Spring scan our packages for us, using component scanning, we do not need to provide explicit bean definitions in an XML file, nor within some configuration class. Instead, Spring will scan the specified package for classes annotated with `@Component` (or another stereotype annotation) and create the bean definitions for them from the class declaration. If the annotated class has any dependencies that need to be managed by Spring, then the `@Autowired` annotation should be used where the dependency is being injected (either a constructor or a setter).

---
### Autowiring Modes

- **no** _(default)_
    - no autowiring. Bean references must be defined by ref elements

- **byType**
    - lets a property be autowired if exactly one bean of the property type exists in the container 
    - if more than one exists, a fatal exception is thrown, which indicates that you may not use byType autowiring for that bean
    - if there are no matching beans, nothing happens (the property is not set)
	
- **byName**
    - autowiring by property name. Spring looks for a bean with the same name as the property that needs to be autowired

- **constructor**
    - analogous to byType but applies to constructor arguments
    - if there is not exactly one bean of the constructor argument type in the container, a fatal error is raised.
	
- **`@Qualifier`**
	- Spring-managed classes can be annotated with `@Qualifier` which can be passed a String as an argument. This String value will be used as an identifier, and allows for the use of the qualifier annotation in conjuction with setter injection to locate the appropriate bean to wire in (Note that the use of `@Qualifier` with constructor injection is not supported).
