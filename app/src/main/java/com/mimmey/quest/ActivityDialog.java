package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityDialog extends AppCompatActivity {

    private int id;
    private ListView lvMain;
    static ArrayList<Dialog> dialoguesOfCharacter;
    AdapterDialog adapterDialog;
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        this.lvMain = (ListView) findViewById(R.id.listView);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Intent intent = getIntent();
        id = Integer.parseInt(intent.getStringExtra("id")) + 1;
        dialoguesOfCharacter = (ArrayList) databaseAccess.getDialoguesOf(databaseAccess.getFlag(), id);
        databaseAccess.close();

        adapterDialog = new AdapterDialog(this, dialoguesOfCharacter);

        lvMain.setAdapter(adapterDialog);
    }
}

