package com.sk.apipracticetoadvancelevelbysk

import com.sk.apipracticetoadvancelevelbysk.db.RecipesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService2 {

        @GET("recipes")
        fun getRecipes(): Call<RecipesResponse>

}