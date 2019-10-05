package com.mimmey.quest;

public class Deal {

    private int number;
    private String name;
    public int trueOrNot;

    public Deal(int number, String name, int trueOrNot) {
        this.number = number;
        this.name = name;
        this.trueOrNot = trueOrNot;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrueOrNot() {
        return trueOrNot;
    }

    public void setTrueOrNot(int trueOrNot) {
        this.trueOrNot = trueOrNot;
    }
}
