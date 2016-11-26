package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.ExerciceDataSource;
import db.object.object.Exercise;

public class ModifyDeleteExercise extends AppCompatActivity {
    Bundle bundle;
    Integer exerciseId;
    EditText editTextTitel,
             editTextType,
             editTextContent,
             editTextSolution;
    ExerciceDataSource eds;
    Exercise exercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_delete_exercise);

        eds = new ExerciceDataSource(this);

        if(savedInstanceState == null){
            bundle = getIntent().getExtras();
            if(bundle == null){
                exerciseId = null;
            } else {
                exerciseId = bundle.getInt("idExercise");
            }
        }else{
            exerciseId = (int) savedInstanceState.getSerializable("idExercise");
        }

        editTextTitel = (EditText) findViewById(R.id.et_titelEx);
        editTextType = (EditText) findViewById(R.id.et_type);
        editTextContent = (EditText) findViewById(R.id.et_content);
        editTextSolution = (EditText) findViewById(R.id.et_solution);

        exercise = eds.getExerciseById(exerciseId);

        editTextTitel.setText(exercise.getTitre());
        editTextType.setText(exercise.getType());
        editTextContent.setText(exercise.getDonnee());
        editTextSolution.setText(exercise.getSolution());

    }

    public void onClickBackToExerciseView(View w){
        Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
        startActivity(intent);
    }

    public void onClickModifyEx(View w){
        int id = exercise.getId();
        String titre = editTextTitel.getText().toString();
        String type = editTextType.getText().toString();
        String content = editTextContent.getText().toString();
        String solution = editTextSolution.getText().toString();

        Exercise updatedExercise = new Exercise(id,titre,type,content,solution);
        eds.updateExercise(updatedExercise);

        Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
        startActivity(intent);
    }

    public void onClickDeleteEx(View w){
        Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
        startActivity(intent);
    }
}
