package ru.yandex.practicum;

import org.junit.Test;




public class TestCheckLoginCourier extends LoginCourier{

    CreateCourier createCourier = new CreateCourier();
    LoginCourier loginCourier = new LoginCourier();

    @Test
    public void checkCorrectLogin(){
        createCourier.correctCreateCourier();
        loginCourier.correctCourierLogin();
        createCourier.clearCourierData();
    }


    @Test
    public void checkOutLoginCourier(){
        createCourier.correctCreateCourier();
        loginCourier.outLoginCourier();
        createCourier.clearCourierData();
    }

    @Test
    public void checkMissingLoginPasswordCourier(){
        loginCourier.missingDataCourier();
    }
}
