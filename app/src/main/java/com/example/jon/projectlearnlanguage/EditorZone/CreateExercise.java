package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class CreateExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_create_exercise);
    }

    public void onClickBackToExerciseView(View w){
        Intent intent = new Intent(CreateExercise.this, ExerciseView.class);
        startActivity(intent);
    }

    public void onClickCreateExercise(View w){
        Intent intent = new Intent(CreateExercise.this, ExerciseView.class);
        startActivity(intent);
    }
}
