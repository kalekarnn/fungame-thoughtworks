package com.thoughtwork.programming.fungame.external;

import java.io.Serializable;

public class GetChallengeResponse implements Serializable {
    private static final long serialVersionUID = -2331043671439813606L;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
