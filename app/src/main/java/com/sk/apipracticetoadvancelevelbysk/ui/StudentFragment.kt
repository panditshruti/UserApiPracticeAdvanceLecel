package com.sk.apipracticetoadvancelevelbysk.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sk.apipracticetoadvancelevelbysk.R
import com.sk.apipracticetoadvancelevelbysk.adapter.RacipeAdapter
import com.sk.apipracticetoadvancelevelbysk.adapter.StudentAdapter
import com.sk.apipracticetoadvancelevelbysk.databinding.FragmentStudentBinding
import com.sk.apipracticetoadvancelevelbysk.db.RecipesResponse
import com.sk.apipracticetoadvancelevelbysk.db.StudentResponse
import com.sk.apipracticetoadvancelevelbysk.model.RetrofitInstance
import com.sk.apipracticetoadvancelevelbysk.model.RetrofitInstanceStudent
import com.sk.apipracticetoadvancelevelbysk.servece.StudentApiSerice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentFragment : Fragment(R.layout.fragment_student) {

    private lateinit var binding:FragmentStudentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStudentBinding.bind(view)


       binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        RetrofitInstanceStudent.api.getStudent().enqueue(object : Callback<StudentResponse> {
            override fun onResponse(call: Call<StudentResponse>, response: Response<StudentResponse>) {
                if (response.isSuccessful) {
                    val recipes = response.body()?. students?: emptyList()
                    binding.recyclerView.adapter = StudentAdapter(recipes) // Pass the list of users to the adapter
                }
            }
            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

}
