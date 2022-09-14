package com.example.b2synchronous;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

public class HomeActivity extends AppCompatActivity {
    EditText etContact;
    TextView tvHome;
    TextView tvAuthor;
    public static String TAG = HomeActivity.class.getSimpleName();
    private FirebaseApp firebaseApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etContact = findViewById(R.id.etContact);
        tvHome = findViewById(R.id.tvHome);
        tvAuthor = findViewById(R.id.tvAuthor);
        firebaseApp = FirebaseApp.initializeApp(this);

      /* String name = getIntent().getExtras().getString("nkey");
       tvHome.setText("hello "+name);*/
    }


    public void handleClicks(View viewClicked) {
       // sendContactData();
        switch (viewClicked.getId()){
            case R.id.button2:
                searchBooks();
                break;
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



}