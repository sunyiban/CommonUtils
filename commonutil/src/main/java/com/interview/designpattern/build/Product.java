package com.interview.designpattern.build;

/**
 * @autor sunyiban
 * @date 2019/8/30 15:24
 * @descrpition 产品
 */
public class Product {

    private String partA;

    private String partB;

    private String partC;

    public void show() {
        System.out.println(partA + ":" + partB + ":" + partC);
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }
}
