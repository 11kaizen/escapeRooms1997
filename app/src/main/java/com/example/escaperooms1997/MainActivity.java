package com.example.escaperooms1997;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

// This class handles the functionality of the first room in the game.
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
        carpet.setImageDrawable(getResources().getDrawable(R.drawable.carpetrolledup,getTheme())); // replace carpet with rolled up carpet
        ImageView key = findViewById(R.id.key);
        key.bringToFront();  //Bring key on top in frame layout
        key.setX(150f);
        //Sound player
        mediaPlayer = MediaPlayer.create(this,sounds[2]);
        mediaPlayer.start(); //Play sound
    }

    public void clickKey(View view) {
        hasKey = true;
        //Sound Player
        mediaPlayer = MediaPlayer.create(this,sounds[3]);
        mediaPlayer.start();  //Play sound
        ImageView key = findViewById(R.id.key);
        key.setVisibility(View.GONE);
    }


    public void clickDoor(View view) {
        if(hasKey){
            // Allows user to go to the next room in the game sequence.
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