package com.mimmey.quest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Dialog> getAllDialogues() {
        List<Dialog> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM dialogues", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dialog dialog = new Dialog(Integer.parseInt(cursor.getString(1)), cursor.getString(2));
            list.add(dialog);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Dialog> getDialoguesOf(int _idOfGame, int _idOfCharacter) {
        List<Dialog> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM dialogues_" + Integer.toString(_idOfGame) + "_" + Integer.toString(_idOfCharacter), null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dialog dialog = new Dialog(Integer.parseInt(cursor.getString(1)), cursor.getString(2));
            list.add(dialog);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int getAnswer(int _id){
        Cursor cursor = database.rawQuery("SELECT answer FROM answers where _id = " + Integer.toString(_id), null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public int getFlag(){
        Cursor cursor = database.rawQuery("SELECT value FROM structure where _id = 2", null);
        cursor.moveToFirst();
        return Integer.parseInt(cursor.getString(0));
    }

    public void putFlag(int flag){
        this.database.execSQL("UPDATE structure SET value = " + Integer.toString(flag) + " WHERE _id = 2");
    }

    public void putCoins(int coins){
        this.database.execSQL("UPDATE structure SET value = " + Integer.toString(coins) + " WHERE _id = 1");
    }

    public int getCoins(){
        Cursor cursor = database.rawQuery("SELECT value FROM structure where _id = 1", null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public int getMaxFlag(){
        Cursor cursor = database.rawQuery("SELECT value FROM structure where _id = 3", null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public int getTipFlag(){
        Cursor cursor = database.rawQuery("SELECT value FROM structure where _id = 4", null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public void putTipFlag(int coins){
        this.database.execSQL("UPDATE structure SET value = " + Integer.toString(coins) + " WHERE _id = 4");
    }

    public String getTip(int _id){
        Cursor cursor = database.rawQuery("SELECT text FROM tips where _id = " + Integer.toString(_id), null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public int getTipAble(){
        Cursor cursor = database.rawQuery("SELECT value FROM structure where _id = 5", null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public String getStory(int _id){
        Cursor cursor = database.rawQuery("SELECT text FROM story where _id = " + Integer.toString(_id), null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public void setTipAble(int able){
        this.database.execSQL("UPDATE structure SET value = " + Integer.toString(able) + " WHERE _id = 5");
    }

    public void addDialogue(int _id, String element) {
        this.database.execSQL("INSERT INTO " + "dialogues_" + Integer.toString(_id) + " values (NULL, " + Integer.toString(_id) + ", " + "'" + element + "'" + ")");
    }

    public List<Deal> getTrueOrNot(){
        List<Deal> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM is_true", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Deal deal = new Deal(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            list.add(deal);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public void setTrue(int _id){
        this.database.execSQL("UPDATE is_true SET flag = 1 WHERE _id = " + Integer.toString(_id));

    }

    public void setFalse(){
        this.database.execSQL("UPDATE is_true SET flag = 0 WHERE flag != 0");

    }

    public List<Character> getCharacters(int _id) {
        List<Character> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM characters_" + Integer.toString(_id), null);
        cursor.moveToFirst();
        cursor.moveToNext();
        while (!cursor.isAfterLast()) {
            Character character = new Character(cursor.getString(1), cursor.getString(2), null, cursor.getInt(3));
            list.add(character);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}