package com.interview.designpattern.expression;

/**
 * @autor sunyiban
 * @date 2019/8/29 15:21
 * @descrpition
 */
public class AndExpression implements Expression {
    private Expression city = null;

    private Expression person = null;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interrept(String info) {
        String s[] = info.split("的");
        return city.interrept(s[0]) && person.interrept(s[1]);
    }
}
