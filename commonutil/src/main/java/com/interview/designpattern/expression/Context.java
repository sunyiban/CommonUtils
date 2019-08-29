package com.interview.designpattern.expression;

/**
 * @autor sunyiban
 * @date 2019/8/29 15:22
 * @descrpition
 */
public class Context {
    public String[] citys = {"韶关", "广州"};

    public String[] persons = {"老人", "妇女", "儿童"};

    public Expression cityPerson;

    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }

    public void freeRide(String info) {
        boolean ok = cityPerson.interrept(info);
        if (ok) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
        }
    }
}
