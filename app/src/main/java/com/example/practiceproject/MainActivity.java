package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void LoginButtonClicked(View view){
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTestPassword = findViewById(R.id.editTextPassword);
        Toast.makeText(this, "You Entered\nUsername: "+editTextUsername.getText().toString()+"\nPassword: "+editTestPassword.getText().toString()+"\n", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}