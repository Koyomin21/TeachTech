package com.example.roomdatabasetestproject.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabasetestproject.database.entitiy.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM Student s WHERE s.studentId = :id")
    Student getStudentById(Integer id);

    @Insert
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);
}
