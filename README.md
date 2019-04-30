# spring-exercise2
Create and Learn Spring MVC and Autowiring (Annotations Based)
 1. Clone this project or create a new empty maven project
 1. Add the following dependencies in pom file
     ```
     <properties>
           <org.springframework.version>4.0.2.RELEASE</org.springframework.version>
      </properties>
      <dependencies>
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-context</artifactId>
              <version>${org.springframework.version}</version>
          </dependency>
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-core</artifactId>
              <version>${org.springframework.version}</version>
          </dependency>
      </dependencies>
  1. Create a main class and create the object of Spring Context from which the beans would be fetched.
  1. Create the bean declaration xml config with the following content
    
    ```   
     <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:context = "http://www.springframework.org/schema/context"
            xsi:schemaLocation="
             http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
             http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">
             </beans>
     
  1.  Enable annotations usage 
    
    ```
        <context:annotation-config/>  
  
    ```             
 1. Define the base package from where the spring-aware classes should be fetched
    
    ```
     <context:component-scan base-package="your.base.package.here" />
  
1. Create a well designed MVC Architecture using Spring to get the latest bit coin rate from the api
   ````
   https://api.coindesk.com/v1/bpi/currentprice.json
   
1. If the connectivity to this api fails, the data should be fetched from a local repository. For this project, you can use hard coded data.