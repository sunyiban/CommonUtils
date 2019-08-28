package com.interview.designpattern.state;

/**
 * @autor sunyiban
 * @date 2019/8/28 11:30
 * @descrpition
 */
public class LowScore extends Score {

    public LowScore(Context context) {
        this.context = context;
        score = 0;
        stateName = "不及格";
    }

    public LowScore(Score score) {
        this.context = score.context;
        this.score = score.score;
        stateName = "不及格";
    }

    @Override
    public void check() {
        if (score >= 90) {
            context.setScore(new HighScore(this));
        } else if(score >= 60) {
            context.setScore(new MiddleScore(this));
        }
    }
}
