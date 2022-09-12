package com.example.b2synchronous;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();

    ProgressBar mProgressBar;

    public DownloadTask(ProgressBar progressBar){
        mProgressBar = progressBar;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override //this doInBackground will execute its body on a seperate thread
    protected Bitmap doInBackground(String... url) {
        Log.i(TAG,"downloading from "+ url[0]);
        for(int i=1; i<100; i++) {
            try {
                Thread.sleep(150);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... percentDownloaded) {
        super.onProgressUpdate(percentDownloaded);
        mProgressBar.setProgress(percentDownloaded[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}
