package com.example.practiceproject;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MyTimer {
    private CountDownTimer ct;
    private TextView timerTextView;
    private SeekBar timerSeekBar;
    private Button controlButton;
    private boolean timerState;
    public MyTimer(TextView tv, SeekBar ts, Button btn){
        timerTextView = tv;
        timerSeekBar = ts;
        controlButton = btn;
        resetTimer();
    }
    public void startTimer(){
        timerState = true;
        int target = timerSeekBar.getProgress()*1000+100;
        timerSeekBar.setEnabled(false);
        ct = new CountDownTimer(target, 1000) {
            @Override
            public void onTick(long l) {
                updateTime((int)(l/1000));
            }

            @Override
            public void onFinish() {
                resetTimer();
            }
        };
        ct.start();
    }

    public void updateTime(int seconds){
        int minutes = seconds/60;
        seconds %= 60;
        String minuteString = Integer.toString(minutes);
        String secondString = Integer.toString(seconds);
        if(minutes<=9) minuteString = "0"+minuteString;
        if(seconds<=9) secondString = "0"+secondString;

        timerTextView.setText(minuteString+":"+secondString);
        timerSeekBar.setProgress(minutes*60+seconds);
    }

    public void resetTimer(){
        timerState = false;
        timerSeekBar.setEnabled(true);
        timerSeekBar.setProgress(0);
        timerTextView.setText("00:00");
        if(ct!=null){
            ct.cancel();
        }
        controlButton.setText("Start");
    }

    public boolean isTimerState() {
        return timerState;
    }
}
