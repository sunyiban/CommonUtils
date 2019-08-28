package com.interview.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor sunyiban
 * @date 2019/8/28 14:31
 * @descrpition
 */
public abstract class Rate {
    protected List<Company> companys = new ArrayList<>();

    public void add(Company company) {
        companys.add(company);
    }

    public void remove(Company company) {
        companys.remove(company);
    }

    public abstract void change(int number);
}
