package com.duckhaidoit.sudoku;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class GamePlay extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);

        com.duckhaidoit.sudoku.GameEngine.getInstance().creatGrid(this);
    }
}
