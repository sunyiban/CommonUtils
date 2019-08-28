package com.interview.designpattern.observe;

/**
 * @autor sunyiban
 * @date 2019/8/28 14:34
 * @descrpition
 */
public class RMBRate extends Rate {
    @Override
    public void change(int number) {
        for (Company company : companys) {
            company.response(number);
        }
    }
}
