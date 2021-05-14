package com.example.semesterapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.semesterapplication.data.repo.TaskRepo;
import com.example.semesterapplication.model.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private final TaskRepo taskRepo;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepo = TaskRepo.getInstance(application);

        taskRepo.insert(new Task("asasas", false)); //TODO remove this
    }

    public LiveData<List<Task>> getAllTasks()
    {
        return taskRepo.getAllTasks();
    }

    public void insert(Task task)
    {
        taskRepo.insert(task);
    }

    public void delete(Task task)
    {
        taskRepo.delete(task);
    }

    public void markAsFinished(Task task){
        taskRepo.markAsFinished(task);
    }
}
