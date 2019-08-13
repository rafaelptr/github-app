package dev.petronilio.githubapp.model

import com.google.gson.annotations.SerializedName

data class User(
    val name: String,
    @SerializedName("avatar_url") val avatarURL: String
)