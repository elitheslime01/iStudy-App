package com.example.appdetproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    ImageView Back_Dash;
    ConstraintLayout layoutforum_dash, layoutlibrary_dash, layoutflashcard_dash;
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Back_Dash = (ImageView) findViewById(R.id.btnBack_Dash);
        layoutlibrary_dash = (ConstraintLayout) findViewById(R.id.layoutlibrary_dash);
        layoutflashcard_dash = (ConstraintLayout) findViewById(R.id.layoutflashcard_dash);
        builder = new AlertDialog.Builder(this);

        layoutflashcard_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Flashcard.class);
                startActivity(intent);
            }
        });



        layoutlibrary_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Library.class);
                startActivity(intent);
            }
        });

        Back_Dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setMessage("Are you sure you want to log out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Warning!");
                alert.show();
            }
        });


    }
}

