package com.example.peluangkerja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreenOne extends AppCompatActivity {
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_one);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> {
            Intent i = new Intent(this, SplashScreenTwo.class);
            startActivity(i);
        });
    }
}