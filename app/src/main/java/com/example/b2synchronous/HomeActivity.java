package com.example.b2synchronous;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText etContact;
    TextView tvHome;
    SmsReceiver smsReceiver;
    public static String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etContact = findViewById(R.id.etContact);
        tvHome = findViewById(R.id.tvHome);

      /* String name = getIntent().getExtras().getString("nkey");
       tvHome.setText("hello "+name);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
         smsReceiver = new SmsReceiver();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(smsReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(smsReceiver);
    }

    public void handleClicks(View viewClicked) {
        //get the data to be sent
        String contactData = etContact.getText().toString();
        //send the data to the parent activity
        Intent dIntent = new Intent();
        dIntent.putExtra("con",contactData);
        setResult(RESULT_OK,dIntent); //smell-headsup to inform the parent activity
        //close this activity
        finish();

    }


    public void serviceHandler(View view) {
        Intent serviceIntent = new Intent(this,CateringService.class);
        switch (view.getId()){
            case R.id.btnStart:
                serviceIntent.putExtra("mkey","musicfilename.mp3");
                startService(serviceIntent);
                break;
            case R.id.btnStop:
                stopService(serviceIntent);
                break;
            case R.id.btnBind:
                bindService(serviceIntent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbind:
                unbindService(serviceConnection);
                break;
        }
    }

   // CateringService cateringService = new CateringService(); //im not going to create a service
    CateringService cateringService;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            CateringService.LocalBinder localBinder = (CateringService.LocalBinder) binder;
            cateringService = localBinder.getService();
            Log.i(TAG, "sum of 10,43 is: "+ cateringService.add(10,43));
            Log.i(TAG, "latest ads are: "+cateringService.getAds());

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}