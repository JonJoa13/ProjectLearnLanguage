/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ChoixMultiples extends AppCompatActivity {
    public TextView tv_Correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_choix_multiples);
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setVisibility(View.INVISIBLE);
    }
    //OnClick go back to the choixExercices layout
    public void onClickBackToChoixExercicesFromChoixMultiples(View w){
        Intent intent = new Intent(ChoixMultiples.this,ChoixExercices.class);
        startActivity(intent);
    }
    //OnClick go back to the choixExercices layout
    public void onClickContinueToChoixExercices(View w){
        Intent intent = new Intent(ChoixMultiples.this,ChoixExercices.class);
        startActivity(intent);
    }

    //If right answer selected, show Corret!
    public void onClickDisplayResult(View view) {
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setText(R.string.tv_correct);
        tv_Correct.setVisibility(View.VISIBLE);
    }
    //if wront answer selected, show incorrect!
    public void onClickDisplayResultFalse(View view) {
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setText(R.string.tv_wrong);
        tv_Correct.setVisibility(View.VISIBLE);
    }
}
