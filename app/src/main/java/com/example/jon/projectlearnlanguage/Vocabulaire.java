/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Vocabulaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_vocabulaire);
    }

    //On click go back to the ChoixExercices layout
    public void onClickBackToChoixExercicesFromVoc(View w){
        Intent intent = new Intent(Vocabulaire.this,ChoixExercices.class);
        startActivity(intent);
    }
    //On click go to the VocabulaireTest layout
    public void onClickTestVoc(View w){
        Intent intent = new Intent(Vocabulaire.this,VocabulaireTest.class);
        startActivity(intent);
    }
}
