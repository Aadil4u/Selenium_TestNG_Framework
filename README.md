# Selenium TestNG Framework

This project demonstrates a framework for UI automation using Selenium and TestNG. It also includes capabilities for API automation using REST Assured.

## Features

*   Page Object Model (POM) for UI tests.
*   Data-driven testing using Excel.
*   Custom listeners for logging and reporting.
*   Integration with ExtentReports for test reporting.
*   Browser factory for managing multiple browsers.
*   API automation using REST Assured.

## Project Structure

*   `src/main/java`: Contains base classes, helper utilities, page objects, and browser factory.
*   `src/test/java`: Contains test cases for UI and API automation.
*   `src/main/resources`: Contains configuration files like `log4j2.xml`.
*   `configuration`: Contains environment-specific configuration files.
*   `testdata`: Contains test data files (e.g., Excel sheets).
*   `test-suite`: Contains TestNG XML suite files for running tests.

## UI Automation

(Details about UI automation setup, writing tests, and running them would go here.)

## API Automation

### API Automation Overview

This framework integrates REST Assured for testing RESTful APIs. REST Assured is a Java DSL that simplifies testing of REST services.

### Project Structure for API Tests

*   `src/test/java/com/example/api/tests`: This package contains all API test classes.
*   `ApiTestBase.java`: Located in the `com.example.api.tests` package, this base class can be used to define common setup for API tests, such as base URI and request specifications (e.g., logging).

### Writing API Tests

API tests are written as TestNG tests. You can use REST Assured's fluent API to send requests and validate responses.

**Example (conceptual, see `PlaceholderApiTests.java` for a working example):**

```java
package com.example.api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class ExampleApiTests extends ApiTestBase {

    @Test
    public void testGetUserDetails() {
        RestAssured.given()
            .spec(requestSpec) // Using requestSpec from ApiTestBase for logging
            .when()
            .get("/users/2") // Assuming baseURI is set in ApiTestBase
            .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .log().ifValidationFails(); // Log response if validation fails
    }
}
```

### Running API Tests

API tests are executed using TestNG. A dedicated TestNG suite file, `testng-api.xml`, is provided in the project root to run all tests in the `com.example.api.tests` package.

To run the API tests:
1.  Ensure your Maven environment is set up.
2.  You can run the tests via your IDE by right-clicking on `testng-api.xml` and selecting "Run" or "Debug".
3.  Alternatively, you can run them via Maven command line:
    ```bash
    mvn test -DsuiteFile=testng-api.xml
    ```
    (Note: The `maven-surefire-plugin` in `pom.xml` might need to be configured or a different command used if `suiteFile` property is not set up globally).

### Dependencies

The core dependency for API automation is REST Assured, which has been added to the `pom.xml` file:

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.0</version> <!-- Or the specific version used -->
    <scope>test</scope>
</dependency>
```

## Setup and Execution

1.  **Prerequisites:**
    *   Java JDK (version 11 or higher recommended)
    *   Apache Maven

2.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd Selenium_TestNG_Framework
    ```

3.  **Running Tests:**
    *   **All tests (UI and potentially API if configured in `allTest.xml`):**
        ```bash
        mvn test -DsuiteFile=allTest.xml
        ```
    *   **Only API tests:**
        ```bash
        mvn test -DsuiteFile=testng-api.xml
        ```
    *   **Specific UI test suite (example):**
        (Assuming you have other suite files like `testng-ui.xml`)
        ```bash
        mvn test -DsuiteFile=your-ui-suite.xml
        ```

    Test reports will be generated in the `target/surefire-reports` directory and/or `ExtentReports` directory if configured.

## Configuration

*   Browser type, application URL, and other settings can be configured in `configuration/config.properties`.
*   Logging is configured in `src/main/resources/log4j2.xml`.

## Contributing

Contributions are welcome. Please fork the repository and submit a pull request.
```
