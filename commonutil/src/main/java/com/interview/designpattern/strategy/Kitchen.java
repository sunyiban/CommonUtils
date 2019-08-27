package com.interview.designpattern.strategy;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:06
 * @descrpition
 */
public class Kitchen {

    private CrabCooking crabCooking;

    public Kitchen(CrabCooking crabCooking) {
        this.crabCooking = crabCooking;
    }

    public CrabCooking getCrabCooking() {
        return crabCooking;
    }

    public void setCrabCooking(CrabCooking crabCooking) {
        this.crabCooking = crabCooking;
    }

    public void cook() {
        crabCooking.cooking();
    }
}
