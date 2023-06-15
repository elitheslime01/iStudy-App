package com.example.appdetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText txt_semail,txt_sname, txt_susername, txt_spass;
    Button btnRegister, btnLogIn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        txt_semail = (EditText) findViewById(R.id.txt_email);
        txt_sname = (EditText) findViewById(R.id.txt_name);
        txt_susername = (EditText) findViewById(R.id.txt_username);
        txt_spass = (EditText) findViewById(R.id.txt_pass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        db = new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String semail = txt_semail.getText().toString();
                String sname = txt_sname.getText().toString();
                String susername = txt_susername.getText().toString();
                String spass = txt_spass.getText().toString();

                if (semail.equals("") || sname.equals("") || susername.equals("") || spass.equals("")) {
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuser =db.checkUsername(susername);
                    if (checkuser == false) {
                        Boolean insert = db.insertData(semail, sname, susername, spass);
                        if(insert == true) {
                            Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(Signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Signup.this, "User already exists! Please, sign up first", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}