package com.interview.designpattern.Responsibility;

/**
 * @autor sunyiban
 * @date 2019/8/28 10:03
 * @descrpition
 */
public class GardeDean extends Leader {
    @Override
    public void handle(int days) {
        if (days <= 10) {
            System.out.println("批准了" + days + "天假");
        } else {

            Leader leader = this.getNext();
            if (leader != null) {
                leader.handle(days);
            } else {
                System.out.println("越权了，没人能处理");
            }
        }
    }
}
