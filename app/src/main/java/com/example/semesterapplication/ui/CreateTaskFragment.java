package com.example.semesterapplication.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semesterapplication.R;
import com.example.semesterapplication.data.adapter.TaskAdapter;
import com.example.semesterapplication.model.Task;
import com.example.semesterapplication.viewModel.TaskViewModel;

import java.util.ArrayList;

public class CreateTaskFragment extends Fragment  {

    TaskViewModel taskViewModel;
    EditText editText;
    Button save;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        editText = view.findViewById(R.id.editText);
        save = view.findViewById(R.id.save);
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskViewModel.insert(new Task(editText.getText().toString(), false));
                editText.setText("");
                Toast.makeText(getContext(), "Task added to the list", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}