package com.example.semesterapplication.data.repo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.semesterapplication.model.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private final TaskRepo taskRepo;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepo = TaskRepo.getInstance(application);
    }

    public LiveData<List<Task>> getAllTasks()
    {
        return taskRepo.getAllNotes();
    }

    public void insert(Task task)
    {
        taskRepo.insert(task);
    }

    public void delete(Task task)
    {
        taskRepo.delete(task);
    }
}
