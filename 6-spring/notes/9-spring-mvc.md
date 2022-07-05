# Spring MVC

## What is Spring MVC?

Spring Web MVC is a model-view-controller web framework built on the Servlet API. This framework is useful for creating flexible web applications to handle HTTP requests from clients. Packaging for Spring MVC projects will be `war` packaging.


## DispatcherServlet 

The Spring MVC web framework is designed around the front controller pattern where a central servlet, the `DispatcherServlet`, provides a shared algorithm for request processing, while actual work is performed by configurable delegate components. This model is flexible and supports diverse workflows.

The DispatcherServlet, as any Servlet, needs to be declared and mapped according to the Servlet specification by using Java configuration or in `web.xml`. In turn, the DispatcherServlet uses Spring configuration to discover the delegate components it needs for request mapping, view resolution, exception handling, and more.

### Configuring the `DispatcherServlet` using the `web.xml`

	<web-app>
	
	    <listener>
	        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	    </listener>
	
	    <context-param>
	        <param-name>contextConfigLocation</param-name>
	        <param-value>/WEB-INF/app-context.xml</param-value>
	    </context-param>
	
	    <servlet>
	        <servlet-name>DispatcherServlet</servlet-name>
	        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	        <init-param>
	            <param-name>contextConfigLocation</param-name>
	            <param-value></param-value>
	        </init-param>
	        <load-on-startup>1</load-on-startup>
	    </servlet>
	
	    <servlet-mapping>
	        <servlet-name>DispatcherServlet</servlet-name>
	        <url-pattern>/*</url-pattern>
	    </servlet-mapping>
	
	</web-app>

### Spring MVC Configuration using `WebApplicationInitializer` (100% XML-free)

```
@EnableWebMvc
@ComponentScan
@Configuration
public class ApplicationConfig implements  WebMvcConfigurer, WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
        container.register(ApplicationConfig.class);
        
        servletContext.addListener(new ContextLoaderListener(container));
 
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(container));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}

}
```

## Spring MVC Data Flow Diagram

![Spring MVC Data Web Flow](http://3.bp.blogspot.com/-gzDmsQOGbZ8/Uirsbl-UM2I/AAAAAAAAAlo/6VMFghVaMEA/s1600/SpringMVC.jpg)

### Spring MVC Special Bean Types

- `HandlerMapping`
  - Maps a request to a handler along with a list of interceptors for pre- and post-processing. The mapping is based on some criteria, the details of which vary by HandlerMapping implementation.

- `HandlerAdapter`
  - Helps the DispatcherServlet to invoke a handler mapped to a request, regardless of how the handler is actually invoked. For example, invoking an annotated controller requires resolving annotations. The main purpose of a HandlerAdapter is to shield the DispatcherServlet from such details.

- `HandlerExceptionResolver`
  - Strategizes to resolve exceptions, mapping them to handlers, to HTML error views, or other targets.

- `ViewResolver`
  - Resolve logical String-based view names returned from a handler to an actual View with which to render to the response.


## Spring MVC Annotations

- `@Controller`
  - A Spring stereotype annotation that is put at the class level for a presentation-layer class whose methods expose web endpoints.

- `@RequestMapping`
  - Used to expose a resource through a web endpoint
  - Does not specify a specific HTTP verb by default
  - `method` value can be provided to indicate a HTTP verb

- `@GetMapping`
  - Used to expose a resource through a web endpoint specific to HTTP GET requests

- `@PostMapping`
  - Used to expose a resource through a web endpoint specific to HTTP POST requests

- `@PutMapping`
  - Used to expose a resource through a web endpoint specific to HTTP PUT requests

- `@DeleteMapping`
  - Used to expose a resource through a web endpoint specific to HTTP DELETE requests

- `@PathVariable`
  - Used to grab a variable that is a part of the URI path

- `@RequestParam`
  - Used to grab a variable that is defined as a query parameter within the URI

- `@RequestBody`
  - Used to grab a object from the body of the web request

- `@ResponseBody`
  - Used to indicate that the returned value of the controller method will be placed within the body of the web response

- `@ResponseStatus`
  - Used to indicate the HTTP response status code for a controller method

- `@ExceptionHandler`
  - Used to send custom responses back to the client when a controller method throws a specified exception

- `@RestController`
  - Used when creating RESTful APIs using Spring MVC
  - An aggregate annotation that implies `@Controller` on the class level and `@ResponseBody` on each controller method
