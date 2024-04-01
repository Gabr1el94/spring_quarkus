# Getting Started

## Tools in the Project:

- Java 17;
- Postgresql;
- Spring boot 3;
- Swagger;

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#using.devtools)

## Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## Type Applications

### 1. Compilation jar

**1.1 Build Maven:**
```
 mvn clean install
```

**1.2 Start project:**
```
 java -jar target/simpleproject-0.0.1-SNAPSHOT.jar
```

### 2. CREATE IMAGE NATIVE

#### 2.1 Compilation 'native-image' of graalvm:

**2.1.1 Build:**
```
 native-image -jar target/simpleproject-0.0.1-SNAPSHOT.jar 
```

**2.1.2 Start project:**
```
./simpleproject-0.0.1-SNAPSHOT
```

#### 2.3 Create a native application:

**2.3.1 Build maven native:**

```
mvn -PnativeTest -DskipNativeTests=true -DskipNativeBuild=true -Dagent=true test
```

```
mvn -Pnative native:compile -Dagent=true -DskipTests package
```

**2.3.2 Start project:**

```
 ./target/simpleproject
```