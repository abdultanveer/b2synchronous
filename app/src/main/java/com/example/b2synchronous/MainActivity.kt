package com.example.b2synchronous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickHandler(viewClicked: View) {
        Toast.makeText(this,"welcome to android",Toast.LENGTH_SHORT).show()
    }
}