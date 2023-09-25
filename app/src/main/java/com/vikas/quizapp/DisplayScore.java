package com.vikas.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayScore extends AppCompatActivity{
   private TextView yourresult ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        yourresult=findViewById(R.id.yourscoreId);
        yourresult.setText(MainActivity.totalScore+" ");
    }
}