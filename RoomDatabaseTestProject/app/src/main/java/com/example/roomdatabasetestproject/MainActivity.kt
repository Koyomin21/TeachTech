package com.example.roomdatabasetestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.roomdatabasetestproject.database.AppDatabase
import com.example.roomdatabasetestproject.database.entitiy.Student

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getInstance(applicationContext)
//
        val studentDao = db.studentDao();
        // inserting new students
//        studentDao.insertStudent(Student("First Name1", "Last Name1"))
//        studentDao.insertStudent(Student("First Name2", "Last Name2"))
        // getting student1
//        val student1 = studentDao.getStudentById(1);
//        student1.firstName = "Updated First Name 1"
        // updating student1
//        studentDao.updateStudent(student1);
        var listView = findViewById<ListView>(R.id.studentList)

        val listItems = arrayOfNulls<String>(studentDao.allStudents.size)
// 3
        for (i in 0 until studentDao.allStudents.size) {
            val student = studentDao.allStudents[i]
            listItems[i] = student.firstName + " : " + student.lastName;
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

//        println(studentDao.allStudents)

//        // deleting 2 student
//        studentDao.deleteStudent(studentDao.getStudentById(2));
//        println(studentDao.allStudents)

    }
}