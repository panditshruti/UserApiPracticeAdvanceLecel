package com.sk.apipracticetoadvancelevelbysk

import com.sk.apipracticetoadvancelevelbysk.db.Company
import com.sk.apipracticetoadvancelevelbysk.db.User
import com.sk.apipracticetoadvancelevelbysk.db.UserResponse
import com.sk.apipracticetoadvancelevelbysk.db.UserX
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<UserResponse>
}