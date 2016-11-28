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

    public void onClickBackToChoixExercicesFromTextesTrous(View w){
        Intent intent = new Intent(TextesTrous.this,ChoixExercices.class);
        startActivity(intent);
    }

    public void onClickContinueFromTextesTrous(View w){
        Intent intent = new Intent(TextesTrous.this,ChoixExercices.class);
        startActivity(intent);
    }

    public void onClickDisplayResult(View view) {
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setText(R.string.tv_correct);
        tv_Correct.setVisibility(View.VISIBLE);
    }

    public void onClickDisplayResultFalse(View view) {
        tv_Correct = (TextView) findViewById(R.id.tv_correct);
        tv_Correct.setText(R.string.tv_wrong);
        tv_Correct.setVisibility(View.VISIBLE);
    }
}
