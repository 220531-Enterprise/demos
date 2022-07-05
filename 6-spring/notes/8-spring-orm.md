# Spring ORM
---

The Spring Framework supports integration with the JPA and supports native Hibernate for resource management, DAO implementations, and transaction strategies. You can configure all of the supported features for ORM tools through Dependency Injection. They can participate in Spring’s resource and transaction management, and they comply with Spring’s generic transaction and DAO exception hierarchies.

#### Benefits Include:
- Easier testing
- Common data access exceptions
- General resource management 
- Integrated transaction management

---
## Contextual Sessions
Hibernate needs some form "contextual sessions", where a given session is in effect throughout the scope of a given context. Since Spring v3 and Hibernate v3, Spring has supported contextual sessions, which are sessions managed directly by Hibernate and active throughout the scope of a transaction. Spring provides transaction management through its `PlatformTransactionManager` object.

Configuration for Spring-Hibernate contextual sessions is fairly straightforward and requires the use of three beans which need to be defined and wired to one another for the container:

1. Data Source (`DriverManagerDataSource`)
    - Provides connection details to allow Hibernate to connect to the DB


2. Session Factory (`LocalSessionFactoryBean`)
    - Leverages the Data Source bean as a dependency
    - Provides configuration to the `SessionFactory` object, such as:
        - base package to scan for entities
        - SQL dialect
        - Show/Format SQL in console
        - Hibernate Mapping to DDL (HBM2DDL)


3. Transaction Manager (`HibernateTransactionManager`)
    - Leverage the Session Factory bean as a dependency
    - Allows Spring to manage transaction isolation, propagation, and state

---
## XML-based Configuration for Spring-Hibernate Contextual Sessions
```
<!-- DataSource bean -->
	<bean id="myDataSource" class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<property name="url" value="jdbc:oracle:thin:@localhost:1521:ORCL" />
		<property name="username" value="admin" />
		<property name="password" value="p4ssw0rd" />
	</bean>
	
	<!-- SessionFactory bean -->
	<bean id="mySessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
		<property name="dataSource" ref="myDataSource" />
		<property name="packagesToScan" value="com.revature" />
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.format_sql">true</prop>
				<prop key="hibernate.hbm2ddl.auto">create</prop>
			</props>
		</property>
	</bean>
	
	<!-- TransactionManager bean -->
	<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
		<property name="sessionFactory" ref="mySessionFactory" />
	</bean>
```

---
## Java Class Configuration for Spring-Hibernate Contextual Sessions
```
@Configuration
@EnableTransactionManagement
public class ApplicationConfig {
 
    @Bean
    public BasicDataSource dataSource() {
    	System.out.println("Creating BasicDataSource bean...");
        BasicDataSource dataSource = new BasicDataSource();
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream dbPropertiesStream = classLoader.getResourceAsStream("app.properties");
        Properties dbProperties = new Properties();
        
        try {
        	dbProperties.load(dbPropertiesStream);
        } catch (FileNotFoundException fnfe) {
        	fnfe.printStackTrace();
        } catch (IOException ioe) {
        	ioe.printStackTrace();
        }
        
        dataSource.setDriverClassName(dbProperties.getProperty("driver"));
        dataSource.setUrl(dbProperties.getProperty("url"));
        dataSource.setUsername(dbProperties.getProperty("username"));
        dataSource.setPassword(dbProperties.getProperty("password"));
        
        System.out.println("DataSource bean successfully created");
        return dataSource;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
    	System.out.println("Creating SessionFactory bean...");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.revature");
        sessionFactory.setHibernateProperties(hibernateProperties());
        System.out.println("SessionFactory bean successfully created");
        return sessionFactory;
    }
 
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
    	System.out.println("Creating PlatformTransactionManager bean...");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        System.out.println("PlatformTransactionManager bean successfully created");
        return transactionManager;
    }
	
	private final Properties hibernateProperties() {
		System.out.println("Loading Hibernate properties");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        System.out.println("Hibernate properties loaded");
        return hibernateProperties;
    }
}
```
---

## Transaction Management

Comprehensive transaction support is among the most compelling reasons to use the Spring Framework. The Spring Framework provides a consistent abstraction for transaction management that delivers the following benefits:

- A consistent programming model across different transaction APIs (JPA, JTA, Hibernate, etc.)
- Support for declarative transaction management.
- A simpler API for programmatic transaction management compared to JTA.
- Excellent integration with Spring’s data access abstractions.

In order to enable `@Transactional` indicates that a persistence method takes place in a transactional context (i.e. on service-layer methods). This annotations allows for declarative transaction management, namely the isolation and propagation levels of the transaction.


---
## Transaction Propagation
Transaction propagation allows developers to specify the behavior of Spring's `PlatformTransactionManager` if a transactional method is executed when a transaction context already exists. A transaction context carries the state of the transaction. The transaction propagations supported in Spring are:
- REQUIRED
- REQUIRES_NEW
- NESTED
- MANDATORY
- NEVER
- NOT_SUPPORTED
- SUPPORTS

#### REQUIRED

`@Transactional(propagation=Propagation.REQUIRED)`
- same physical transaction will be used if one already exists, otherwise a new transaction will be opened

#### REQUIRES_NEW

`@Transactional(propagation=Propagation.REQUIRES_NEW)`
- indicates a new physical transaction will be created for @Transactional method -- inner transaction can commit or rollback independently of the outer transaction

#### NESTED

`@Transactional(propagation=Propagation.NESTED)`
- inner and outer use same physical transaction, but are separated by savepoints (JDBC drivers only)

#### MANDATORY

`@Transactional(propagation=Propagation.MANDATORY)`
- existing transaction must already be opened or container will throw an error

#### NEVER

`@Transactional(propagation=Propagation.NEVER)`
- container will throw an error if a session is open (oppostite of mandatory)

#### NOT_SUPPORTED

`@Transactional(propagation=Propagation.NOT_SUPPORTED)`
- executes outside any existing transaction, current existing transaction will be paused

#### SUPPORTS

`@Transactional(propagation=Propagation.SUPPORTS)`
- executes within the scope of existing transaction
- otherwise, executes non-transactionally 
