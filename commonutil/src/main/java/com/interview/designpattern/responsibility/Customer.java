package com.interview.designpattern.responsibility;

/**
 * @autor sunyiban
 * @date 2019/8/28 10:05
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Leader leader = new ClassAdviser();
        Leader depart = new DepartmentHead();
        leader.setNext(depart);

        leader.handle(7);
    }
}
