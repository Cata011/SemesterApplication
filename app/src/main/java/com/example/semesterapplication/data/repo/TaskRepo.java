package com.example.semesterapplication.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.semesterapplication.model.Task;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRepo {
    private static TaskRepo instance;
    private final TaskDAO taskDAO;
    private final LiveData<List<Task>> allTasks;
    private final ExecutorService executorService;

    private TaskRepo(Application application) {
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

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        executorService.execute(() -> taskDAO.insert(task));
    }

    public void delete(Task task) {
        executorService.execute(() -> taskDAO.delete(task));
    }

    public void markAsFinished(Task task) {
//        Task task1 = allTasks.getValue().get(task.getId());
//        task1.setFinished(true);
//        executorService.execute(() -> taskDAO.markAsFinished(task1)); TODO
    }
}
