package com.thoughtwork.programming.fungame.external;

import java.io.Serializable;

public class SentenceCountChallengeResult implements Serializable {
    private static final long serialVersionUID = -2723721153870192019L;
    int sentenceCount;

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }
}
