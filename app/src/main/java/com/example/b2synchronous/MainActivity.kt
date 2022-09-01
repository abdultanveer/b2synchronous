package com.example.b2synchronous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etName : EditText //declaration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflated -layoutinflater
        etName = findViewById(R.id.etName)
    }

    fun clickHandler(viewClicked: View) {
       // var name: String = etName.text.toString()
        var name = etName.text.toString()
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
    }
}