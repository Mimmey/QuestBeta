package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityResult extends AppCompatActivity {

    private ListView lvMain;
    static ArrayList<Deal> deals;
    AdapterResult adapterResult;
    Button button;
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        deals = (ArrayList) databaseAccess.getTrueOrNot();

        databaseAccess.close();
        button = (Button)findViewById(R.id.button);


        // создаем адаптер
        adapterResult = new AdapterResult(this, deals);

        // настраиваем список
        lvMain = (ListView) findViewById(R.id.listView);
        lvMain.setAdapter(adapterResult);

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, characters);
        //this.listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                databaseAccess.open();
                databaseAccess.setFalse();
                databaseAccess.close();
                startActivity(new Intent(ActivityResult.this, ActivityDesktop.class));
            }
        });

    }
}
