package com.pecpaker.leaderboard.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pecpaker.leaderboard.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        navController = Navigation.findNavController(this, R.id.fragment)

        tvSubmit.setOnClickListener {
            navController.navigate(R.id.to_submitFragment)
        }
    }


    companion object {

        fun updateToolBarTitle(activity: Activity, title: String) {
            activity.main_toolbar.title = title
        }

        fun hideToolBarTitle(activity: Activity) {
            activity.leaderAppBar.visibility = View.GONE
            activity.submitAppBar.visibility = View.VISIBLE
        }

        fun showBarTitle(activity: Activity) {
            activity.leaderAppBar.visibility = View.VISIBLE
            activity.submitAppBar.visibility = View.GONE
        }

    }
}