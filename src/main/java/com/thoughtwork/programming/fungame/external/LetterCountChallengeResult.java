package com.thoughtwork.programming.fungame.external;

import java.io.Serializable;

public class LetterCountChallengeResult implements Serializable {
    private static final long serialVersionUID = 4890256258644713027L;
    int count;

    public LetterCountChallengeResult() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
