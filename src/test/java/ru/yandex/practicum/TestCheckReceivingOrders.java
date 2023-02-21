package ru.yandex.practicum;

import org.junit.Test;

public class TestCheckReceivingOrders extends Orders{
    Orders orders = new Orders();


    @Test
    public void checkRecevingOrders(){
        orders.correctCreateCourier();
    }
}
