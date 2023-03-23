package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void NumberGuessed(View view){
        EditText editTextGuessNumber = findViewById(R.id.editTextGuessNumber);
        int guessedNumber = Integer.parseInt(editTextGuessNumber.getText().toString());
        if(randomNumber<guessedNumber) Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        else if(randomNumber>guessedNumber) Toast.makeText(this, "Upper", Toast.LENGTH_SHORT).show();
        else if(randomNumber==guessedNumber) Toast.makeText(this, "Guessed", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random ran = new Random();
        randomNumber = ran.nextInt(19)+1;
    }
}