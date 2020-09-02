package com.pecpaker.leaderboard.dataSource.response

import com.google.gson.annotations.SerializedName

data class SkillIQResponse(
    @SerializedName("name") var name : String,
    @SerializedName("score") var score : Int,
    @SerializedName("country") var country : String,
    @SerializedName("badgeUrl") var badgeUrl : String
)