package com.duckhaidoit.sudoku.GameGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.duckhaidoit.sudoku.GameEngine;

public class SudokuGridView extends GridView {
    private final Context context;
    public SudokuGridView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);
        setAdapter(gridViewAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;

                GameEngine.getInstance().setSelectedPosition(x, y);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
