package com.mimmey.quest;

public class Character {
    private String name;
    private String secondName;
    private String lastMessage;
    private int points;

    public Character(String name, String secondName, String lastMessage, int points) {
        this.name = name;
        this.secondName = secondName;
        this.lastMessage = lastMessage;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
