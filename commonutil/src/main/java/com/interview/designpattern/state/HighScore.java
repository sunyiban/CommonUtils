package com.interview.designpattern.state;

/**
 * @autor sunyiban
 * @date 2019/8/28 11:54
 * @descrpition
 */
public class HighScore extends Score {

    public HighScore(Score score) {
        this.context = score.context;
        this.score = score.score;
        this.stateName = "优秀";
    }

    @Override
    public void check() {
        if (score < 60) {
            context.setScore(new LowScore(this));
        } else if (score < 90) {
            context.setScore(new MiddleScore(this));
        }
    }
}
