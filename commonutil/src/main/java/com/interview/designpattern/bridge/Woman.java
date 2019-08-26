package com.interview.designpattern.bridge;

/**
 * @autor sunyiban
 * @date 2019/8/26 10:15
 * @descrpition 具体抽象化
 */
public class Woman extends AbsPerson {
    @Override
    void getPerson() {
        System.out.println("A woman " + iCareer.getCareer());
    }
}
