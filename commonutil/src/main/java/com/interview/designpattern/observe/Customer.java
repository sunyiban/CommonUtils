package com.interview.designpattern.observe;

/**
 * @autor sunyiban
 * @date 2019/8/28 14:38
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Rate rate = new RMBRate();
        Company company = new ImportCompany();
        Company export = new ExportCompany();
        rate.add(company);
        rate.add(export);
        rate.change(10);
        rate.change(-9);
    }
}
