package com.duckhaidoit.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Guide extends Activity {

    private TextView guidetxt;
    private StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("Guide.txt")));
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

        guidetxt = (TextView) findViewById(R.id.guidetxt);
        guidetxt.setText((CharSequence) text);
    }
}
