package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageView).setTag("1");
    }
    public void imageCHangerButtonClicked(View view){
        ImageView imageView = findViewById(R.id.imageView);
        if(imageView.getTag()=="1"){
            imageView.setImageResource(R.drawable.image_2);
            imageView.setTag("2");
        }
        else{
            imageView.setImageResource(R.drawable.image_1);
            imageView.setTag("1");
        }
    }
}
