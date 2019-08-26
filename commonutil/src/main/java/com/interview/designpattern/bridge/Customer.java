package com.interview.designpattern.bridge;

/**
 * @autor sunyiban
 * @date 2019/8/26 10:22
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        ICareer iCareer = new ProgrammerImpl();
        AbsPerson absPerson = new Man();
        absPerson.setCareer(iCareer);
        absPerson.getPerson();

        iCareer = new TeacherImpl();
        absPerson.setCareer(iCareer);
        absPerson.getPerson();

    }
}
