/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TextesTrous extends AppCompatActivity {
    public TextView tv_Correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_textes_trous);
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setVisibility(View.INVISIBLE);
    }

    //On click go back to the ChoixExercices layout
    public void onClickBackToChoixExercicesFromTextesTrous(View w){
        Intent intent = new Intent(TextesTrous.this,ChoixExercices.class);
        startActivity(intent);
    }
    //On click go to the ChoixExercices layout
    public void onClickContinueFromTextesTrous(View w){
        Intent intent = new Intent(TextesTrous.this,ChoixExercices.class);
        startActivity(intent);
    }

    //If selected answer is right, show correct!
    public void onClickDisplayResult(View view) {
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setText(R.string.tv_correct);
        tv_Correct.setVisibility(View.VISIBLE);
    }

    //If select answer is wrong, show incorrect!
    public void onClickDisplayResultFalse(View view) {
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setText(R.string.tv_wrong);
        tv_Correct.setVisibility(View.VISIBLE);
    }
}
