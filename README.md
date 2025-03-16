# **Calculator REST API**  

## **Description**  
This project is a RESTful API that provides basic calculator functionalities, including addition, subtraction, multiplication, and division. It supports arbitrary precision signed decimal numbers and ensures communication between modules using Apache Kafka.  

## **Functional Requirements**  
Exposes the following operations via REST API using **GET** requests:  

- **`GET /sum?a={value1}&b={value2}`** – Returns the sum of `a` and `b`.  
- **`GET /subtraction?a={value1}&b={value2}`** – Returns the subtraction of `b` from `a`.  
- **`GET /multiplication?a={value1}&b={value2}`** – Returns the product of `a` and `b`.  
- **`GET /division?a={value1}&b={value2}`** – Returns the quotient of `a` divided by `b`.  

Other functionalities:  

- Supports only two operands (`a` and `b`).  
- Works with arbitrary precision signed decimal numbers.  

## **Non-Functional Requirements**  
- Uses **Gradle** with at least two modules:  
  - **rest** (Handles HTTP requests and responses)  
  - **calculator** (Performs the calculations)  
- Built with **Spring Boot**.  
- Uses **Apache Kafka** for communication between modules.  
- Configured via `application.properties` (**Spring Boot standard**).  
- Avoids **XML configuration** (except for logging if necessary).  
- Includes **Docker configuration files** for building images and running the project with **Docker Compose**.  
- Comprehensive **unit tests** to ensure module testability.  
- Uses **Git** for version control.  

## **Bonus Points (Optional Features)**  
- **SLF4J Logging**: Implements **SLF4J** logger with a file-based appender.  
- **Unique Identifiers**: Assigns a unique identifier to each REST request and communicates it via a response header.  
- **MDC Propagation**: Propagates request identifiers through the **MDC** (Mapped Diagnostic Context) for inter-module communication, including it in logging lines related to HTTP requests.  

## **Build and Run Instructions**  

### **Prerequisites**  
Ensure the following dependencies are installed on your system:
-  Java 17 or higher.

- **Docker & Docker Compose**  

### **Clone the Repository**  
```sh
git clone <repository-url>
cd <repository-folder>
```

### **Build and Run the Calculator API**
```sh
./gradlew clean build
docker compose up --build
```

### **JDK Used**
Correto - 17 Amazon corretto 17.0.12
