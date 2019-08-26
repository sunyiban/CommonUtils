package com.interview.designpattern.bridge;

/**
 * @autor sunyiban
 * @date 2019/8/26 10:13
 * @descrpition 抽象化
 */
public abstract class AbsPerson {

    protected ICareer iCareer;

    public void setCareer(ICareer iCareer) {
        this.iCareer = iCareer;
    }

    abstract void getPerson();

}
