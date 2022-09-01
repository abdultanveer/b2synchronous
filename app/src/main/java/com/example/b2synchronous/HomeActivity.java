package com.example.b2synchronous;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText etContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etContact = findViewById(R.id.etContact);
    }

    public void handleClicks(View viewClicked) {
        String name = etContact.getText().toString();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();

    }
}