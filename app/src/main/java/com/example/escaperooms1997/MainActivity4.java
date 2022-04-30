package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//This class holds the functionality of the first activity that is displayed
public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = new Intent(this, bgMusic.class); //background music begins playing
        startService(intent);
    }

    //Once you tap the screen the game begins.
    public void startTap (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}