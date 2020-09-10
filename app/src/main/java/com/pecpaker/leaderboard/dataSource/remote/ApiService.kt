package com.pecpaker.leaderboard.dataSource.remote

import com.pecpaker.leaderboard.dataSource.response.LearningLearderResponse
import com.pecpaker.leaderboard.dataSource.response.SkillIQResponse
import com.pecpaker.leaderboard.dataSource.response.SubmitButtonResponse
import com.pecpaker.leaderboard.model.Model
import com.pecpaker.leaderboard.model.ModelIQ
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearningLearderResponse>>

    @GET("api/skilliq")
    fun getSkillIqLeaders(): Call<List<SkillIQResponse>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitForm(
        @Field("entry.1877115667") name: String,
        @Field("entry.2006916086") lastname: String,
        @Field("entry.1824927963") emailaddress: String,
        @Field("entry.284483984") linktoproject: String
    ): Call<Void>

    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<SubmitButtonResponse>


}