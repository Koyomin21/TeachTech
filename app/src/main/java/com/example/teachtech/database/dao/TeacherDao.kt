
package com.example.teachtech.database.dao;
import androidx.room.*
import com.example.teachtech.database.entity.Teacher


@Dao
interface TeacherDao {
    @get:Query("SELECT * FROM Teacher")
    val allTeachers: List<Teacher?>?

    @Query("SELECT * FROM Teacher s WHERE s.teacherId = :id")
    fun getTeacherById(id: Int?): Teacher?

    @Insert
    fun insertTeacher(teacher: Teacher?)

    @Delete
    fun deleteTeacher(teacher: Teacher?)

    @Update
    fun updateTeacher(teacher: Teacher?)
}