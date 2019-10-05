package com.mimmey.quest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCharacter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Character> objects;

    AdapterCharacter(Context context, ArrayList<Character> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_messenger, parent, false);
        }

        Character p = getCharacter(position);

        switch(p.getPoints()){

            case 1:{
                ((TextView) view.findViewById(R.id.name)).setText(p.getName());
                ((TextView) view.findViewById(R.id.lastMessage)).setText(p.getLastMessage());
                ((ImageView) view.findViewById(R.id.image)).setImageResource(R.drawable.ic_woman);
                break;
                }
            case 2:{
                ((TextView) view.findViewById(R.id.name)).setText(p.getName());
                ((TextView) view.findViewById(R.id.lastMessage)).setText(p.getLastMessage());
                ((ImageView) view.findViewById(R.id.image)).setImageResource(R.drawable.ic_man);
                break;
                }

            default:{
                ((TextView) view.findViewById(R.id.name)).setText(p.getName());
                ((TextView) view.findViewById(R.id.lastMessage)).setText(p.getLastMessage());
                ((ImageView) view.findViewById(R.id.image)).setImageResource(R.drawable.ic_man);
                break;
                }
        }

        return view;
    }

    Character getCharacter(int position) {
        return ((Character) getItem(position));
    }

}
