package com.interview.designpattern.bridge;

/**
 * @autor sunyiban
 * @date 2019/8/26 10:12
 * @descrpition 具体实现化
 */
public class TeacherImpl implements ICareer {
    @Override
    public String getCareer() {
        return "teacher";
    }
}
