package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean hasKey;
    private int[] sounds = {R.raw.metal_door,R.raw.open_door,R.raw.ruglift,R.raw.ding}; //holds sounds id's
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void liftCarpet(View view) {
        ImageView carpet = findViewById(R.id.carpet);
        carpet.setImageDrawable(getResources().getDrawable(R.drawable.carpetrolledup,getTheme()));
        ImageView key = findViewById(R.id.key);
        mediaPlayer = MediaPlayer.create(this,sounds[2]);
        mediaPlayer.start(); //Play sound
        key.bringToFront();
        key.setX(150f);
    }

    public void clickKey(View view) {
        hasKey = true;
        mediaPlayer = MediaPlayer.create(this,sounds[3]);
        mediaPlayer.start();  //Play sound
        ImageView key = findViewById(R.id.key);
        key.setVisibility(View.GONE);
    }


    public void clickDoor(View view) {
        if(hasKey){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            mediaPlayer = MediaPlayer.create(this,sounds[1]);
            mediaPlayer.start();
        }else{
            mediaPlayer = MediaPlayer.create(this,sounds[0]);
            mediaPlayer.start();
        }
    }
}