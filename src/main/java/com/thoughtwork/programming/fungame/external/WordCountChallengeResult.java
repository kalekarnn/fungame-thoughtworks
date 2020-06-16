package com.thoughtwork.programming.fungame.external;

import java.io.Serializable;

public class WordCountChallengeResult implements Serializable {
    private static final long serialVersionUID = 5635584031856778956L;
    int wordCount;

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
