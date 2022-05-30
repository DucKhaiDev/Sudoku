package com.duckhaidoit.sudoku.ButtonsGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.duckhaidoit.sudoku.GameEngine;

public class NumberButton extends Button implements View.OnClickListener {
    private int number;

    public NumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        GameEngine.getInstance().setNumber(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
