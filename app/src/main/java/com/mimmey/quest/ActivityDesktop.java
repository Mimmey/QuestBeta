package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivityDesktop extends AppCompatActivity{
    ImageButton buttonQuestion;
    ImageButton buttonMarket;
    ImageButton buttonMessenger;
    DatabaseAccess databaseAccess;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);

        databaseAccess = DatabaseAccess.getInstance(this);

        buttonMarket = (ImageButton)findViewById(R.id.buttonMarket);
        buttonMarket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ActivityDesktop.this, ActivityMarket.class));

            }
        });

        buttonMessenger = (ImageButton)findViewById(R.id.buttonMessenger);
        buttonMessenger.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ActivityDesktop.this, ActivityMessenger.class));
            }
        });

        buttonQuestion = (ImageButton)findViewById(R.id.buttonQuestion);
        buttonQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ActivityDesktop.this, ActivityQuestion.class));
            }
        });

        button = (Button)findViewById(R.id.buttonStory);
        databaseAccess.open();
        button.setText(databaseAccess.getStory(databaseAccess.getFlag()));
        databaseAccess.close();

        Intent intent = getIntent();
        switch(intent.getIntExtra("mark", 0)){
            case 2:{
                databaseAccess.open();
                Toast.makeText(ActivityDesktop.this, databaseAccess.getTip(databaseAccess.getFlag()), Toast.LENGTH_SHORT).show();
                databaseAccess.close();
            }
        }

    }
}
