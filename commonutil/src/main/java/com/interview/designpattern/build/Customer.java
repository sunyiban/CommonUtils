package com.interview.designpattern.build;

/**
 * @autor sunyiban
 * @date 2019/8/30 15:30
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder1();
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        Product product1 = builder.getResult();

        builder = new ConcreteBuilder2();
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        Product product2 = builder.getResult();

        product1.show();

        product2.show();

    }
}
