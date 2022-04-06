package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean hasKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hideCarpet(View view) {
        ImageView carpet = findViewById(R.id.carpet);
        carpet.setVisibility(View.GONE);
        carpet.setX(20000000);
        carpet.setY(20000000);
    }

    public void clickKey(View view) {
        hasKey = true;

    }


    public void clickDoor(View view) {
        if(hasKey){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }else{
            ImageView key = findViewById(R.id.key);
            key.setVisibility(View.GONE);
        }
    }
}