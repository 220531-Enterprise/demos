# Spring Bean Scopes

## Explanation

When the `ApplicationContext` starts, it uses either an XML configuration file or component scanning to discover what Java classes (beans) it needs to manage for us. Once it discovers these beans, it will create bean defintions, which are just instructions for creating the bean. These definitions are stored in the bean container. The method in which Spring creates these beans is dependent upon the declared scope of the bean (using `scope` attribute on the `<bean>` tag in XML configuration, or using the `@Scope` annotation). If no specific scope is declared, then the default scope is singleton. The scopes which beans can be declared in are:

- **singleton** _(default)_
  - The Spring Container creates only one instance of the bean
  - This bean is cached into memory
  - All requests for the bean will return a shared reference to the same bean

- **prototype**
  - Creates a new bean instance for each container request

- **request**
  - Bean is scoped to an HTTP web request
  - Only used in web applications

- **session**
  - Bean is scoped to an HTTP web session
  - Only used in web applications

- **application**
  - Scopes a single bean definition to the lifecycle of a `ServletContext`
  - Only used in web applications

- **websocket**
  - Scopes a single bean definition to the lifecycle of a `WebSocket`
  - Only used in web applications
