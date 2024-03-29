package com.duckhaidoit.sudoku.GameGrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SudokuCell extends com.duckhaidoit.sudoku.GameGrid.BaseSudokuCell {
    private Paint paint;
    public SudokuCell(Context context) {
        super(context);

        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawNumber(canvas);
        drawLines(canvas);
    }

    private void drawNumber(Canvas canvas) {
        paint.setColor(Color.parseColor("#768591"));
        paint.setTextSize(60);
        paint.setStyle(Paint.Style.FILL);
        Rect bounds = new Rect();
        paint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);
        if (getValue() != 0) {
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width()) / 2, (getHeight() + bounds.height()) / 2, paint);
        }
    }

    private void drawLines(Canvas canvas) {
        paint.setColor(Color.parseColor("#EFEEF1"));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }
}
