package com.example.semesterapplication.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semesterapplication.R;
import com.example.semesterapplication.data.adapter.TaskAdapter;
import com.example.semesterapplication.model.Task;

import java.util.ArrayList;

public class CreateTaskFragment extends Fragment  {

    EditText editText;
    Button cancel;
    Button save;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        editText = view.findViewById(R.id.editText);
        cancel = view.findViewById(R.id.cancel);
        save = view.findViewById(R.id.save);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}