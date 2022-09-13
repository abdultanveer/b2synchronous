package com.example.b2synchronous

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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
            R.id.btnNotify -> {showNotification()}
        }
        print("outside")
    }

    private fun showNotification() {
        createNotificationChannel()
        val intent = Intent(this, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(com.google.android.material.R.drawable.ic_clock_black_24dp)
            .setContentTitle("sync-3")
            .setContentText("android kotlin training")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.ic_baseline_snooze_24, "snooze",
                pendingIntent)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(123,builder.build())

        /*with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(123, builder.build())}*/

    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "sync promos chan name"
                //getString(R.string.channel_name)
            val descriptionText = "this shows notifications wrt sync promos"
                //getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
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