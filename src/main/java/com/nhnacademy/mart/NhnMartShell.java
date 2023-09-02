package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMartShell {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);
    private static NhnMart mart;

    public static void main(String[] args) {
//        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        logger.info("NHN Mart에 오신것을 환영합니다.");
        mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!

        Customer hyunmyeong = new Customer(buyList);

        // 장바구니를 챙긴다.
        hyunmyeong.bring(mart.provideBasket());

        // 식품을 담는다.
        hyunmyeong.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        hyunmyeong.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        BuyList buyList = new BuyList();
        Scanner sc = new Scanner(System.in);


        System.out.print("> ");
        String line = sc.nextLine();

        String[] arr = line.split(" ");

        for (int i = 0; i < arr.length; i += 2) {
            String name = arr[i];
            int amount = Integer.parseInt(arr[i + 1]);

            if (!mart.getFoodStand().getFoodsName(name)) {
                logger.warn("찾는 식품이 없습니다!");
                throw new IllegalArgumentException("식품매대에 없는 식품입니다.");
            }

            if (amount == 0) {
                logger.warn("0을 입력하셨습니다 물건의 개수를 확인해주세요!");
                throw new IllegalArgumentException("물품의 개수는 0이 되면 안됩니다.");
            }
            buyList.add(new BuyList.Item(name, amount));
        }

        return buyList;
    }

}
