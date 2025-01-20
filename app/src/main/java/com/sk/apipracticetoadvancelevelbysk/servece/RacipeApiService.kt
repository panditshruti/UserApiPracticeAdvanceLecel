package com.sk.apipracticetoadvancelevelbysk.servece

import com.sk.apipracticetoadvancelevelbysk.db.RecipesResponse
import retrofit2.Call
import retrofit2.http.GET

interface RacipeApiService {

        @GET("recipes")
        fun getRecipes(): Call<RecipesResponse>

}