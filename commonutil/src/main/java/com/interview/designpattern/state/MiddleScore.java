package com.interview.designpattern.state;

/**
 * @autor sunyiban
 * @date 2019/8/28 11:51
 * @descrpition
 */
public class MiddleScore extends Score {

    public MiddleScore(Score score) {
        this.context = score.context;
        this.score = score.score;
        this.stateName = "及格";
    }

    @Override
    public void check() {
        if (score >= 90) {
            context.setScore(new HighScore(this));
        } else if (score < 60) {
            context.setScore(new LowScore(this));
        }
    }
}
