package com.sk.apipracticetoadvancelevelbysk.model

import com.sk.apipracticetoadvancelevelbysk.servece.StudentApiSerice
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceStudent {
    private const val BASE_URL = "http://localhost:4000/api/"

    val api: StudentApiSerice by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentApiSerice::class.java)
    }
}
