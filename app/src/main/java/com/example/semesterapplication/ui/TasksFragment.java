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
    ArrayList<Task> dummyTasks;
    //ArrayList<Task> tasks;
    MutableLiveData<List<Task>> tasks;
    Task selectedTask;
    TaskViewModel taskViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        rv = view.findViewById(R.id.rv);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(requireActivity()));
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(getViewLifecycleOwner(), tasks1 -> {
           // ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, R.layout.tasklist_item, tasks1);
            taskAdapter = new TaskAdapter(tasks1, this, taskViewModel);
            rv.setAdapter(taskAdapter);
        });

//        dummyTasks = new ArrayList<>();
//        dummyTasks.add(new Task("nimic1"));
//        dummyTasks.add(new Task("nimic11"));
//        dummyTasks.add(new Task("nimic111"));
//        dummyTasks.add(new Task("nimic1111"));
//        dummyTasks.add(new Task("nimic1111"));
//        dummyTasks.add(new Task("nimic11111"));
//        dummyTasks.add(new Task("nimic111111"));
//        dummyTasks.add(new Task("nimic1111111"));
//        dummyTasks.add(new Task("nimic11111111"));

//        taskAdapter = new TaskAdapter(dummyTasks, this);    //TODO: change with tasks
//        rv.setAdapter(taskAdapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        selectedTask = dummyTasks.get(clickedItemIndex);
        //((MainActivity)getActivity()).optionSelected(selectedTask); //to pass to the activity
    }

//    public Task getSelectedTask() {
//        return selectedTask;
//    }

//    public void optionSelected() {
//        ((MainActivity) getActivity()).bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.delete:
//                        dummyTasks.remove(selectedTask);
//                        break;
//                    case R.id.share:
//                        Intent intent = new Intent(Intent.ACTION_SEND);
//                        intent.putExtra(Intent.EXTRA_EMAIL, "");
//                        intent.putExtra(Intent.EXTRA_SUBJECT, "");
//                        intent.putExtra(Intent.EXTRA_TEXT, dummyTasks); //redo later so it looks nice
//
//                        startActivity(Intent.createChooser(intent, String.valueOf(R.string.emailIntent)));
//                        break;
//                    case R.id.flag:
//
//                        break;
//                    case R.id.edit:
//                        break;
//                    case R.id.add:
//
//                        break;
//                    default:
//                }
//                return false;
//            }
//        });
//    }


}