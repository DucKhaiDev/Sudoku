package com.duckhaidoit.sudoku.ButtonsGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ButtonsGridView extends GridView {
    public ButtonsGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        ButtonsGridViewAdapter buttonsGridViewAdapter = new ButtonsGridViewAdapter(context);
        setAdapter(buttonsGridViewAdapter);
    }
}
