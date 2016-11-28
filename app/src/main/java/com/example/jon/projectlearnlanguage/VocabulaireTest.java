/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VocabulaireTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_vocabulaire_test);
    }

    //OnClick go back to the Vocabulaire layout
    public void onClickBackToVoc(View w){
        Intent intent = new Intent(VocabulaireTest.this,Vocabulaire.class);
        startActivity(intent);
    }

    //OnClick go to the ChoixExercices layout
    public void onClickControlVoc(View w) {
        //Function not complete --> just return to exercise
        Intent intent = new Intent(VocabulaireTest.this,ChoixExercices.class);
        startActivity(intent);
    }

}
