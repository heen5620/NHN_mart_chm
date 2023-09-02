package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();
    // TODO add 메서드 생성

    public void add(Item item) {
        //food 이름, 개수를 받아야함.
        items.add(item);
    }

    // 구매 할 목록의 (물건 이름, 양)을 추가하는 메서드
    public static class Item {
        private final String name;
        private final int amount;

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
