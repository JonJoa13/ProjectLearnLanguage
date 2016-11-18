package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class ModifyDeleteExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_modify_delete_exercise);
    }

    public void onClickBackToExerciseView(View w){
        Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
        startActivity(intent);
    }

    public void onClickModifyEx(View w){
        Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
        startActivity(intent);
    }

    public void onClickDeleteEx(View w){
        Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
        startActivity(intent);
    }
}
