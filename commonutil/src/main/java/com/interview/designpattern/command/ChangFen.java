package com.interview.designpattern.command;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:48
 * @descrpition
 */
public class ChangFen implements Breakfast {

    private ChangFenChef receive;

    public ChangFen(ChangFenChef receive) {
        this.receive = receive;
    }

    @Override
    public void cooking() {
        System.out.println("肠粉准备好了");
        receive.cooking();
    }
}
