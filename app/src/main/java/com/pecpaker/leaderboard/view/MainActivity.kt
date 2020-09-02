package com.pecpaker.leaderboard.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.dataSource.remote.ApiService
import com.pecpaker.leaderboard.dataSource.remote.RestClient
import com.pecpaker.leaderboard.model.ModelIQ
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.main_toolbar)
//        setSupportActionBar(toolbar)
        /* supportActionBar!!.setHomeButtonEnabled(true)
         supportActionBar!!.setDisplayHomeAsUpEnabled(true)*/
    }

    companion object {
        fun updateToolBarTitle(activity: Activity, title: String) {
            activity.main_toolbar.title = title

        }

    }
}