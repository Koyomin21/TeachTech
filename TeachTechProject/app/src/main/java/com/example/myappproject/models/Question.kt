package com.example.myappproject.models

data class Question(
    var id : Int,
    var questionText: String,
    var rowAnswers: ArrayList<String>,
    var correctAnswer: String,
    var testId: Int
)
