package com.sk.apipracticetoadvancelevelbysk.model

import com.sk.apipracticetoadvancelevelbysk.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

        private const val BASE_URL = "https://dummyjson.com/"

        val api: ApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
