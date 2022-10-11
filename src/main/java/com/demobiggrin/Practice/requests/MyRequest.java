package com.demobiggrin.Practice.requests;

public class MyRequest {
    private String name;
    private int roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                '}';
    }
}
