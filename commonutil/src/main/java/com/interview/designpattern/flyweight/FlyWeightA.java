package com.interview.designpattern.flyweight;

/**
 * @autor sunyiban
 * @date 2019/8/26 14:51
 * @descrpition
 */
public class FlyWeightA implements IFlyWeight {

    private String key;

    public FlyWeightA(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建");
    }

    @Override
    public void handle(UnShareFlyWeight unShareFlyWeight) {
        System.out.println("享元" + key + "创建成功，非享元信息:" + unShareFlyWeight.getInfo());
    }
}
