package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void ConverterButtonClicked(View view){
        EditText amountInTaka = findViewById(R.id.editTextAmountTaka);
        double takaAmount = Double.parseDouble(amountInTaka.getText().toString());
        double dollarAmount = takaAmount * 0.0095;
        Toast.makeText(this, String.format("%.2f",dollarAmount), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}