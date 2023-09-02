package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현

    public void add(Food food) {
        foods.add(food);
    }

    //      TODO 장바구니에 담은 Food 삭제 구현
    public Food removeFood(String foodName) {
        Iterator<Food> iterator = foods.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String names = iterator.next().getName();
            if (names.equals(foodName)) {
                return foods.remove(count);
            }

            count++;
        }
        throw new IllegalArgumentException("재고가 부족합니다.");
    }

    public boolean getFoodsName(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

  public List<Food> getFood(){
        return foods;
  }
}
