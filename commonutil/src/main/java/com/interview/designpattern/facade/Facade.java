package com.interview.designpattern.facade;

/**
 * @autor sunyiban
 * @date 2019/8/26 14:09
 * @descrpition 外观
 */
public class Facade {
    public void handle() {
        SubSystem subSystem = new SubSystem();
        subSystem.facade();
        SubFacadeA subFacadeA = new SubFacadeA();
        subFacadeA.facade();
    }
}
