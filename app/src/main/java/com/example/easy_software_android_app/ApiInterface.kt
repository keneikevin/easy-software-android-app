package com.example.easy_software_android_app

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiInterface {
    @GET("users")
    fun getData(): Call<List<UserItem>>


    @PUT("users/:id")
    fun putUserRequest(@Path("id") id: String, @Body userItem: UserItem): Response<UserItem>
}