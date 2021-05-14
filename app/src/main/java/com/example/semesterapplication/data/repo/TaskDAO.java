package com.example.semesterapplication.data.repo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.semesterapplication.model.Task;

import java.util.List;

@Dao
public interface TaskDAO {
    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Query("Select * FROM task_table")
    LiveData<List<Task>> getAllTasks();

    @Update
    void markAsFinished(Task task);
}
