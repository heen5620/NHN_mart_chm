package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyListTest {

    @Test
    @DisplayName("올바른 값이 buylist안에 있는지 확인")
    void buylistTest() {
        BuyList buyList = new BuyList();
        BuyList.Item item = new BuyList.Item("참치", 2);
        buyList.add(item);
        Assertions.assertEquals("참치", buyList.getItems().get(0).getName());
        Assertions.assertEquals(2, buyList.getItems().get(0).getAmount());
    }


}