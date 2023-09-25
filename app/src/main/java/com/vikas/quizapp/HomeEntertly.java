package com.vikas.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class HomeEntertly extends AppCompatActivity {
   private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_entertly);
        progressBar =findViewById(R.id.progressBarId);
        Handler handler=new Handler();
       Runnable runnable =new Runnable()
       {
            @Override
            public void run() {
              startActivity(new Intent(HomeEntertly.this,MainActivity.class));
            }
        };
        handler.postDelayed(runnable,2000);
    }
}