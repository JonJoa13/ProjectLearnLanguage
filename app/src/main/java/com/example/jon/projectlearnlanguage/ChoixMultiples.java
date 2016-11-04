package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoixMultiples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_choix_multiples);
    }

    public void onClickRetour(View w){
        Intent intent = new Intent(ChoixMultiples.this,ChoixExercices.class);
        startActivity(intent);
    }

    public void onClickControl(View w){

    }

    public void onClickContinuer(View w){
        Intent intent = new Intent(ChoixMultiples.this,ChoixExercices.class);
        startActivity(intent);
    }
}
