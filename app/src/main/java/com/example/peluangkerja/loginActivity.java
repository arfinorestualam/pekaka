package com.example.peluangkerja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class loginActivity extends AppCompatActivity {
    Button btnlogin, btnFacebook, btnGmail, btnLinkedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin = findViewById(R.id.btnMasuk);

        btnlogin.setOnClickListener(view -> {
            Intent i = new Intent(loginActivity.this, MainActivity.class);
            startActivity(i);
        });
    }
}