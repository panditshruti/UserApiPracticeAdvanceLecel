package com.sk.apipracticetoadvancelevelbysk.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sk.apipracticetoadvancelevelbysk.R
import com.sk.apipracticetoadvancelevelbysk.adapter.UserAdapter
import com.sk.apipracticetoadvancelevelbysk.databinding.FragmentHomeBinding
import com.sk.apipracticetoadvancelevelbysk.db.UserResponse
import com.sk.apipracticetoadvancelevelbysk.model.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Fetch data from the API
        RetrofitClient.api.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.users ?: emptyList()
                    binding.recyclerView.adapter = UserAdapter(users) // Pass the list of users to the adapter
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                // Handle the failure case
            }
        })
    }
}
