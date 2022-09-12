package com.example.b2synchronous;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();


    @Override //this doInBackground will execute its body on a seperate thread
    protected Bitmap doInBackground(String... url) {
        Log.i(TAG,"downloading from "+ url[0]);
        return null;
    }
}
