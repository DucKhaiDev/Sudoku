package com.duckhaidoit.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class Generator extends MainActivity {
    private static Generator instance;
    private static ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();
    private Random random = new Random();
    private Generator(){
        //
    }

    public static Generator getInstance() {
        if (instance == null) {
            instance = new Generator();
        }
        return instance;
    }

    public int[][] generateGrid() {
        int[][] sudoku = new int[9][9];
        int currentPos = 0;
        while (currentPos < 81) {
            if (currentPos == 0) {
                clearGrid(sudoku);
            }
            if (Available.get(currentPos).size() != 0) {
                int i = random.nextInt(Available.get(currentPos).size());
                int number = Available.get(currentPos).get(i);
                if (!checkConflict(sudoku, currentPos, number)) {
                    int xPos = currentPos % 9;
                    int yPos = currentPos / 9;
                    sudoku[xPos][yPos] = number;
                    Available.get(currentPos).remove(i);
                    currentPos++;
                }
                else {
                    Available.get(currentPos).remove(i);
                }
            }
            else {
                for (int i = 1; i <= 9; i++) {
                    Available.get(currentPos).add(i);
                }
                currentPos--;
            }
    }
        return sudoku;
    }

    public int[][] removeElements(int[][] sudoku) {
        int i = 0;
        while (i < lv) {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if (sudoku[x][y] != 0) {
                sudoku[x][y] = 0;
                i++;
            }
        }
        return sudoku;
    }


    private void clearGrid(int[][] sudoku) {
        Available.clear();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                sudoku[x][y] = -1;
            }
        }
        for (int x = 0; x < 81; x++) {
            Available.add(new ArrayList<Integer>());
            for (int i = 1; i <= 9; i++) {
                Available.get(x).add(i);
            }
        }
    }

    private boolean checkConflict(int[][] sudoku, int currentPos, final int number) {
        int xPos = currentPos % 9, yPos = currentPos / 9;
        if (checkHorizontalConflict(sudoku, xPos, yPos, number) || checkVerticalConflict(sudoku, xPos, yPos, number) || checkRegionConflict(sudoku, xPos, yPos, number)) {
            return true;
        }
        return false;
    }

    private boolean checkHorizontalConflict(final int[][] sudoku, final int xPos, final int yPos, final int number) {
        for (int x = xPos - 1; x >= 0; x--) {
            if (number == sudoku[x][yPos]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVerticalConflict(final int[][] sudoku, final int xPos, final int yPos, final int number) {
        for (int y = yPos - 1; y >= 0; y--) {
            if (number == sudoku[xPos][y]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRegionConflict(final int[][] sudoku, final int xPos, final int yPos, final int number) {
        int xRegion = xPos / 3, yRegion = yPos / 3;
        for (int x = xRegion * 3; x < xRegion * 3 + 3; x++) {
            for (int y = yRegion * 3; y < yRegion *3 + 3; y++) {
                if ((x != xPos || y != yPos) && number == sudoku[x][y]) {
                    return true;
                }
            }
        }
        return false;
    }
}
