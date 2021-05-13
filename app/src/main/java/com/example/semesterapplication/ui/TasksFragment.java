package com.example.semesterapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;

import com.example.semesterapplication.R;
import com.example.semesterapplication.data.adapter.TaskAdapter;
import com.example.semesterapplication.model.Task;

import java.util.ArrayList;

public class TasksFragment extends Fragment implements TaskAdapter.OnListItemClickListener {

    RecyclerView rv;
    TaskAdapter taskAdapter;
    ArrayList<Task> dummyTasks;
    Task selectedTask;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        rv = view.findViewById(R.id.rv);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(requireActivity())); //TODO: remember this

        dummyTasks = new ArrayList<>();
        dummyTasks.add(new Task("nimic1", "nimic2"));
        dummyTasks.add(new Task("nimic11", "nimic2"));
        dummyTasks.add(new Task("nimic111", "nimic2"));
        dummyTasks.add(new Task("nimic1111", "nimic2"));
        dummyTasks.add(new Task("nimic1111", "nimic2"));
        dummyTasks.add(new Task("nimic11111", "nimic2"));
        dummyTasks.add(new Task("nimic111111", "nimic2"));
        dummyTasks.add(new Task("nimic1111111", "nimic2"));
        dummyTasks.add(new Task("nimic11111111", "nimic2"));

        taskAdapter = new TaskAdapter(dummyTasks, this);
        rv.setAdapter(taskAdapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        selectedTask = dummyTasks.get(clickedItemIndex);
    }

    public Task getSelectedTask()
    {
        return selectedTask;
    }
}