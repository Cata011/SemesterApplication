package com.example.semesterapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> implements Filterable {

    private ArrayList<Task> tasks;
    private ArrayList<Task> tasks1;
    final private OnListItemClickListener onListItemClickListener;

    TaskAdapter(ArrayList<Task> tasks, OnListItemClickListener onListItemClickListener)
    {
        this.tasks = tasks;
        this.tasks1 = tasks;
        this.onListItemClickListener = onListItemClickListener;
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
        holder.PLACEHOLDER_SOMESTUFF.setText(tasks.get(position).getPLACEHOLDER_SOMESTUFF());
        holder.PLACEHOLDER_SOMEOTHERSTUFF.setText(tasks.get(position).getPLACEHOLDER_SOMEOTHERSTUFF());

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView PLACEHOLDER_SOMESTUFF;
        TextView PLACEHOLDER_SOMEOTHERSTUFF;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            PLACEHOLDER_SOMESTUFF = itemView.findViewById(R.id.textView);
            PLACEHOLDER_SOMEOTHERSTUFF = itemView.findViewById(R.id.textView1);
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




    @Override
    public Filter getFilter() {         //taken from http://programmingroot.com/android-recyclerview-search-filter-tutorial-with-example/
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();

                if (charString.isEmpty()){
                    tasks = tasks1;
                }else{

                    ArrayList<Task> filterList = new ArrayList<>();

                    for (Task data : tasks1){

                        if (data.getPLACEHOLDER_SOMESTUFF().toLowerCase().contains(charString)){
                            filterList.add(data);
                        }
                    }

                    tasks = filterList;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = tasks;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                tasks = (ArrayList<Task>) results.values;
                notifyDataSetChanged();
            }
        };

    }
}
