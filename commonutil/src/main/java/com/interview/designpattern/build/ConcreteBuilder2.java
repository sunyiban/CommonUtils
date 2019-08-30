package com.interview.designpattern.build;

/**
 * @autor sunyiban
 * @date 2019/8/30 15:29
 * @descrpition
 */
public class ConcreteBuilder2 extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("构建A 2");
    }

    @Override
    public void buildPartB() {
        product.setPartB("构建B 2");
    }

    @Override
    public void buildPartC() {
        product.setPartC("构建C 2");
    }
}
