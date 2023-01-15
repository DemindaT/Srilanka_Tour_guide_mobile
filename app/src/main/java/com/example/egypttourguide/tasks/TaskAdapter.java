package com.example.egypttourguide.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egypttourguide.R;
import com.example.egypttourguide.tasks.db.Task;

import java.util.ArrayList;


public class TaskAdapter extends  RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> tasks;
    MainActivity mainActivity;

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskAdapter(ArrayList<Task> tasks, MainActivity mainActivity) {
        this.tasks = tasks;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_item, parent, false);

        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
           holder.bind(tasks.get(position));
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   mainActivity.viewTask(tasks.get(position));
               }
           });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mainActivity.taskOptions(tasks.get(position));
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public  class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView title,body;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }

        public  void  bind(Task task)
        {
            title.setText(task.getName());
            body.setText(task.getBody());
        }
    }
}
