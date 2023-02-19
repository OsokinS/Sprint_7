package ru.yandex.practicum;

import org.junit.Test;




public class TestCheckCreateOrder extends DataEntryCreateOrder {


    DataEntryCreateOrder dataEntryCreateOrder = new DataEntryCreateOrder();



    @Test
    public void createOrderBlackColor(){
        dataEntryCreateOrder.onlyBlackColor();
    }

    @Test
    public void createOrderGreyColor(){
        dataEntryCreateOrder.onlyGreyColor();
    }

    @Test
    public void createOrderBlackAndGreyColor(){
        dataEntryCreateOrder.greyAndBlackColor();
    }

    @Test
    public void createOrderOutColor(){
        dataEntryCreateOrder.orderOutColor();
    }
}
