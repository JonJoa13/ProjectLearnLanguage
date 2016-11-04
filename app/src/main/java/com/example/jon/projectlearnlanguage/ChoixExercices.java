package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoixExercices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_choix_exercices);
    }

    public void onClickRetour(View w){
        Intent intent = new Intent(ChoixExercices.this,ChoixDifficulte.class);
        startActivity(intent);
    }

    public void onClickVocabulaire(View w){
        Intent intent = new Intent(ChoixExercices.this,Vocabulaire.class);
        startActivity(intent);
    }
}
