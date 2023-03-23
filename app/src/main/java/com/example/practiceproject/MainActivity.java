package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int curImageState;
    public void imageTransition(View view){
        if(curImageState==1){
            ImageView imageViewTransition = findViewById(R.id.imageViewTransition);
            ImageView imageViewTransition2 = findViewById(R.id.imageViewTransition2);
            imageViewTransition.animate().alpha(0).setDuration(2000);
            imageViewTransition2.animate().alpha(1).setDuration(2000);
        }
        else{
            ImageView imageViewTransition = findViewById(R.id.imageViewTransition);
            ImageView imageViewTransition2 = findViewById(R.id.imageViewTransition2);
            imageViewTransition.animate().alpha(1).setDuration(2000);
            imageViewTransition2.animate().alpha(0).setDuration(2000);
        }
        curImageState^=1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curImageState = 1;
    }
}