package com.example.api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class ApiTestBase {
    protected RequestSpecification requestSpec;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Example base URI
    }

    @BeforeClass
    public void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder()
            .log(LogDetail.ALL) // Log all details of the request
            .build();
    }
    // Method to log response if validation fails will be implicitly part of tests
    // by using .then().log().ifValidationFails() in the test methods themselves
    // or by setting up a default ResponseSpecification.
}
