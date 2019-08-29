package com.interview.designpattern.visitor;

/**
 * @autor sunyiban
 * @date 2019/8/29 11:44
 * @descrpition
 */
public class Cuprum implements Material {
    @Override
    public String accept(Company company) {
        return company.create(this);
    }
}
