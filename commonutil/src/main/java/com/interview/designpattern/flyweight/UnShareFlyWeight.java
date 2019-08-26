package com.interview.designpattern.flyweight;

/**
 * @autor sunyiban
 * @date 2019/8/26 14:50
 * @descrpition 非共享信息
 */
public class UnShareFlyWeight {

    private String info;

    public UnShareFlyWeight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
