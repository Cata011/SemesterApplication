package com.example.semesterapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.semesterapplication.data.repo.TaskRepo;
import com.example.semesterapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private final TaskRepo taskRepo;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepo = TaskRepo.getInstance(application);
    }

    public LiveData<List<Task>> getAllTasks() {
        return taskRepo.getAllTasks();
    }

    public void insert(Task task) {
        taskRepo.insert(task);
    }

    public void delete(Task task) {
        taskRepo.delete(task);
    }

    public void markAsFinished(Task task) {
        taskRepo.markAsFinished(task);
    }

    public void deleteAllTasks() {
        taskRepo.deleteAllTasks();
    }

    //needed for email intent
    public String formattedString()
    {
        String s = "";
        ArrayList<Task> dummy = new ArrayList<>(getAllTasks().getValue());
        for (Task t:dummy) {
            s += t.getContent() +"\n";
        }
        return s;
    }

}
