package com.example.teachtech.database.repository;

import com.example.teachtech.database.dao.TeacherDao
import com.example.teachtech.database.entity.Teacher


class TeacherRepository(
    private val teacherDao: TeacherDao
) {
    suspend fun insertTeacher(teacher: Teacher) =
        teacherDao.insertTeacher(teacher)

    suspend fun updateTeacher(teacher: Teacher) =
        teacherDao.updateTeacher(teacher)

    suspend fun deleteStudent(teacher: Teacher) =
        teacherDao.deleteTeacher(teacher)

    suspend fun getAllTeachers(teacher: Teacher) =
        teacherDao.allTeachers

    suspend fun getTeacherById(id: Int) =
        teacherDao.getTeacherById(id)

}