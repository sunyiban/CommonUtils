package com.interview.designpattern.state;

/**
 * @autor sunyiban
 * @date 2019/8/28 11:12
 * @descrpition
 */
public class Context {
    private Score score;

    public Context() {
        score = new LowScore(this);
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void add(int addscore) {
        score.addScore(addscore);
    }
}
