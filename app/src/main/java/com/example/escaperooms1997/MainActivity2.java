package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    private boolean dialClick, mirrorShift;
    ImageView podiumAndBeam;
    ImageView sunDial;
    ImageView mirror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        podiumAndBeam = findViewById(R.id.podiumBeam);
        podiumAndBeam.setVisibility(View.INVISIBLE);
    }

    public void dialTurn(View view) {
        sunDial = findViewById(R.id.sunDial);
        sunDial.setRotation(0f);
        dialClick = true;
        if (dialClick && mirrorShift){
            dispPodiumBeam();
        }
    }

    public void mirrorShift(View view) {
        mirror = findViewById(R.id.mirror);
        mirror.setX(191f);
        mirror.setY(150f);
        mirrorShift = true;
        if (dialClick && mirrorShift){
            dispPodiumBeam();
        }
    }

    public void nextRoom (View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void dispPodiumBeam(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView sunBeam = findViewById(R.id.winSunBeam);
                ImageView doorUnlit = findViewById(R.id.doorUnlit);
                sunDial.setVisibility(View.INVISIBLE);
                mirror.setVisibility(View.INVISIBLE);
                podiumAndBeam.setVisibility(View.VISIBLE);
                sunBeam.setVisibility(View.INVISIBLE);
                doorUnlit.setImageDrawable(getResources().getDrawable(R.drawable.doorlit,getTheme()));
            }
        }, 500);
    }
}