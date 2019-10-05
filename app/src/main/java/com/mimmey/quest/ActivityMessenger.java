package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMessenger extends AppCompatActivity {

    private ListView lvMain;
    static ArrayList<Character> characters;
    AdapterCharacter adapterCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        characters = (ArrayList) databaseAccess.getCharacters(databaseAccess.getFlag());
        databaseAccess.close();

        // создаем адаптер
        adapterCharacter = new AdapterCharacter(this, characters);

        // настраиваем список
        lvMain = (ListView) findViewById(R.id.listView);
        lvMain.setAdapter(adapterCharacter);

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, characters);
        //this.listView.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityMessenger.this, ActivityDialog.class);
                intent.putExtra("id", Integer.toString(position));
                startActivity(intent);
            }
        });


    }


    }

