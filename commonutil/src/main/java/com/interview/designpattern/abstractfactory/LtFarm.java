package com.interview.designpattern.abstractfactory;

/**
 * @autor sunyiban
 * @date 2019/8/30 14:49
 * @descrpition
 */
public class LtFarm implements Farm {
    @Override
    public Animal createAnimal() {
        System.out.println("创建了一头驴");
        return new Donkey();
    }

    @Override
    public Plant createPlant() {
        System.out.println("创建了一棵树");
        return new Tree();
    }
}
