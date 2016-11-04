package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NavLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_nav_language);
    }

    public void onClickModify(View w){


    }

    public void onClickRetour(View w){
        Intent intent = new Intent(NavLanguage.this,Parametres.class);
        startActivity(intent);
    }
}
