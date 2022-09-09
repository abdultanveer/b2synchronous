package com.example.b2synchronous

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.b2synchronous.model.Student

//no need of extends [:] and implements [,]
class MainActivity : AppCompatActivity(), View.OnFocusChangeListener {
    lateinit var etName : EditText //declaration
    lateinit var tvMain: TextView
    lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflated -layoutinflater
        etName = findViewById(R.id.etName)
        tvMain = findViewById(R.id.tvMain)
        loginButton = findViewById(R.id.btnLogin)

        registerForContextMenu(loginButton)
        Log.i(TAG,"im in oncreate"+ triple(5))

        etName.setOnFocusChangeListener(this)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         super.onCreateOptionsMenu(menu)
       // var menuInflater: MenuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(mItem: MenuItem): Boolean {
         super.onOptionsItemSelected(mItem)
        when(mItem.itemId){
            R.id.mi_settings -> {
                Toast.makeText(this,"opening settings",Toast.LENGTH_SHORT).show()
            }
            R.id.mi_logout -> {
                Toast.makeText(this,"logging out",Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?,v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_context,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
         super.onContextItemSelected(item)
        when(item.itemId){
            R.id.mi_edit -> {
                Toast.makeText(this," editing",Toast.LENGTH_SHORT).show()
            }
            R.id.mi_delete -> {
                Toast.makeText(this,"deleting",Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

    fun clickHandler(viewClicked: View) {
        when(viewClicked.id){
            R.id.btnLogin -> {startHomeActivity()}
            R.id.btnDial ->{startDialer()}
            R.id.btnAlarm -> {createAlarm("sync",10,59)}
            R.id.btnMTest -> {getSetData()}
        }
       // print("outside")
    }

    private fun getSetData() {
        var name = etName.text.toString()
        tvMain.setText(name)
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

    override fun onFocusChange(p0: View?, isFocussed: Boolean) {
        if(isFocussed){
            Toast.makeText(this,"focussed",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"lost focus",Toast.LENGTH_SHORT).show()
        }
    }

    fun double(x: Int): Int {
        return 2 * x
    }

    fun triple(x: Int) =  3 * x

}