package com.interview.designpattern.build;

/**
 * @autor sunyiban
 * @date 2019/8/30 15:24
 * @descrpition 抽象建造者
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}
