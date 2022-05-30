package com.duckhaidoit.sudoku.GameGrid;

import android.content.Context;
import android.widget.Toast;

import com.duckhaidoit.sudoku.Checker;

public class GameGrid {
    private SudokuCell[][] sudokuCells = new SudokuCell[9][9];
    private Context context;

    public GameGrid(Context context) {
        this.context = context;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudokuCells[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudokuCells[x][y].setInitValue(grid[x][y]);
                if (grid[x][y] != 0) {
                    sudokuCells[x][y].setNotModifiable();
                }
            }
        }
    }

    public SudokuCell getItem(int x, int y) {
        return sudokuCells[x][y];
    }

    public SudokuCell getItem(int position) {
        return sudokuCells[position % 9][position / 9];
    }

    public void setItem(int x, int y, int number) {
        sudokuCells[x][y].setValue(number);
    }

    public void checkGame() {
        int[][] sudokuGrid = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudokuGrid[x][y] = getItem(x, y).getValue();
            }
        }
        if (Checker.getInstance().check(sudokuGrid)) {
            Toast.makeText(context, "You won!", Toast.LENGTH_SHORT).show();
        }
    }
}
