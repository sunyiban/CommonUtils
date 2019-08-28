package com.interview.designpattern.state;

/**
 * @autor sunyiban
 * @date 2019/8/28 11:13
 * @descrpition
 */
public abstract class Score {
    protected Integer score;
    protected Context context;
    protected String stateName;
    public abstract void check();
    public void addScore(int addscore) {
        score += addscore;
        System.out.print("加上" + addscore + "分，");
        check();
        System.out.println("现在" + score + "分，当前状态" + context.getScore().stateName);
    }

}
