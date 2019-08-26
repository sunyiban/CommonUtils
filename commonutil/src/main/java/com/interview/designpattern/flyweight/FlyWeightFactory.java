package com.interview.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor sunyiban
 * @date 2019/8/26 14:53
 * @descrpition
 */
public class FlyWeightFactory {
    private Map<String, IFlyWeight> map = new HashMap<>();

    public IFlyWeight createFlyWeight(String key) {
        IFlyWeight iFlyWeight = map.get(key);
        if (iFlyWeight == null) {
            iFlyWeight = new FlyWeightA(key);
            map.put(key, iFlyWeight);
        } else {
            System.out.println("享元" + key + "已被创建，直接获取成功");
        }
        return iFlyWeight;
    }

}
