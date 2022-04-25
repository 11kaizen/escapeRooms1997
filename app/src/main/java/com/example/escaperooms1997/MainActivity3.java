package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity3 extends AppCompatActivity {
    private ImageView closet, lighter, shield, bomb, door;
    private boolean hasShield, hasLighter, hasBomb;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Initialization of objects
        closet = findViewById(R.id.closet);
        shield = findViewById(R.id.shield);
        bomb = findViewById(R.id.bomb);
        door = findViewById(R.id.door);

        //initialization of lighter and sets it to invisible
        lighter = findViewById(R.id.lighter);
        lighter.setVisibility(View.INVISIBLE);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void closetOpen(View view) {
        if(closet.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.closetclosed).getConstantState())){
            closet.setImageDrawable(getResources().getDrawable(R.drawable.closetopen,getTheme()));
            if(!hasLighter){lighter.setVisibility(View.VISIBLE);}

        } else{
            closet.setImageDrawable(getResources().getDrawable(R.drawable.closetclosed,getTheme()));
            if(!hasLighter){lighter.setVisibility(View.INVISIBLE);}
        }
    }

    public void getLighter(View view) {
        lighter.setVisibility(View.GONE);
        hasLighter = true;
    }

    public void getShield(View view){
        shield.setVisibility(View.GONE);
        hasShield = true;
    }

    public void getBomb(View view){
        bomb.setVisibility(View.GONE);
        hasBomb = true;
    }

    public void detonateBomb(View view){
        if(hasShield && hasLighter && hasBomb){
            mediaPlayer = MediaPlayer.create(this,R.raw.explosion);
            mediaPlayer.start();

            door.setVisibility(View.INVISIBLE);
            closet.setVisibility(View.INVISIBLE);
            ConstraintLayout constraintLayout = findViewById(R.id.parentConstraintLayout);
            constraintLayout.setBackground(getResources().getDrawable(R.drawable.background3explosion));

            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
        }
    }

}