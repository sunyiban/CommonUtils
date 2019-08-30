package com.interview.designpattern.abstractfactory;

/**
 * @autor sunyiban
 * @date 2019/8/30 14:50
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Farm farm = new SgFarm();
        farm.createAnimal();
        farm.createPlant();

        farm = new LtFarm();
        farm.createAnimal();
        farm.createPlant();
    }
}
