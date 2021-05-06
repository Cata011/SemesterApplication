package com.example.semesterapplication.old;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContentDAO {

    @Insert
    void add(Task task);

    @Delete
    void remove(Task task);

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getTasks();
//    private MutableLiveData<List<Task>> tasks;
//    private static ContentDAO instance;
//
//    private ContentDAO()
//    {
//        tasks = new MutableLiveData<>();
//        List<Task> newList = new ArrayList<>();
//        tasks.setValue(newList);
//    }
//
//    public static ContentDAO getInstance()
//    {
//        if(instance == null) {
//            instance = new ContentDAO();
//        }
//        return instance;
//    }
//
//    @Query("SELECT * FROM task_table")
//    public LiveData<List<Task>> getTasks()
//    {
//        return tasks;
//    }
//
//    @Insert
//    public void add(Task task)
//    {
//        List<Task> currentTasks = tasks.getValue();
//        currentTasks.add(task);
//        tasks.setValue(currentTasks);
//    }
//
//    @Delete
//    public void remove(Task task)
//    {
//        List<Task> currentTasks = tasks.getValue();
//        currentTasks.remove(task);
//        tasks.setValue(currentTasks);
//    }
}
