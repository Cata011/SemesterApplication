package com.example.semesterapplication.data.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semesterapplication.R;
import com.example.semesterapplication.model.Task;
import com.example.semesterapplication.viewModel.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> tasks;
     public List<Task> filtered;
    final private OnListItemClickListener onListItemClickListener;
    final private TaskViewModel taskViewModel;


    public TaskAdapter(List<Task> tasks, OnListItemClickListener onListItemClickListener, TaskViewModel taskViewModel) {
        this.tasks = tasks;
        this.filtered = tasks;
        this.onListItemClickListener = onListItemClickListener;
        this.taskViewModel = taskViewModel;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tasklist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.content.setText(tasks.get(position).getContent());
        if (taskViewModel.getAllTasks().getValue().get(position).isFinished()) {
            holder.content.setBackgroundColor(Color.parseColor("#58eb34"));
        }

        //needed for menu next to item
        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(view.getContext(), holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.delete:
                                taskViewModel.delete(tasks.get(position));
                                return true;
                            case R.id.flag:
                                taskViewModel.markAsFinished(tasks.get(position));
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView buttonViewOption;
        TextView content;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.textView);

            buttonViewOption = itemView.findViewById(R.id.textViewOptions);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


//    //taken from https://stackoverflow.com/questions/30398247/how-to-filter-a-recyclerview-with-a-searchview
//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @SuppressWarnings("unchecked")
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                filtered = (List<Task>) results.values;
//                notifyDataSetChanged();
//            }
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                List<Task> filteredResults = null;
//                if (constraint.length() == 0) {
//                    filteredResults = tasks;
//                } else {
//                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
//                }
//
//                FilterResults results = new FilterResults();
//                results.values = filteredResults;
//
//                return results;
//            }
//        };
//    }
//
//    protected List<Task> getFilteredResults(String constraint) {
//        List<Task> results = new ArrayList<>();
//
//        for (Task item : tasks) {
//            if (item.getContent().toLowerCase().contains(constraint)) {
//                results.add(item);
//            }
//        }
//        return results;
//    }
}
