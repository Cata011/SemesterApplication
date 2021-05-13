package com.example.semesterapplication.data.adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semesterapplication.R;
import com.example.semesterapplication.model.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> tasks;
    // public ArrayList<Task> tasks1;
    final private OnListItemClickListener onListItemClickListener;


    public TaskAdapter(ArrayList<Task> tasks, OnListItemClickListener onListItemClickListener) {
        this.tasks = tasks;
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
                                tasks.remove(position);
                                return true;
                            case R.id.flag:

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
        TextView PLACEHOLDER_SOMESTUFF;
        TextView PLACEHOLDER_SOMEOTHERSTUFF;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            PLACEHOLDER_SOMESTUFF = itemView.findViewById(R.id.textView);
            PLACEHOLDER_SOMEOTHERSTUFF = itemView.findViewById(R.id.textView1);
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

//    @Override
//    public Filter getFilter() {         //taken from http://programmingroot.com/android-recyclerview-search-filter-tutorial-with-example/
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//
//                String charString = constraint.toString();
//
//                if (charString.isEmpty()){
//                    tasks = tasks1;
//                }else{
//
//                    ArrayList<com.example.semesterapplication.old.Task> filterList = new ArrayList<>();
//
//                    for (com.example.semesterapplication.old.Task data : tasks1){
//
//                        if (data.getPLACEHOLDER_SOMESTUFF().toLowerCase().contains(charString)){
//                            filterList.add(data);
//                        }
//                    }
//
//                    tasks = filterList;
//
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = tasks;
//
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//
//                tasks = (ArrayList<com.example.semesterapplication.old.Task>) results.values;
//                notifyDataSetChanged();
//            }
//        };
//
//    }
}
