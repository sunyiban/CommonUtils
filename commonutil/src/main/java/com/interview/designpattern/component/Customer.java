package com.interview.designpattern.component;

/**
 * @autor sunyiban
 * @date 2019/8/27 14:48
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Commodity commodity = new Shoping("老干妈", 12, 2);
        Commodity commodity1 = new Shoping("鸭", 30, 3);
        Commodity commodity2 = new Shoping("鸡", 40, 1);
        Bag redBag = new Bag();
        Bag whiteBag = new Bag();

        redBag.add(commodity);
        whiteBag.add(commodity1);
        whiteBag.add(commodity2);

        Bag bigBag = new Bag();
        bigBag.add(redBag);
        bigBag.add(whiteBag);

        bigBag.show();
        System.out.println("共计" + bigBag.calculate() + "元");
    }
}
