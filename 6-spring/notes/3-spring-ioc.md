# Inversion of Control
---
Inversion of Control is a principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework. IoC enables the framework to take control of the flow of a program and make calls to our custom code. The advantages of this architecture are:

- decoupling the execution of a task from its implementation
- making it easier to switch between different implementations
- greater modularity of a program
- greater ease in testing a program by isolating components

# Spring IOC Container
---
In the Spring framework, the IoC container is represented by the interface `ApplicationContext`. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their lifecycle. There are 24 implementations of the `ApplicationContext` interface, important ones to be familiar with include:

- `ClassPathXmlApplicationContext`
- `AnnotationConfigApplicationContext`
- `WebApplicationContext`

An ApplicationContext provides:

- Bean factory methods, inherited from `ListableBeanFactory`. 
  - This avoids the need for applications to use singletons.


- The ability to resolve messages, supporting internationalization. Inherited from the `MessageSource` interface.


- The ability to load file resources in a generic fashion. Inherited from the ResourceLoader interface.


- The ability to publish events. Implementations must provide a means of registering event listeners.

- Inheritance from a parent context. Definitions in a descendant context will always take priority. 
  - This means, for example, that a single parent context can be used by an entire web application, while each servlet has its own child context that is independent of that of any other servlet.

# What is a bean factory?
---
A bean factory is just that, a implementation of the factory design pattern which is used to create Spring beans. The `BeanFactory` interface is implemented by objects that hold a number of bean definitions, each uniquely identified by a String name. Depending on the bean definition, the factory will return either an independent instance of a the object, or a single shared instance (a singleton scoped to the factory instance). The point of this approach is that the BeanFactory is a central registry of application components, and centralizes configuration of application components.


# Spring Bean Lifecycle
---
1) Instantiation
    - Bean constructor called


2) Populate properties
    - Setter methods of bean properties are called (dependencies must be created prior to bean creation)


3) `BeanNameAware.setBeanName()`
   - Set the name of the bean in the bean factory that created this bean.


2) `BeanClassLoaderAware.setBeanClassLoader()`
   - Callback that supplies the bean class loader to a bean instance.


3) `BeanFactoryAware.setBeanFactory()`
   - Callback that supplies the owning factory to a bean instance.

   
4) `EnvironmentAware.setEnvironment()`
   - Set the `Environment` that this component runs in.


5) `EmbeddedValueResolverAware.setEmbeddedValueResolver()`
   - Set the `StringValueResolver` to use for resolving embedded definition values.


6) `ResourceLoaderAware.setResourceLoader()` (only applicable when running in an application context)
   - Set the `ResourceLoader` that this object runs in.


7) `ApplicationEventPublisherAware.setApplicationEventPublisher()` (only applicable when running in an application context)
   - Set the `ApplicationEventPublisher` that this object runs in.


8) `MessageSourceAware.setMessageSource()` (only applicable when running in an application context)
   - Set the MessageSource that this object runs in.


9) `ApplicationContextAware.setApplicationContext()` (only applicable when running in an application context)
   - Set the ApplicationContext that this object runs in.


10) `ServletContextAware.setServletContext()` (only applicable when running in a web application context)
    - Set the ServletContext that this object runs in.


11) `postProcessBeforeInitialization` methods of `BeanPostProcessors`
    - Apply this BeanPostProcessor to the given new bean instance before any bean initialization callbacks.


12) `InitializingBean.afterPropertiesSet()`
    - Invoked by the containing BeanFactory after it has set all bean properties and satisfied BeanFactoryAware, ApplicationContextAware etc.
    
    - This method allows the bean instance to perform validation of its overall configuration and final initialization when all bean properties have been set.


13) a custom init-method definition
    - Custom bean initialization logic


14) `postProcessAfterInitialization` methods of `BeanPostProcessors`
    - Apply this BeanPostProcessor to the given new bean instance after any bean initialization callbacks


15) At this point, the bean is ready for use by the application.


16) At some point the container will begin to shut down. When this occurs the `DisposableBean.destroy()` method is invoked.


17) a custom destroy-method will be invoked to clean up any custom configuration.

    
![Spring Bean Lifecycle](https://media.geeksforgeeks.org/wp-content/uploads/20200428011831/Bean-Life-Cycle-Process-flow3.png "Spring Bean Lifecycle")


# `ApplicationContext` vs `BeanFactory`
---
As the `ApplicationContext` includes all functionality of the `BeanFactory`, it is generally recommended that it be used in preference to the `BeanFactory`, except in applications where memory consumption might be critical and a few extra kilobytes might make a difference. However, for most 'typical' enterprise applications and systems, the `ApplicationContext` is what you will want to use.

**`BeanFactory` features:**
- bean instantiation/wiring

**`ApplicationContext` features:**
- bean instantiation/wiring
- `ApplicationEvent` publication
- Convenient `MessageSource` access (for i18n - internationalization)
    - internationalization is the process of designing a software application so that it can potentially be adapted to various languages and regions without engineering changes.
