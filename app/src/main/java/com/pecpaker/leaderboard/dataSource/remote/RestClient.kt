package com.pecpaker.leaderboard.dataSource.remote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {


    val BaseUrl = "https://gadsapi.herokuapp.com/"
    val getRetrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    val BASEUrl = "https://docs.google.com/forms/d/e/"
//    val getRetrofit = Retrofit.Builder()
//        .baseUrl(BASEUrl)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()


    fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}