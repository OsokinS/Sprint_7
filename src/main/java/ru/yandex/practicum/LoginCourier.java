package ru.yandex.practicum;

import io.restassured.RestAssured;


import org.junit.Before;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginCourier extends CreateCourier{


    File outLoginCourier = new File("src/test/resources/loginCourier/outLoginCourier.json");
    File missingDataCourier = new File("src/test/resources/loginCourier/missingLoginPasswordCourier.json");

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    public void correctCourierLogin(){
        given()
                .header("Content-type", "application/json")
                .body(loginCurer)
                .post("/api/v1/courier/login")
                .then().assertThat().body("id",notNullValue())
                .and()
                .statusCode(200);
    }


    public void outLoginCourier(){
        given()
                .header("Content-type", "application/json")
                .body(outLoginCourier)
                .post("/api/v1/courier/login")
                .then().assertThat().body("message",equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }

    public void missingDataCourier(){
        given()
                .header("Content-type", "application/json")
                .body(missingDataCourier)
                .post("/api/v1/courier/login")
                .then().assertThat().body("message",equalTo("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
}
