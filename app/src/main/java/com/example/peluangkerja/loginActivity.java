package com.example.peluangkerja;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class loginActivity extends AppCompatActivity{
    Button btnlogin, btnFacebook, btnGmail, btnLinkedin;
    TextView tvForgetPassword, tvDaftar;
    Boolean isDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin = findViewById(R.id.btnMasuk);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        btnGmail = findViewById(R.id.btnGoogle);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnLinkedin = findViewById(R.id.btnLinkedin);
        tvDaftar = findViewById(R.id.tvDaftar);
        btnlogin.setOnClickListener(view -> {
            Intent i = new Intent(loginActivity.this, MainActivity.class);
            startActivity(i);
        });

        tvForgetPassword.setOnClickListener(view -> {
            Intent i = new Intent(loginActivity.this, ForgetPasswordActivity.class);
            startActivity(i);
        });
        btnFacebook.setOnClickListener(view -> {
            showDialog();
        });
        btnGmail.setOnClickListener(view -> {
            showDialog();
        });
        btnLinkedin.setOnClickListener(view -> {
            showDialog();
        });
        tvDaftar.setOnClickListener(view -> {

        });
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_alert_login, null);
        alertDialogBuilder.setView(dialogView);
        isDialog = true;
        Button button = dialogView.findViewById(R.id.btnOk);
        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this, MainActivity.class));
                alertDialog.dismiss();
            }
        });
        // menampilkan alert dialog
        alertDialog.show();

    }

}