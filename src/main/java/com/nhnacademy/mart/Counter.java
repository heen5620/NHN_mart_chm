package com.nhnacademy.mart;

public class Counter {
    public static int pay(Basket basket) {
        int res = 0;

        for (Food food : basket.getFoods()) {
            res += food.getPrice();
        }
        return res;
    }
}


