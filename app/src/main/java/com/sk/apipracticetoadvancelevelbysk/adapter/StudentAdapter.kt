package com.sk.apipracticetoadvancelevelbysk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sk.apipracticetoadvancelevelbysk.R
import com.sk.apipracticetoadvancelevelbysk.db.Student

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName: TextView = itemView.findViewById(R.id.studentName)
        val fatherName: TextView = itemView.findViewById(R.id.fatherName)
        val motherName: TextView = itemView.findViewById(R.id.motherName)
        val rollNumber: TextView = itemView.findViewById(R.id.rollNumber)
        val className: TextView = itemView.findViewById(R.id.className)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.studentName.text = student.name.studentName
        holder.fatherName.text = student.name.fatherName
        holder.motherName.text = student.name.motherName
        holder.rollNumber.text = student.rollNumber
        holder.className.text = student.className
    }

    override fun getItemCount() = students.size
}
