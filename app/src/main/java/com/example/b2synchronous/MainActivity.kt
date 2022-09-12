package com.example.b2synchronous

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.b2synchronous.model.Student

class MainActivity : AppCompatActivity() {
    lateinit var etName : EditText //declaration
    lateinit var tvMain: TextView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflated -layoutinflater
        etName = findViewById(R.id.etName)
        tvMain = findViewById(R.id.tvMain)
        progressBar = findViewById(R.id.progressBar)
        Log.i(TAG,"im in oncreate")
    }



    fun clickHandler(viewClicked: View) {
        when(viewClicked.id){
            R.id.btnLogin -> {startHomeActivity()}
            R.id.btnDial ->{startDialer()}
            R.id.btnAlarm -> {createAlarm("sync",10,59)}
            R.id.btnDownload -> {downloadImage()}
        }
        print("outside")
    }

    private fun downloadImage() {
        var downloadTask = DownloadTask(progressBar)
        downloadTask.execute("http://imagedownloadurl.com")
    }

    private fun startDialer() {
        var a = 10;
        var b = a * 20;
        add(10,20)

       for(i in 1..10){
           var c = a * i
          var f = 30
           var z =  c + f

       }

        var studentAbdul = Student("abdul",123,5678)
        throw NullPointerException("dial ex")
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456"))
        startActivity(dIntent)
    }

    /**
     * this method adds 2 nos
     */
    private fun add(i: Int, i1: Int) {

    }

    private fun startHomeActivity() {
        Log.e(TAG, "click handler")
        var name = etName.text.toString()

        var hIntent = Intent(this, HomeActivity::class.java)//explicit intent
        //hIntent.putExtra("nkey", name)
        startActivityForResult(hIntent,123)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
//https://developer.android.com/guide/components/intents-common#kotlin


    companion object{
        var TAG = MainActivity::class.java.simpleName
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, dIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, dIntent)
        if(resultCode == RESULT_OK) {
            var contactData = dIntent?.extras?.getString("con")
            tvMain.text = contactData
        }
    }
}