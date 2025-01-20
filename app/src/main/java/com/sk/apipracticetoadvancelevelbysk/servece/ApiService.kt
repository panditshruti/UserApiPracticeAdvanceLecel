package com.sk.apipracticetoadvancelevelbysk.servece

import com.sk.apipracticetoadvancelevelbysk.db.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<UserResponse>
}