package com.mimmey.quest;

public class Dialog {
    private String text;
    private int idOfCharacter;

    public Dialog(int idOfCharacter, String text){
        this.text = text;
        this.idOfCharacter = idOfCharacter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdOfCharacter() {
        return idOfCharacter;
    }

    public void setIdOfCharacter(int idOfCharacter) {
        this.idOfCharacter = idOfCharacter;
    }
}
