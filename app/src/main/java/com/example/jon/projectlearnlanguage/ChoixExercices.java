/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
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

    //OnClick go back to the choixDifficulte layout
    public void onClickBackToChoixDifficulte(View w){
        Intent intent = new Intent(ChoixExercices.this,ChoixDifficulte.class);
        startActivity(intent);
    }
    //OnClick go to the Vocabulaire layout
    public void onClickVocabulaire(View w){
        Intent intent = new Intent(ChoixExercices.this,Vocabulaire.class);
        startActivity(intent);
    }
    //OnClick go to the choixMultiples layout
    public void onClickChoixMultiples(View w){
        Intent intent = new Intent(ChoixExercices.this,ChoixMultiples.class);
        startActivity(intent);
    }

    //OnClick go to the choixTextesTrous layout
    public void onClickTextesTrous(View w){
        Intent intent = new Intent(ChoixExercices.this,TextesTrous.class);
        startActivity(intent);
    }
}
