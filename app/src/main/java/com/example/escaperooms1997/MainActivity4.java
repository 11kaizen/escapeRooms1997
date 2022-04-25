package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = new Intent(this, bgMusic.class);
        startService(intent);
    }

    public void startTap (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}