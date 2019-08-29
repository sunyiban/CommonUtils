package com.interview.designpattern.visitor;

/**
 * @autor sunyiban
 * @date 2019/8/29 11:43
 * @descrpition
 */
public class Paper implements Material {
    @Override
    public String accept(Company company) {
        return company.create(this);
    }
}
