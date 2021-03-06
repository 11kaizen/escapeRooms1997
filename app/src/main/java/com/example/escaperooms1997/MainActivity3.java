package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

// This class holds the functionality of the third room in the game
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

    // This method handles the changes that take place when the closet is clicked
    @SuppressLint("UseCompatLoadingForDrawables")
    public void closetOpen(View view) {
        mediaPlayer = MediaPlayer.create(this,R.raw.open_door);
        mediaPlayer.start();
        // The conditional checks the current state of the closet image view and then makes changes accordingly
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

    //This method concludes the final room.
    public void detonateBomb(View view){
        if(hasShield && hasLighter && hasBomb){
            mediaPlayer = MediaPlayer.create(this,R.raw.explosion);
            mediaPlayer.start();

            door.setVisibility(View.INVISIBLE);
            closet.setVisibility(View.INVISIBLE);
            ConstraintLayout constraintLayout = findViewById(R.id.parentConstraintLayout);
            constraintLayout.setBackground(getResources().getDrawable(R.drawable.background3explosion));

            //Delays the running of the code by 1000ms
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity3.this,MainActivity5.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            }, 1000);
        }
    }

}