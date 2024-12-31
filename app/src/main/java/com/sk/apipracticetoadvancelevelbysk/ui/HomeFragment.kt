package com.sk.apipracticetoadvancelevelbysk.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

       binding.user.setOnClickListener {
           val action = HomeFragmentDirections.actionHomeFragmentToUserFragment()
           findNavController().navigate(action)
       }
        binding.racipe.setOnClickListener {
           val action = HomeFragmentDirections.actionHomeFragmentToRacipeFragment()
           findNavController().navigate(action)
       }
    }
}
