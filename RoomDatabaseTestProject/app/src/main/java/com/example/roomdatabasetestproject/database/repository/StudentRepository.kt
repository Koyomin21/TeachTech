package com.example.roomdatabasetestproject.database.repository

import android.content.Context
import com.example.roomdatabasetestproject.database.AppDatabase
import com.example.roomdatabasetestproject.database.dao.StudentDao
import com.example.roomdatabasetestproject.database.entitiy.Student

class StudentRepository(context: Context) {
    private val studentDao = AppDatabase.getInstance(context).studentDao();


    fun getAllStudents(): List<Student> {
        return studentDao.allStudents;
    }
}