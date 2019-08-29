package com.interview.designpattern.visitor;

/**
 * @autor sunyiban
 * @date 2019/8/29 11:55
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        SetMaterial setMaterial = new SetMaterial();
        setMaterial.add(new Paper());
        setMaterial.add(new Cuprum());
        System.out.println(setMaterial.accept(new ArtCompany()));;
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(setMaterial.accept(new Mint()));;
    }
}
