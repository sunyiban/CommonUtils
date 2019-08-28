package com.interview.designpattern.responsibility;

/**
 * @autor sunyiban
 * @date 2019/8/28 10:01
 * @descrpition
 */
public class DepartmentHead extends Leader {
    @Override
    public void handle(int days) {
        if (days <= 5) {
            System.out.println("批准了" + days + "天假");
        } else {
            System.out.println("系主任处理不了，给年级主任");
            Leader leader = this.getNext();
            if (leader != null) {
                leader.handle(days);

            } else {
                System.out.println("越权了，无法处理");
            }
        }
    }
}
