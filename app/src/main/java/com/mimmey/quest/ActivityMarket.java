package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMarket extends AppCompatActivity {

    Button button;
    DatabaseAccess databaseAccess;
    TextView textView;
    Button tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        databaseAccess = DatabaseAccess.getInstance(this);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textViewCoins);
        databaseAccess.open();
        tip = (Button)findViewById(R.id.buttonText);
        textView.setText(Integer.toString(databaseAccess.getCoins()));

        switch(databaseAccess.getTipAble()){
            case 1: {
                tip.setText(databaseAccess.getTip(databaseAccess.getFlag()));
                break;
            }
            default:{
                tip.setText(R.string.unable);
                break;
            }
        }


        databaseAccess.close();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                databaseAccess.open();
                if(databaseAccess.getCoins() < 2){
                    Toast.makeText(ActivityMarket.this, "НЕ ХВАТАЕТ ДЕНЕГ", Toast.LENGTH_SHORT).show();
                }else if(databaseAccess.getTipFlag() > databaseAccess.getFlag()){
                    Toast.makeText(ActivityMarket.this, "ВЫ УЖЕ БРАЛИ ПОДСКАЗКУ НА ЭТОМ УРОВНЕ", Toast.LENGTH_SHORT).show();
                }else{
                    databaseAccess.putCoins(databaseAccess.getCoins() - 2);
                    databaseAccess.putTipFlag(databaseAccess.getTipFlag() + 1);
                    databaseAccess.setTipAble(1);
                    Intent intent = new Intent(ActivityMarket.this, ActivityDesktop.class);
                    intent.putExtra("mark", 2);
                    textView.setText(Integer.toString(databaseAccess.getCoins()));
                    startActivity(intent);
                }
                databaseAccess.close();

            }
        });

    }
}
