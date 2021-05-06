package com.example.semesterapplication.old;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContentViewModel extends AndroidViewModel {
//    private MutableLiveData<List<Task>> tasks;
//    private boolean isSaving;
    private ContentRepository contentRepository;

    public ContentViewModel(Application application)
    {
        super(application);
        contentRepository = ContentRepository.getInstance(application);
//        this.tasks = new MutableLiveData<>();
//        List<Task> newList = new ArrayList<>();
//        this.isSaving = false;
//        tasks.setValue(newList);
    }

    public LiveData<List<Task>> getTasks()
    {
        return contentRepository.getTasks();
    }

    public void addTask(Task task)
    {
        contentRepository.add(task);
//        List<Task> currentTasks = tasks.getValue();
//        currentTasks.add(task);
//        tasks.setValue(currentTasks);
    }

    public void removeTask(Task task)
    {
        contentRepository.remove(task);
//        List<Task> currentTasks = tasks.getValue();
//        currentTasks.remove(task);
//        tasks.setValue(currentTasks);
    }

    public void editTask(Task task, Task newTask)
    {
//        List<Task> currentTasks = tasks.getValue();
//        for(int i = 0;i<currentTasks.size();i++)
//        {
//            if(currentTasks.get(i).equals(task))
//            {
//                task = newTask;
//            }
//        }
//        tasks.setValue(currentTasks);
    }
}
