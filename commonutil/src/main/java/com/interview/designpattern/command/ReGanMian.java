package com.interview.designpattern.command;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:49
 * @descrpition
 */
public class ReGanMian implements Breakfast {

    private ReGanMianChef reGanMianChef;

    public ReGanMian(ReGanMianChef reGanMianChef) {
        this.reGanMianChef = reGanMianChef;
    }

    @Override
    public void cooking() {
        System.out.println("热干面准备好了");
        reGanMianChef.cooking();
    }
}
