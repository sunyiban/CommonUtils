package com.interview.designpattern.decorator;

/**
 * @autor sunyiban
 * @date 2019/8/26 11:03
 * @descrpition
 */
public class WhiteChange extends IDecorator {
    public WhiteChange(Origin origin) {
        super(origin);
    }

    public void display() {
        origin.display();
        changeWhite();
    }

    private void changeWhite() {
        System.out.println("I change white");
    }
}
