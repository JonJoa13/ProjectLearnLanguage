package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickIncription(View w){
        Intent intent = new Intent(Login.this,Inscription.class);
        startActivity(intent);
    }

    public void onClickLogin(View w){
        Intent intent = new Intent(Login.this,ChoixLangues.class);
        startActivity(intent);
    }
}
