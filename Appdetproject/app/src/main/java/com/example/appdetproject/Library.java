package com.example.appdetproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Library extends AppCompatActivity {


    ArrayList<SetsModel> list;
    SetsAdapter adapter;
    ImageView btnBack_lib;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitty_library);

        btnBack_lib = findViewById(R.id.btnBack_lib);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnBack_lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });

        list.add(new SetsModel("JAVA PROG 1"));
        list.add(new SetsModel("JAVA PROG 2"));
        list.add(new SetsModel("JAVA PROG 3"));
        list.add(new SetsModel("JAVA PROG 4"));
        list.add(new SetsModel("JAVA PROG 5"));

        adapter = new SetsAdapter(list, this );
        recyclerView.setAdapter(adapter);
    }
}