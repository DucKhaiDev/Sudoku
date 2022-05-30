package com.duckhaidoit.sudoku.GameGrid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.duckhaidoit.sudoku.GameEngine;

public class SudokuGridViewAdapter extends BaseAdapter {
    private Context context;

    public SudokuGridViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 81;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return GameEngine.getInstance().getGrid().getItem(position);
    }
}
