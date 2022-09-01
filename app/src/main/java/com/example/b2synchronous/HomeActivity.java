package com.example.b2synchronous;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void handleClicks(View viewClicked) {
        Toast.makeText(this,"welcome to android", Toast.LENGTH_SHORT).show();

    }
}