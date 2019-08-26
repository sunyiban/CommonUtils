package com.interview.designpattern.decorator;

/**
 * @autor sunyiban
 * @date 2019/8/26 11:04
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Origin origin = new Mogana();
        origin.display();
        Origin origin1 = new WhiteChange(origin);
        origin1.display();

        Origin origin2 = new BlackChange(origin);
        origin2.display();
    }
}
