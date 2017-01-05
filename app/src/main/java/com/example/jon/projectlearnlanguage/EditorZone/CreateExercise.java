/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskExercise;
import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.ExerciceDataSource;
import db.object.object.Exercise;

public class CreateExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);
    }
    //onClick go back to the ExerciseView layout
    public void onClickBackToExerciseView(View w){
        Intent intent = new Intent(CreateExercise.this, ExerciseView.class);
        startActivity(intent);
    }

    //onClick create a new exercise in the database
    public void onClickCreateExercise(View w){

        EditText editTextTitle,
                editTextType,
                editTextContent,
                editTextSolution;

        editTextTitle = (EditText)findViewById(R.id.et_titelEx);
        editTextType = (EditText)findViewById(R.id.et_type);
        editTextContent = (EditText)findViewById(R.id.et_content);
        editTextSolution = (EditText)findViewById(R.id.et_solution);

        String titre = editTextTitle.getText().toString();
        String type = editTextType.getText().toString();
        String content = editTextContent.getText().toString();
        String solution = editTextSolution.getText().toString();

        ExerciceDataSource eds = new ExerciceDataSource(getApplicationContext());

        eds.createExercise(new Exercise(titre,type,content,solution));

        servlets.backend.exerciseApi.model.Exercise exerciseBackend = new servlets.backend.exerciseApi.model.Exercise();

        exerciseBackend.setTitre(titre);
        exerciseBackend.setType(type);
        exerciseBackend.setDonnee(content);
        exerciseBackend.setSolution(solution);

        new EndpointsAsyncTaskExercise(exerciseBackend).execute();

        Intent intent = new Intent(CreateExercise.this, ExerciseView.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), R.string.da_alertCreate,
                Toast.LENGTH_SHORT).show();
    }
}
