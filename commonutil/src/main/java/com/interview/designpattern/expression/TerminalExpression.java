package com.interview.designpattern.expression;

import java.util.HashSet;
import java.util.Set;

/**
 * @autor sunyiban
 * @date 2019/8/29 15:19
 * @descrpition
 */
public class TerminalExpression implements Expression {

    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
    }

    @Override
    public boolean interrept(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }

}
