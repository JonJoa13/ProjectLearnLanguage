package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_inscription);
    }

    public void onClickLogin(View w){
        Intent intent = new Intent(Inscription.this,Login.class);
        startActivity(intent);
    }

    public void onClickIncription(View w){
        Intent intent = new Intent(Inscription.this,ChoixLangues.class);
        startActivity(intent);
    }
}
