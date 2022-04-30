package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

//This class holds the functionality of the second room of the game
public class MainActivity2 extends AppCompatActivity {
    private int[] sounds = {R.raw.metal_door, R.raw.dial_move, R.raw.mirror_pickup, R.raw.level2complete}; //holds sounds id's
    private MediaPlayer mediaPlayer;
    private boolean dialClick, mirrorShift;
    private ImageView podiumAndBeam,sunDial,mirror;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        podiumAndBeam = findViewById(R.id.podiumBeam);
        podiumAndBeam.setVisibility(View.INVISIBLE);
    }

    public void dialTurn(View view) {
        sunDial = findViewById(R.id.sunDial);
        sunDial.setRotation(0f);//sets the barrel into an upright position
        mediaPlayer = MediaPlayer.create(this,sounds[1]);
        mediaPlayer.start(); // Play sound
        dialClick = true;
        if (dialClick && mirrorShift){
            dispPodiumBeam();
        }
    }

    public void mirrorShift(View view) {
        mirror = findViewById(R.id.mirror);
        mirror.setX(191f);
        mirror.setY(150f);
        mediaPlayer = MediaPlayer.create(this,sounds[2]);
        mediaPlayer.start();// Play sound
        mirrorShift = true;
        if (dialClick && mirrorShift){
            dispPodiumBeam();
        }
    }

    public void nextRoom (View view){
        if (dialClick&&mirrorShift) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }else{
            mediaPlayer = MediaPlayer.create(this, sounds[0]);
            mediaPlayer.start();
        }
    }

    // This method is initiated when both the mirror and barrel are in position.
    public void dispPodiumBeam(){
        mediaPlayer = MediaPlayer.create(this,sounds[3]);
        mediaPlayer.start();
        // This section delays running the code so that the sound and the image happen at around the same time.
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView sunBeam = findViewById(R.id.winSunBeam);
                ImageView doorUnlit = findViewById(R.id.doorUnlit);
                sunDial.setVisibility(View.INVISIBLE); //hide image
                mirror.setVisibility(View.INVISIBLE);
                podiumAndBeam.setVisibility(View.VISIBLE);
                sunBeam.setVisibility(View.INVISIBLE);
                doorUnlit.setImageDrawable(getResources().getDrawable(R.drawable.doorlit,getTheme()));
            }
        }, 4000); //the delay duration
    }
}