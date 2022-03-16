package com.example.teachtech.database.dao;
import androidx.room.*
import com.example.teachtech.database.entity.Student


@Dao
interface StudentDao {

    @get:Query("SELECT * FROM Student")
    val allStudents: List<Student?>?

    @Query("SELECT * FROM Student s WHERE s.studentId = :id")
    fun getStudentById(id: Int?): Student?

    @Insert
    fun insertStudent(student: Student?)

    @Delete
    fun deleteStudent(student: Student?)

    @Update
    fun updateStudent(student: Student?)
}