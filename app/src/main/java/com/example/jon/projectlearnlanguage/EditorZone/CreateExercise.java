package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;
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

        Intent intent = new Intent(CreateExercise.this, ExerciseView.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), R.string.da_alertCreate,
                Toast.LENGTH_SHORT).show();
    }
}
