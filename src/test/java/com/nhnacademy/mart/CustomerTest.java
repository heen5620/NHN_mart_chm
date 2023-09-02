package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("Stock 보다 많은 buylist Test")
    public void test() {
        BuyList buyList = new BuyList();
        FoodStand foodStand = new FoodStand();
        Customer customer = new Customer(buyList);
        Basket basket = new Basket();

        buyList.add(new BuyList.Item("참치", 10));

        foodStand.add(new Food("참치", 22));

        customer.bring(basket);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            customer.pickFoods(foodStand);
        });
    }

}