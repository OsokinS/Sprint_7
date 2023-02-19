package ru.yandex.practicum;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.After;
import org.junit.Before;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class CreateCourier {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
        clearCourierData();
    }

    File accurat = new File("src/test/resources/createCourier/accurat.json");
    File loginCurer = new File("src/test/resources/loginCourier/loginCourier.json");
    File outLogin = new File("src/test/resources/createCourier/createCourierOutFieldLogin.json");
    File outFirstName = new File("src/test/resources/createCourier/createCourierOutFieldFirstName.json");

    public void correctCreateCourier() {
        given()
                .header("Content-type", "application/json")
                .body(accurat)
                .post("/api/v1/courier")
                .then().assertThat().body("ok", equalTo(true))
                .and()
                .statusCode(201);
    }


    public void exceptionCreateIdenticalAccounts(){
        given()
                .header("Content-type", "application/json")
                .body(accurat)
                .post("/api/v1/courier")
                .then().assertThat().body("message", equalTo("Этот логин уже используется"))
                .and()
                .statusCode(409);
    }


    public void createOutFieldLogin(){
        given()
                .header("Content-type", "application/json")
                .body(outLogin)
                .post("/api/v1/courier")
                .then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }


    public void createCourierOutFieldFirstName(){
        given()
                .header("Content-type", "application/json")
                .body(outFirstName)
                .post("/api/v1/courier")
                .then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }



    @After
    public void clearCourierData(){

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(loginCurer)
                        .post("/api/v1/courier/login");

        if (response.path("id") != null){
            response.then().assertThat().body("id",notNullValue())
                    .and()
                    .statusCode(200);

            given()
                    .delete("/api/v1/courier/"+ response.then().extract().path("id"))
                    .then().assertThat().body("ok",equalTo(true))
                    .and()
                    .statusCode(200);
        }
    }
}
