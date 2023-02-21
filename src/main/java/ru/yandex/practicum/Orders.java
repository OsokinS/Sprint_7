package ru.yandex.practicum;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Before;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class Orders {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }


    public void correctCreateCourier() {
        given()
                .get("/api/v1/orders")
                .then().assertThat().body("orders", notNullValue())
                .and()
                .statusCode(200);
    }

}
