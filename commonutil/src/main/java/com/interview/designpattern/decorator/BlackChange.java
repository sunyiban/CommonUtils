package com.interview.designpattern.decorator;

/**
 * @autor sunyiban
 * @date 2019/8/26 11:01
 * @descrpition
 */
public class BlackChange extends IDecorator {
    public BlackChange(Origin origin) {
        super(origin);
    }

    public void display() {
        origin.display();
        changeBlack();
    }

    private void changeBlack() {
        System.out.println("i change to black");
    }
}
