package com.example.egypttourguide.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.egypttourguide.R;

public class ViewDetail extends AppCompatActivity {

    TextView title,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);
        title=findViewById(R.id.title);
        body=findViewById(R.id.body);
         String titleStr=getIntent().getStringExtra("title");
         String bodyStr=getIntent().getStringExtra("body");
         title.setText(titleStr);
         body.setText(bodyStr);



    }
}