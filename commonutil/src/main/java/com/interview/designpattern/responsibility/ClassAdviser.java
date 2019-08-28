package com.interview.designpattern.responsibility;

/**
 * @autor sunyiban
 * @date 2019/8/28 9:58
 * @descrpition
 */
public class ClassAdviser extends Leader {
    @Override
    public void handle(int days) {
        if (days <= 2) {
            System.out.println("批准" + days + "天假");
        } else {
            System.out.println("班主任处理不了，给系主任");
            Leader leader = this.getNext();
            if (leader != null) {
                leader.handle(days);

            } else {
                System.out.println("越权了，没人处理");
            }
        }
    }
}
