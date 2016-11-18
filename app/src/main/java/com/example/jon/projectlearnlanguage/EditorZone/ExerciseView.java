package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class ExerciseView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_exercise_view);
    }

    public void onClickBackToSelectAction(View w){
        Intent intent = new Intent(ExerciseView.this,SelectAction.class);
        startActivity(intent);
    }

    public void onClickGoToAddNewEx(View w){
        Intent intent = new Intent(ExerciseView.this,CreateExercise.class);
        startActivity(intent);
    }

    public void onClickGoToModifyDeleteEx(View w){
        Intent intent = new Intent(ExerciseView.this,ModifyDeleteExercise.class);
        startActivity(intent);
    }
}
