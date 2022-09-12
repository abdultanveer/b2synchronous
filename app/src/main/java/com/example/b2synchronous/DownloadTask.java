package com.example.b2synchronous;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();

    ProgressBar mProgressBar;

    public DownloadTask(ProgressBar progressBar){
        mProgressBar = progressBar;
    }


    @Override //this doInBackground will execute its body on a seperate thread
    protected Bitmap doInBackground(String... url) {
        Log.i(TAG,"downloading from "+ url[0]);
        publishProgress(50);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... percentDownloaded) {
        super.onProgressUpdate(percentDownloaded);
        mProgressBar.setProgress(percentDownloaded[0]);
    }
}
