package com.example.egypttourguide.tasks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.egypttourguide.R;
import com.example.egypttourguide.tasks.db.DatabaseHelper;
import com.example.egypttourguide.tasks.db.Task;


public class AddTask extends AppCompatActivity {
    EditText title,body;
    Button add;
    DatabaseHelper databaseHelper;
   String editTTitle="";
   String editBody="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        databaseHelper= new DatabaseHelper();
        title = findViewById(R.id.et_title);
        body = findViewById(R.id.et_detail);
        add = findViewById(R.id.btn_add);

        editTTitle=getIntent().getStringExtra("title");
        editBody=getIntent().getStringExtra("body");
        body.setText(editBody);
        title.setText(editTTitle);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    if(editTTitle==null ) {
                        databaseHelper.addTask(getTask());
                        Toast.makeText(AddTask.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        databaseHelper.updateTask(editTTitle,getTask());
                        Toast.makeText(AddTask.this, "UPDATED Successfully", Toast.LENGTH_SHORT).show();
                    }
                    // Toast.makeText(AddTask.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                     finish();
                   // clearForm();

                }
            }
        });


    }

    boolean validate() {
        boolean result = true;

        if (title.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Title", Toast.LENGTH_SHORT).show();
            title.requestFocus();
            return false;
        }
        if (body.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Body", Toast.LENGTH_SHORT).show();
            body.requestFocus();
            return false;
        }

        return true;
    }



  Task getTask(){
        Task task=new Task();
         task.setName(title.getText().toString());
         task.setBody(body.getText().toString());
         return task;



    }


}