package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {

    /*
    1. Food가 잘 들어가는지
    2. food를 추가하고 잘 제거 되는지 테스트
     */
    @Test
    @DisplayName("정상 추가되는지 확인")
    void correctTest() {
        FoodStand foodStand = new FoodStand();
        Food food = new Food("참치", 2000);
        foodStand.add(food);

        Assertions.assertTrue(foodStand.getFoodsName("참치"));
    }

    @Test
    @DisplayName("제거 테스트")
    void removeTesdt() {
        FoodStand foodStand = new FoodStand();
        Food food1 = new Food("참치", 2000);
        Food food2 = new Food("고등어", 1000);
        foodStand.add(food1);
        foodStand.add(food2);

        foodStand.removeFood("참치");
        Assertions.assertEquals(1, foodStand.getFood().size());

    }
}