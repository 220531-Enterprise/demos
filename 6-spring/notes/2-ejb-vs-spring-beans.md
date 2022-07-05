# Spring Beans vs Enterprise Java Beans
---
## Enterprise Java Beans (EJBs)
Simply put, an Enterprise Java Bean is a Java class with one or more annotations from the EJB spec which grant the class special powers when running inside of an EJB container.

- [Resource on EJBs](https://stackify.com/enterprise-java-beans/) (not super important, since we will not be working with EJBs)

---
## The Problem with EJBs
	
- Early versions of J2EE's Enterprise Java Beans (EJBs) were extremely complex
  - Multiple deployment descriptors were necessary
  - Developers had to define and implement multiple interfaces
  - After all the overhead was complete, the performance of the entity beans was poor

- The community still did J2EE web development, but without the use of EJBs
  - This led to the development of the Spring Framework

---
## Timeline:
	
- **1999** - _J2EE 1.2 released_

- **2001** - _J2EE 1.3 released_

- **2003** - _J2EE 1.4 released_

- **2004** - _Spring 1.0 released_

- **2006** - _Java EE 5 & Spring 2.0 released_
  - Sun Microsystems refactored EJB framework to be easier to use
  - Essentially becomes equivalent to Spring in functionality
				
- **2009** - _Java EE 6 & Spring 3.0 released_
	
- **2013** - _Java EE 7 & Spring 4.0 released_
	
- **2016** - _Java EE 8 & Spring 4.3 released_
	
- **2017** - _Spring 5.0 released_
  - Requires Java 8 at minimum
  - Deprecates legacy libraries: Tiles, Velocity, Portlets, etc.
  - Upgraded Spring MVC to use new versions of Servlet API 4.0
  - Added new reactive programming framework: Spring WebFlux
  - [Release Notes](https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html)
