package com.example.semesterapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.semesterapplication.R;
import com.example.semesterapplication.data.adapter.TaskAdapter;
import com.example.semesterapplication.viewModel.TaskViewModel;
import com.example.semesterapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TasksFragment extends Fragment implements TaskAdapter.OnListItemClickListener {

    RecyclerView rv;
    TaskAdapter taskAdapter;
//    MutableLiveData<List<Task>> tasks;
    TaskViewModel taskViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        rv = view.findViewById(R.id.rv);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(requireActivity()));
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(getViewLifecycleOwner(), tasks1 -> {
            taskAdapter = new TaskAdapter(tasks1, this, taskViewModel);
            rv.setAdapter(taskAdapter);
        });

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //find something to do
    }



}