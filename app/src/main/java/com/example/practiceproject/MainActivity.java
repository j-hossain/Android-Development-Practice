package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.practiceproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    MyTimer myTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.timerSeekBar.setMax(600);
        myTimer = new MyTimer(activityMainBinding.textViewTimer,activityMainBinding.timerSeekBar,activityMainBinding.buttonStart);

        activityMainBinding.timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myTimer.updateTime(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        activityMainBinding.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myTimer.isTimerState()){
                    activityMainBinding.buttonStart.setText("Stop");
                    myTimer.startTimer();
                }
                else{
                    activityMainBinding.buttonStart.setText("Start");
                    myTimer.resetTimer();
                }
            }
        });

    }
}