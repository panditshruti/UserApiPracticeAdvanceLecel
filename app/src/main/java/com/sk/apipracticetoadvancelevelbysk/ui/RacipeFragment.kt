package com.sk.apipracticetoadvancelevelbysk.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sk.apipracticetoadvancelevelbysk.R
import com.sk.apipracticetoadvancelevelbysk.adapter.RacipeAdapter
import com.sk.apipracticetoadvancelevelbysk.adapter.UserAdapter
import com.sk.apipracticetoadvancelevelbysk.databinding.FragmentRacipeBinding
import com.sk.apipracticetoadvancelevelbysk.db.RecipesResponse
import com.sk.apipracticetoadvancelevelbysk.db.UserResponse
import com.sk.apipracticetoadvancelevelbysk.model.RetrofitClient
import com.sk.apipracticetoadvancelevelbysk.model.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RacipeFragment : Fragment(R.layout.fragment_racipe) {
    private lateinit var binding:FragmentRacipeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRacipeBinding.bind(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Fetch data from the API
        RetrofitInstance.api.getRecipes().enqueue(object : Callback<RecipesResponse> {
            override fun onResponse(call: Call<RecipesResponse>, response: Response<RecipesResponse>) {
                if (response.isSuccessful) {
                    val recipes = response.body()?.recipes ?: emptyList()
                    binding.recyclerView.adapter = RacipeAdapter(recipes) // Pass the list of users to the adapter
                }
            }
            override fun onFailure(call: Call<RecipesResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

}
