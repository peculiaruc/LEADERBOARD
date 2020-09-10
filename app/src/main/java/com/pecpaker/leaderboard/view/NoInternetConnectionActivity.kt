package com.pecpaker.leaderboard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.pecpaker.leaderboard.R

class NoInternetConnectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet_connection)

        val text_nointernetConnetion = findViewById<TextView>(R.id.text_No_Internet)
    }
}