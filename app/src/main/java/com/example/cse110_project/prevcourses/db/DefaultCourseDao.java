package com.example.cse110_project.prevcourses.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface DefaultCourseDao {
    @Transaction
    @Query("SELECT * FROM courses where student_id=:studentId")
    List<DefaultCourse> getForStudent(int studentId);

    @Query("SELECT * FROM courses")
    List<DefaultCourse> getAll();

    @Query("SELECT * FROM courses WHERE student_id=:id")
    DefaultCourse get(int id);

    @Query("DELETE FROM courses")
    void delete();

    @Query("SELECT COUNT(*) from courses")
    int count();

    @Insert
    void insert(DefaultCourse defaultCourse);

    @Delete
    void delete(DefaultCourse defaultCourse);
}

/**
 * Source:
 *
 * For deleting database content:
 * https://stackoverflow.com/questions/44244508/room-persistance-library-delete-all
 * */