package com.example.b2synchronous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class NewsActivity : AppCompatActivity(), HeadlinesFragment.HeadlinesClickListener{  //appliance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }

    override fun onHeadlineClicked(headline: String) {
        Toast.makeText(this,headline, Toast.LENGTH_SHORT).show()
        var newsContentFragment = supportFragmentManager.findFragmentById(R.id.contentFrag) as NewsContentFragment
        newsContentFragment.setHeadline(headline)

    }
}