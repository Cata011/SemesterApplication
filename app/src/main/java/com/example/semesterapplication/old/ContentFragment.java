package com.example.semesterapplication.old;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.semesterapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment implements ContentAdapter.OnListItemClickListener {
    RecyclerView content;
    ContentAdapter contentAdapter;
    ArrayList<Task> dummyTasks;
    public LiveData<Boolean> isSaving;
    ContentViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        content = view.findViewById(R.id.contentFragment);
        content.hasFixedSize();
        content.setLayoutManager(new LinearLayoutManager(requireActivity()));

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


        contentAdapter = new ContentAdapter(dummyTasks, this);
        content.setAdapter(contentAdapter);

        viewModel = new ViewModelProvider(requireActivity()).get(ContentViewModel.class);
        viewModel.getTasks().observe(requireActivity(), new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
              //TODO
            }
        });
        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //TODO:
    }
}

//public class ContentFragment extends AppCompatActivity {
//
//    RecyclerView content;
//    ContentAdapter contentAdapter;
//    ArrayList<Task> dummyTasks;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_content);
//
//        content = findViewById(R.id.nav_host_fragment);
//        content.hasFixedSize();
//        content.setLayoutManager(new LinearLayoutManager(this));
//
//        dummyTasks = new ArrayList<>();
//        dummyTasks.add(new Task("nimic1", "nimic2"));
//        dummyTasks.add(new Task("nimic11", "nimic2"));
//        dummyTasks.add(new Task("nimic111", "nimic2"));
//        dummyTasks.add(new Task("nimic1111", "nimic2"));
//        dummyTasks.add(new Task("nimic1111", "nimic2"));
//        dummyTasks.add(new Task("nimic11111", "nimic2"));
//        dummyTasks.add(new Task("nimic111111", "nimic2"));
//        dummyTasks.add(new Task("nimic1111111", "nimic2"));
//        dummyTasks.add(new Task("nimic11111111", "nimic2"));
//
//
//        contentAdapter = new ContentAdapter(dummyTasks, this);
//        content.setAdapter(contentAdapter);
//
//    }
//}