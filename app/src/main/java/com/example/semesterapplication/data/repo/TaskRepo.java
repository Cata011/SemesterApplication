package com.example.semesterapplication.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.semesterapplication.model.Task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRepo {
    private static TaskRepo instance;
    private final TaskDAO taskDAO;
    private final LiveData<List<Task>> allTasks;
    private final ExecutorService executorService;

    private TaskRepo(Application application)
    {
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDAO = database.taskDAO();
        allTasks = taskDAO.getAllTasks();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized TaskRepo getInstance(Application application) {
        if (instance == null)
            instance = new TaskRepo(application);

        return instance;
    }

    public LiveData<List<Task>> getAllNotes() {
        return allTasks;
    }

    public void insert(Task note) {
        executorService.execute(() -> taskDAO.insert(note));
    }

    public void delete(Task task)
    {
        executorService.execute(() -> taskDAO.delete(task));
    }

}
