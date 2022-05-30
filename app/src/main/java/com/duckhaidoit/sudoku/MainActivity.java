package com.duckhaidoit.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playBtn, levelBtn, guideBtn, aboutBtn, quitGameBtn;
    public static int lv = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button) findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GamePlay.class));
            }
        });

        levelBtn = (Button) findViewById(R.id.levelBtn);
        if (lv == 30) {
            levelBtn.setText("LEVEL: EASY");
        }
        else if (lv == 40) {
            levelBtn.setText("LEVEL: MEDIUM");
        }
        else {
            levelBtn.setText("LEVEL: DIFFICULT");
        }
        levelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (levelBtn.getText().toString().equals("LEVEL: EASY")) {
                    levelBtn.setText("LEVEL: MEDIUM");
                    lv = 40;
                }
                else if (levelBtn.getText().toString().equals("LEVEL: MEDIUM")) {
                    levelBtn.setText("LEVEL: DIFFICULT");
                    lv = 50;
                }
                else {
                    levelBtn.setText("LEVEL: EASY");
                    lv = 30;
                }
            }
        });

        guideBtn = (Button) findViewById(R.id.guideBtn);
        guideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Guide.class));
            }
        });

        aboutBtn = (Button) findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
            }
        });

        quitGameBtn = (Button) findViewById(R.id.quitGameBtn);
        quitGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
                System.exit(0);
            }
        });
    }
}