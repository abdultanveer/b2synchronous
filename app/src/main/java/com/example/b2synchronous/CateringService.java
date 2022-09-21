package com.example.b2synchronous;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CateringService extends Service {
    public static String TAG = CateringService.class.getSimpleName();
    private final IBinder binder = new LocalBinder();

    public CateringService() {
    }

    int add(int fno, int sno){
        return fno + sno;
    }

    String getAds(){
        return "this is the latest add from server";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
         String filename = intent.getStringExtra("mkey");
        Log.i(TAG, "onStartCommand: "+filename);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mymusic);
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder {
        CateringService getService() {
            // Return this instance of LocalService so clients can call public methods
            return CateringService.this;
        }
    }
}