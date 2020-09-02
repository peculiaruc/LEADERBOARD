package com.pecpaker.leaderboard.dataSource.remote

import com.pecpaker.leaderboard.dataSource.response.LearningLearderResponse
import com.pecpaker.leaderboard.dataSource.response.SkillIQResponse
import com.pecpaker.leaderboard.model.Model
import com.pecpaker.leaderboard.model.ModelIQ
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearningLearderResponse>>

    @GET("api/hours")
    fun getSkillIqLeaders(): Call<List<SkillIQResponse>>
}