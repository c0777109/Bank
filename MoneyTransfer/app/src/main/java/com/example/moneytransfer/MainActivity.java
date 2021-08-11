package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    EditText editTextPassword, textInputuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        editTextPassword = findViewById(R.id.editTextPassword);
        textInputuser = findViewById(R.id.textInputuser);

        loginBtn.setOnClickListener(v->{
            if(textInputuser.getText().toString().isEmpty()){
                Toast.makeText(this, "PLease fill username", Toast.LENGTH_SHORT).show();
            }else if(editTextPassword.getText().toString().isEmpty()){
                Toast.makeText(this, "PLease fill password", Toast.LENGTH_SHORT).show();
            }else if(textInputuser.getText().toString().equalsIgnoreCase("admin@gmail.com") &&
                    editTextPassword.getText().toString().equalsIgnoreCase("123456")){
                startActivity(new Intent(MainActivity.this, Dashboard.class));
            }else {
                Toast.makeText(this, "Wrong Credential, please try again", Toast.LENGTH_SHORT).show();
            }
        });

    }
}