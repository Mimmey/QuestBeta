package com.mimmey.quest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterResult  extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Deal> objects;

    AdapterResult(Context context, ArrayList<Deal> products) {
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
            view = lInflater.inflate(R.layout.item_result, parent, false);
        }

        Deal p = getDeal(position);


        ((TextView) view.findViewById(R.id.id)).setText(Integer.toString(p.getNumber()));
        ((TextView) view.findViewById(R.id.name)).setText(p.getName());
        switch(p.getTrueOrNot()){
            case 1: {
                ((TextView) view.findViewById(R.id.isTrue)).setText(R.string.true_);
                break;
            }
            case 0:{
                ((TextView) view.findViewById(R.id.isTrue)).setText(R.string.false_);
                break;
            }
            default:{
                ((TextView) view.findViewById(R.id.isTrue)).setText(R.string.false_);
                break;
            }

        }


        return view;
    }

    Deal getDeal(int position) {
        return ((Deal) getItem(position));
    }
}
