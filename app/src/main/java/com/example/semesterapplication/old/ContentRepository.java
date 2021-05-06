package com.example.semesterapplication.old;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ContentRepository {
    private ContentDAO contentDAO;
    private static ContentRepository instance;
    private LiveData<List<Task>> tasks;
    //private ExecutorService executorService;

    private ContentRepository(Application application) {
        ContentDatabase database = ContentDatabase.getInstance(application);
        contentDAO = database.contentDAO();
        tasks = contentDAO.getTasks();
      //  executorService = Executors.newFixedThreadPool(2);
        //  Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());        //TODO:Remember

//        executorService.execute(() -> {
//            Result result = someBackgroundWork();
//            mainThreadHandler.post(() -> { callback.onComplete(result);});
//        });

    }

//    private ContentRepository()
//    {
//        contentDAO = ContentDAO.getInstance();
//    }

    public static ContentRepository getInstance(Application application) {
        if (instance == null) {
            instance = new ContentRepository(application);
        }

        return instance;
    }

    public LiveData<List<Task>> getTasks() {
        //TODO:Change executorService.execute(() -> contentDAO.getTasks());
        return contentDAO.getTasks();
    }

    public void add(Task task) {
        //TODO:Change executorService.execute(() -> contentDAO.add(task));
        // contentDAO.add(task);
    }

    public void remove(Task task) {
        //TODO:Change executorService.execute(() -> contentDAO.remove(task));
        //  contentDAO.remove(task);
    }
}
