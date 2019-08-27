package com.interview.designpattern.component;

/**
 * @autor sunyiban
 * @date 2019/8/27 14:40
 * @descrpition
 */
public class Shoping implements Commodity {

    private String name;
    private Integer price;
    private Integer num;

    public Shoping(String name, Integer price, Integer num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    @Override
    public double calculate() {
        return num * price;
    }

    @Override
    public void show() {
        System.out.println("购买了" + num + "件" + name + ", 共花费" + calculate() + "元");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
