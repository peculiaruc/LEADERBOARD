package com.pecpaker.leaderboard.dataSource.response

import com.google.gson.annotations.SerializedName

data class FormResponse(
    @SerializedName("firstname") var firstname: String,
    @SerializedName("lastname") var lastname: String,
    @SerializedName("emailaddress") var emailaddress: String,
    @SerializedName("linktotheproject") var linktotheproject: String
)

