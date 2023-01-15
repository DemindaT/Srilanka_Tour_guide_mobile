package com.example.egypttourguide.tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.egypttourguide.R;


import com.example.egypttourguide.tasks.db.DatabaseHelper;
import com.example.egypttourguide.tasks.db.Task;



public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ImageView add;
    RecyclerView recyclerView;
    TaskAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        databaseHelper=DatabaseHelper.getInstance();
        add=findViewById(R.id.add);
        recyclerView=findViewById(R.id.rv);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddTask.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        initAdapter();
    }

    public void  initAdapter()
    {
        adapter=new TaskAdapter(databaseHelper.getTasks(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public  void  viewTask(Task task)
    {
       Intent intent= new Intent(MainActivity.this, ViewDetail.class);
       intent.putExtra("title",task.getName());
       intent.putExtra("body",task.getBody());
        startActivity(intent);
    }

    public  void  taskOptions(Task task)
    {
        OptionSheet.showOption(this, new OptionSheet.IBottomSheet() {
            @Override
            public void onOptionClicked(int option) {
                if(option==2)
                {
                    databaseHelper.deleteTask(task);
                    Toast.makeText(getApplication(), "Deleted", Toast.LENGTH_SHORT).show();
                    initAdapter();
                }

                if(option==1)
                {
                    Intent intent =new Intent(MainActivity.this, AddTask.class);
                    intent.putExtra("title",task.getName());
                    intent.putExtra("body",task.getBody());
                    startActivity(intent);
                }
            }
        });


    }
}