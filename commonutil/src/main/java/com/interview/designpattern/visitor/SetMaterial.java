package com.interview.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor sunyiban
 * @date 2019/8/29 11:47
 * @descrpition
 */
public class SetMaterial implements Material {
    private List<Material> list = new ArrayList<>();

    public void add(Material material) {
        list.add(material);
    }

    public void remove(Material material) {
        list.remove(material);
    }

    @Override
    public String accept(Company company) {
        String result = "";
        for (Material material : list) {
            result += material.accept(company);
        }
        return result;
    }
}
