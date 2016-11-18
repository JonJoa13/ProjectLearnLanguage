package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.ChangePWD;
import com.example.jon.projectlearnlanguage.Parametres;
import com.example.jon.projectlearnlanguage.R;

public class AddExerciseToCours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise_to_cours);
    }

    public void onClickBackToModifyCours(View w){
        Intent intent = new Intent(AddExerciseToCours.this,ModifyDeleteCours.class);
        startActivity(intent);
    }

    public void onClickAddExercicesToCours(View w){
        Intent intent = new Intent(AddExerciseToCours.this,ModifyDeleteCours.class);
        startActivity(intent);
    }



}
