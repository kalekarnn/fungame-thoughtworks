package com.thoughtwork.programming.fungame.external;

import java.io.Serializable;

public class VowelCountChallengeResult implements Serializable {
    private static final long serialVersionUID = -4580752004467556402L;
    int a;
    int e;
    int i;
    int o;
    int u;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "VowelCountChallengeResult{" +
                "a=" + a +
                ", e=" + e +
                ", i=" + i +
                ", o=" + o +
                ", u=" + u +
                '}';
    }
}
