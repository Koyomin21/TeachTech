package com.example.teachtech.database.repository;
import com.example.teachtech.database.dao.StudentDao
import com.example.teachtech.database.entity.Student

class StudentRepository(
    private val studentDao: StudentDao
) {
    suspend fun insertStudent(student: Student) =
        studentDao.insertStudent(student)

    suspend fun updatetudent(student: Student) =
        studentDao.updateStudent(student)

    suspend fun deleteStudent(student: Student) =
        studentDao.deleteStudent(student)

    suspend fun getAllStudents(student: Student) =
        studentDao.allStudents

    suspend fun getStudentById(id: Int) =
        studentDao.getStudentById(id)

}