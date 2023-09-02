package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    // 고객 구매 목록
    private final BuyList buyList;
    private final int money = 20000;

    // 고객 장바구니
    private Basket basket;
    private FoodStand foodstand;
    private Counter counter;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {

        for (BuyList.Item item : buyList.getItems()) {
            for (int i = 0; i < item.getAmount(); i++) {
                basket.add(foodStand.removeFood(item.getName()));
            }
        }
    }

    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        int t_price = Counter.pay(basket);
        int account = money - t_price;
        logger.info("총 가격은 " + t_price + " 입니다");
        if (t_price > money) {
            logger.warn("고객님의 보유 금액이 부족합니다.");
            throw new ArithmeticException(money + " 이하로 물품을 골라주세요.");
        }
        logger.info("고객님 결제 후 잔액: " + account);
//        System.out.println("총 가격은 " + t_price + " 입니다");
//        System.out.println("고객님 결제 후 잔액 : " + account);
    }

}
