package com.pecpaker.leaderboard.dataSource.response

import com.google.gson.annotations.SerializedName

data class LearningLearderResponse(
    @SerializedName("name") var name : String,
    @SerializedName("hours") var hours : Int,
    @SerializedName("country") var country : String,
    @SerializedName("badgeUrl") var badgeUrl : String
)