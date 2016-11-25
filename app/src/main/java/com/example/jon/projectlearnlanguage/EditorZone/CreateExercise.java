package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;

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

    public void createExercise(){
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        EditText editTextTitleEx,
                editTextType,
                editTextContent,
                editTextSolution;

        editTextTitleEx = (EditText)findViewById(R.id.et_titleEx);
        editTextType = (EditText)findViewById(R.id.et_type);
        editTextContent = (EditText)findViewById(R.id.et_content);
        editTextSolution = (EditText)findViewById(R.id.et_solution);

        String titre = editTextTitleEx.getText().toString();
        String type = editTextType.getText().toString();
        String content = editTextContent.getText().toString();
        String solution = editTextSolution.getText().toString();


        ContentValues values = new ContentValues();
        values.put(ReaderContract.ExerciseEntry.KEY_TITRE, titre);
        values.put(ReaderContract.ExerciseEntry.KEY_TYPE, type);
        values.put(ReaderContract.ExerciseEntry.KEY_DONNEE, content);
        values.put(ReaderContract.ExerciseEntry.KEY_SOLUTION, solution);

        db.insert(ReaderContract.ExerciseEntry.TABLE_EXERCISE, ReaderContract.ExerciseEntry.KEY_NULLABLE, values);
        db.close();

        Intent intent = new Intent(CreateExercise.this, ExerciseView.class);
        startActivity(intent);
    }
}
