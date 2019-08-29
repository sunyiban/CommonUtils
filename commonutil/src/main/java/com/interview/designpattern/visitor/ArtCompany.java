package com.interview.designpattern.visitor;

/**
 * @autor sunyiban
 * @date 2019/8/29 11:45
 * @descrpition
 */
public class ArtCompany implements Company {
    @Override
    public String create(Paper paper) {
        return "讲学图";
    }

    @Override
    public String create(Cuprum cuprum) {
        return "青铜像";
    }
}
