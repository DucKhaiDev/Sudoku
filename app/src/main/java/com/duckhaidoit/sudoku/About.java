package com.duckhaidoit.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.duckhaidoit.sudoku.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class About extends Activity {
    private TextView aboutTxt;
    private StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("About.txt")));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
            reader.close();
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        aboutTxt = (TextView) findViewById(R.id.aboutTxt);
        aboutTxt.setText((CharSequence) text);
    }
}