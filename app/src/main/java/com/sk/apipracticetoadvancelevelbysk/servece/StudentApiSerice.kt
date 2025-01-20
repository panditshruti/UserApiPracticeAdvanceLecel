package com.sk.apipracticetoadvancelevelbysk.servece

    import com.sk.apipracticetoadvancelevelbysk.db.RecipesResponse
    import com.sk.apipracticetoadvancelevelbysk.db.StudentResponse
    import retrofit2.Call
    import retrofit2.http.GET

    interface StudentApiSerice {
        @GET("students")
        fun getStudent(): Call<StudentResponse>
    }

