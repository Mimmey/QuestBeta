package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityQuestion extends AppCompatActivity {

    Button person1;
    Button person2;
    Button person3;
    private int PERSON_1;
    private int PERSON_2;
    private int PERSON_3;

    DatabaseAccess databaseAccess;
    private List<Character> characters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        databaseAccess = DatabaseAccess.getInstance(this);

        PERSON_1 = 1;
        PERSON_2 = 2;
        PERSON_3 = 3;

        databaseAccess.open();
        characters = (List) databaseAccess.getCharacters(databaseAccess.getFlag());
        databaseAccess.close();

        person1 = (Button)findViewById(R.id.button1);
        person1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                databaseAccess.open();
                databaseAccess.setTipAble(0);
                if(databaseAccess.getAnswer(databaseAccess.getFlag()) == PERSON_1 && databaseAccess.getFlag() < databaseAccess.getMaxFlag()){
                    Toast.makeText(ActivityQuestion.this, R.string.true_, Toast.LENGTH_SHORT).show();
                    databaseAccess.putCoins(databaseAccess.getCoins() + 1);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    databaseAccess.putFlag(databaseAccess.getFlag() + 1);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    databaseAccess.putTipFlag(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityDesktop.class));

                }else if(databaseAccess.getAnswer(databaseAccess.getFlag()) != PERSON_1 && databaseAccess.getFlag() < databaseAccess.getMaxFlag()){
                    Toast.makeText(ActivityQuestion.this, R.string.false_, Toast.LENGTH_SHORT).show();
                    databaseAccess.putFlag(databaseAccess.getFlag() + 1);
                    databaseAccess.putTipFlag(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityDesktop.class));

                }else if(databaseAccess.getFlag() == databaseAccess.getMaxFlag() && databaseAccess.getAnswer(databaseAccess.getFlag()) == PERSON_1){
                    databaseAccess.putTipFlag(1);
                    databaseAccess.putCoins(0);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    databaseAccess.putFlag(1);
                    startActivity(new Intent(ActivityQuestion.this, ActivityResult.class));

                }else{
                    databaseAccess.putTipFlag(1);
                    databaseAccess.putCoins(0);
                    databaseAccess.putFlag(1);
                    startActivity(new Intent(ActivityQuestion.this, ActivityResult.class));

                }
                databaseAccess.close();
            }
        });

        person2 = (Button)findViewById(R.id.button2);
        person2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                databaseAccess.open();
                databaseAccess.setTipAble(0);
                if(databaseAccess.getAnswer(databaseAccess.getFlag()) == PERSON_2 && databaseAccess.getFlag() < databaseAccess.getMaxFlag()){
                    Toast.makeText(ActivityQuestion.this, R.string.true_, Toast.LENGTH_SHORT).show();
                    databaseAccess.putCoins(databaseAccess.getCoins() + 1);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    databaseAccess.putFlag(databaseAccess.getFlag() + 1);
                    databaseAccess.putTipFlag(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityDesktop.class));

                }else if(databaseAccess.getAnswer(databaseAccess.getFlag()) != PERSON_2 && databaseAccess.getFlag() < databaseAccess.getMaxFlag()){
                    Toast.makeText(ActivityQuestion.this, R.string.false_, Toast.LENGTH_SHORT).show();
                    databaseAccess.putFlag(databaseAccess.getFlag() + 1);
                    databaseAccess.putTipFlag(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityDesktop.class));

                }else if(databaseAccess.getFlag() == databaseAccess.getMaxFlag() && databaseAccess.getAnswer(databaseAccess.getFlag()) == PERSON_2){
                    databaseAccess.putTipFlag(1);
                    databaseAccess.putCoins(0);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    databaseAccess.putFlag(1);
                    startActivity(new Intent(ActivityQuestion.this, ActivityResult.class));

                }else{
                    databaseAccess.putTipFlag(1);
                    databaseAccess.putCoins(0);
                    databaseAccess.putFlag(1);
                    startActivity(new Intent(ActivityQuestion.this, ActivityResult.class));


                }
                databaseAccess.close();
            }
        });

        person3 = (Button)findViewById(R.id.button3);
        person3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                databaseAccess.open();
                databaseAccess.setTipAble(0);
                if(databaseAccess.getAnswer(databaseAccess.getFlag()) == PERSON_3 && databaseAccess.getFlag() < databaseAccess.getMaxFlag()){
                    Toast.makeText(ActivityQuestion.this, R.string.true_, Toast.LENGTH_SHORT).show();
                    databaseAccess.putCoins(databaseAccess.getCoins() + 1);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    databaseAccess.putFlag(databaseAccess.getFlag() + 1);
                    databaseAccess.putTipFlag(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityDesktop.class));
                }else if(databaseAccess.getAnswer(databaseAccess.getFlag()) != PERSON_3 && databaseAccess.getFlag() < databaseAccess.getMaxFlag()){
                    Toast.makeText(ActivityQuestion.this, R.string.false_, Toast.LENGTH_SHORT).show();
                    databaseAccess.putFlag(databaseAccess.getFlag() + 1);
                    databaseAccess.putTipFlag(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityDesktop.class));
                }else if(databaseAccess.getFlag() == databaseAccess.getMaxFlag() && databaseAccess.getAnswer(databaseAccess.getFlag()) == PERSON_3){
                    databaseAccess.putTipFlag(1);
                    databaseAccess.putCoins(0);
                    databaseAccess.putFlag(1);
                    databaseAccess.setTrue(databaseAccess.getFlag());
                    startActivity(new Intent(ActivityQuestion.this, ActivityResult.class));

                }else{
                    databaseAccess.putTipFlag(1);
                    databaseAccess.putCoins(0);
                    databaseAccess.putFlag(1);
                    startActivity(new Intent(ActivityQuestion.this, ActivityResult.class));


                }
                databaseAccess.close();
            }
        });


        person1.setText(characters.get(0).getName());
        person2.setText(characters.get(1).getName());
        person3.setText(characters.get(2).getName());


    }
}
