package com.thoughtwork.programming.fungame.external;

import java.io.Serializable;

public class SubmitChallengeResponse implements Serializable {

    private static final long serialVersionUID = 8270914585006275108L;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
