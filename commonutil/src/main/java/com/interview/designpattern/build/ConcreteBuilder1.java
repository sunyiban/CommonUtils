package com.interview.designpattern.build;

/**
 * @autor sunyiban
 * @date 2019/8/30 15:28
 * @descrpition
 */
public class ConcreteBuilder1 extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("构建A 1");
    }

    @Override
    public void buildPartB() {
        product.setPartB("构建B 1");
    }

    @Override
    public void buildPartC() {
        product.setPartC("构建C 1");
    }
}
