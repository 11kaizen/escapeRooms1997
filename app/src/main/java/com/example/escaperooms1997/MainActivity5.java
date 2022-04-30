package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//This is the final activity in the game
public class MainActivity5 extends AppCompatActivity {
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }

    public void endGame(View view){
        Intent intent = new Intent(this, bgMusic.class);
        stopService(intent); // Stops the service that runs the background music.
        finishAffinity(); //terminates the app
    }


}