package com.duckhaidoit.sudoku;

import android.content.Context;

import com.duckhaidoit.sudoku.GameGrid.GameGrid;

public class GameEngine {
    private static GameEngine instance;
    private GameGrid grid = null;
    private int selectedPosX = -1, selectedPosY = -1;

    private GameEngine(){
        //
    }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    public void creatGrid(Context context) {
        int[][] sudoku = Generator.getInstance().generateGrid();
        sudoku = Generator.getInstance().removeElements(sudoku);
        grid = new GameGrid(context);
        grid.setGrid(sudoku);
    }

    public GameGrid getGrid() {
        return grid;
    }

    public void setSelectedPosition(int x, int y) {
        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNumber(int number) {
        if (selectedPosX != -1 && selectedPosY != -1) {
            grid.setItem(selectedPosX, selectedPosY, number);
        }
        grid.checkGame();
    }
}
