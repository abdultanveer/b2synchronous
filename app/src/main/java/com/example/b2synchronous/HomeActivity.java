package com.example.b2synchronous;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b2synchronous.databases.DbOperations;
import com.google.firebase.FirebaseApp;
import com.example.b2synchronous.databases.FeedReaderContract.FeedEntry;

import kotlinx.coroutines.GlobalScope;

public class HomeActivity extends AppCompatActivity {
    EditText etContact;
    TextView tvHome;
    TextView tvAuthor;
    public static String TAG = HomeActivity.class.getSimpleName();
    private FirebaseApp firebaseApp;

    DbOperations dbOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etContact = findViewById(R.id.etContact);
        tvHome = findViewById(R.id.tvHome);
        tvAuthor = findViewById(R.id.tvAuthor);
        firebaseApp = FirebaseApp.initializeApp(this);
        dbOperations = new DbOperations(this);
        dbOperations.openDb();

      /* String name = getIntent().getExtras().getString("nkey");
       tvHome.setText("hello "+name);*/
    }




    public void handleClicks(View viewClicked) {
       // sendContactData();
        switch (viewClicked.getId()){
            case R.id.button2:

                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        throw new RuntimeException("Test Crash") ;
                    }
                }.start();

        //searchBooks();
             //   break;
            case R.id.btnFcm:

                break;
        }

    }

    private void sendContactData() {
        //get the data to be sent
        String contactData = etContact.getText().toString();
        //send the data to the parent activity
        Intent dIntent = new Intent();
        dIntent.putExtra("con",contactData);
        setResult(RESULT_OK,dIntent); //smell-headsup to inform the parent activity
        //close this activity
        finish();
    }


    public void searchBooks(){
        String queryString = etContact.getText().toString();
        new FetchBook(tvHome,tvAuthor).execute(queryString);
    }


    public void dbHandler(View view) {
        switch (view.getId()){
            case R.id.btnCommit:
                EditText etTitle = findViewById(R.id.etTitle);
                EditText etSubtitle = findViewById(R.id.etSubtitle);
                String title = etTitle.getText().toString();
                String subtitle = etSubtitle.getText().toString();
                dbOperations.insertRow(title,subtitle);
                break;
            case R.id.btnRetreive:
               String result = dbOperations.readRow();
               TextView tvResult = findViewById(R.id.tvDbResult);
               tvResult.setText(result);
                break;
        }
    }

    public void insertMyContentProvider(View view) {
        Uri uriSms = Uri.parse("content://sync.todo/entry");
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,"HACP title");
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,"HACP subtitle");
        getContentResolver().insert(uriSms,values);
    }
}