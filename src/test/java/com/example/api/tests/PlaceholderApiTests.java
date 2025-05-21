package com.example.api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo; // Import for equalTo

public class PlaceholderApiTests extends ApiTestBase { // Ensure it extends ApiTestBase

    @Test
    public void testGetPostById() {
        RestAssured.given()
            .spec(requestSpec) // Use the requestSpec from ApiTestBase
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200)
            .body("userId", equalTo(1)) // Make sure to import equalTo
            .log().ifValidationFails(); // Log response if validation fails
    }
}
