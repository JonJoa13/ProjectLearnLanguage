/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoixDifficulte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_choix_difficulte);
    }

    //OnClick go to ChoixExercices layout
    public void onClickChoixExercices(View w){
        Intent intent = new Intent(ChoixDifficulte.this,ChoixExercices.class);
        startActivity(intent);
    }

    //OnClick go back to the choixLangues layout
    public void onClickBackToChoixLangues(View w){
        Intent intent = new Intent(ChoixDifficulte.this,ChoixLangues.class);
        startActivity(intent);
    }
}
