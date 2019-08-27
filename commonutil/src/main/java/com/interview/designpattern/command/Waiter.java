package com.interview.designpattern.command;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:57
 * @descrpition
 */
public class Waiter {
    private Breakfast changfen, reganmian;

    public Breakfast getChangfen() {
        return changfen;
    }

    public void setChangfen(Breakfast changfen) {
        this.changfen = changfen;
    }

    public Breakfast getReganmian() {
        return reganmian;
    }

    public void setReganmian(Breakfast reganmian) {
        this.reganmian = reganmian;
    }

    public void chooseChangFen() {
        System.out.println("上一份肠粉");
        changfen.cooking();
    }

    public void chooseReGanMian() {
        System.out.println("上一份热干面");
        reganmian.cooking();
    }
}
