package com.mimmey.quest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterDialog extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Dialog> objects;

    AdapterDialog(Context context, ArrayList<Dialog> dialogues) {
        ctx = context;
        objects = dialogues;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view

        Dialog p = getDialog(position);

        View view = convertView;
        if (view == null) {

            switch(p.getIdOfCharacter()){
                case 1:
                    view = lInflater.inflate(R.layout.item_dialog_player, parent, false);
                    break;

                default:
                    view = lInflater.inflate(R.layout.item_dialog_character, parent, false);
                    break;

            }
        }


        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка



        ((TextView) view.findViewById(R.id.text)).setText(p.getText());

        return view;
    }

    // товар по позиции
    Dialog getDialog(int position) {
        return ((Dialog) getItem(position));
    }
}
