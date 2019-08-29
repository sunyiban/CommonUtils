package com.interview.designpattern.visitor;

/**
 * @autor sunyiban
 * @date 2019/8/29 11:45
 * @descrpition
 */
public class Mint implements Company {
    @Override
    public String create(Paper paper) {
        return "纸币";
    }

    @Override
    public String create(Cuprum cuprum) {
        return "铜币";
    }
}
