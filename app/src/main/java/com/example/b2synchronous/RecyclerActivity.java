package com.example.b2synchronous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] languages = new String[]{"english","hindi","urdu","kannada","tamil","telgu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView rView = findViewById(R.id.languagesRview);
    }
}