package com.sk.apipracticetoadvancelevelbysk.db


data class StudentResponse(
    val students: List<Student>
)

data class Student(
    val id: Int,
    val name: Name,
    val rollNumber: String,
    val className: String
)

data class Name(
    val studentName: String,
    val fatherName: String,
    val motherName: String
)
