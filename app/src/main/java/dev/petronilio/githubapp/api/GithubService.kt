package dev.petronilio.githubapp.api

import dev.petronilio.githubapp.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("users/{user}")
    fun findUser(@Path("user") user: String)
            : Call<User>
}