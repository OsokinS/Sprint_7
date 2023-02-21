package ru.yandex.practicum;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class DataEntryCreateOrder extends CreateOrder {


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    CreateOrder createOrdersBlackColor = new CreateOrder("Naruto","Uchiha","Konoha","4","+7 800 355 35 35", 5, "2020-06-06","Saske, come back to Konoha", List.of("BLACK"));
    CreateOrder createOrdersGreyColor = new CreateOrder("Naruto","Uchiha","Konoha","4","+7 800 355 35 35", 5, "2020-06-06","Saske, come back to Konoha", List.of("GREY"));
    CreateOrder createOrdersGreyAndBlackColor = new CreateOrder("Naruto","Uchiha","Konoha","4","+7 800 355 35 35", 5, "2020-06-06","Saske, come back to Konoha", List.of("GREY","BLACK"));
    CreateOrder createOrdersOutColor = new CreateOrder("Naruto","Uchiha","Konoha","4","+7 800 355 35 35", 5, "2020-06-06","Saske, come back to Konoha", null);



    public void greyAndBlackColor (){

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(createOrdersGreyAndBlackColor).log()
                        .all().post("/api/v1/orders");

        System.out.println(response.asString());
        response .then().assertThat().body("track",notNullValue())
                .and()
                .statusCode(201);
    }

    public void onlyBlackColor (){

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(createOrdersBlackColor).log()
                        .all().post("/api/v1/orders");

        System.out.println(response.asString());
        response .then().assertThat().body("track",notNullValue())
                .and()
                .statusCode(201);
    }
    public void onlyGreyColor (){

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(createOrdersGreyColor).log()
                        .all().post("/api/v1/orders");

        System.out.println(response.asString());
        response .then().assertThat().body("track",notNullValue())
                .and()
                .statusCode(201);
    }

    public void orderOutColor(){
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(createOrdersOutColor).log()
                        .all().post("/api/v1/orders");

        System.out.println(response.asString());
        response .then().assertThat().body("track",notNullValue())
                .and()
                .statusCode(201);
    }
}
