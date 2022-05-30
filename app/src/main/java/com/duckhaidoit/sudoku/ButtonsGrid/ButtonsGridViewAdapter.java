package com.duckhaidoit.sudoku.ButtonsGrid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.duckhaidoit.sudoku.R;

public class ButtonsGridViewAdapter extends BaseAdapter {
    private Context context;

    public ButtonsGridViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.button, parent, false);
            NumberButton button;
            button = (NumberButton) view;
            button.setId(position);
            button.setTextColor(Color.parseColor("#768591"));
            button.setBackgroundResource(R.drawable.button_border_game_play);
            button.setWidth(5);
            button.setHeight(5);
            if (position != 9) {
                button.setText(String.valueOf(position + 1));
                button.setTextSize(16);
                button.setNumber(position + 1);
            }
            else {
                button.setText("DEL");
                button.setTextSize(12);
                button.setWidth(100);
                button.setNumber(0);
            }
            return button;
        }
        return view;
    }
}
