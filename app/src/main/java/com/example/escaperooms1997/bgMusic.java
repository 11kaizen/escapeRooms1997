package com.example.escaperooms1997;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class bgMusic extends Service {

    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate()
    {
        mp = MediaPlayer.create(this, R.raw.intro_song);
        mp.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mp.start();
        mp.setVolume(0.3f,0.3f);
        return START_STICKY;
    }
    @Override
    public void onDestroy()
    {
        mp.stop();
    }
}
