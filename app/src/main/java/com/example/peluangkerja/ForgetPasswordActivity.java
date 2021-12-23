package com.example.peluangkerja;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button btnRecovery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        initToolbar();

        btnRecovery = findViewById(R.id.btnRecovery);
        btnRecovery.setOnClickListener(view -> {
            try {
                Toast.makeText(this, "Password telah berubah", Toast.LENGTH_SHORT ).show();
                Thread.sleep(1500);
                startActivity(new Intent(ForgetPasswordActivity.this, loginActivity.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("Forgot Password");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}