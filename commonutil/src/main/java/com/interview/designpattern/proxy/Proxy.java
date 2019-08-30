package com.interview.designpattern.proxy;

/**
 * @autor sunyiban
 * @date 2019/8/30 16:32
 * @descrpition
 */
public class Proxy {
    private Specialty specialty;

    public Proxy(Specialty specialty) {
        this.specialty = specialty;
    }

    public void disPlay() {
        preRequest();
        specialty.display();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问实体预前处理");
    }

    public void postRequest() {
        System.out.println("访问实体后续处理");
    }
}
