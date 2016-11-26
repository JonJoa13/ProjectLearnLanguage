package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jon.projectlearnlanguage.R;

import java.util.ArrayList;
import java.util.List;

import db.object.SQLiteHelper;
import db.object.adapter.ExerciceAdapter;
import db.object.adapter.ExerciceDataSource;
import db.object.object.Exercise;


public class ExerciseView extends AppCompatActivity {
    private ListView exerciseList;
    Context context;
    List<Exercise> exercises;
    Exercise exercise;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_view);
        context = this;


        final ExerciceDataSource eds = new ExerciceDataSource(this);
        helper.getInstance(context);

        exerciseList = (ListView) findViewById(R.id.Exercises_List);

        exercises = new ArrayList<Exercise>();

        exercises = eds.getAllExercises();

        ExerciceAdapter adapter = new ExerciceAdapter(context,exercises);
        exerciseList.setAdapter(adapter);

        exerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                exercise = (Exercise) parent.getItemAtPosition(position);
                int exerciseSelectedID = exercise.getId();
                Intent intent = new Intent(ExerciseView.this,ModifyDeleteExercise.class);
                intent.putExtra("idExercise",exerciseSelectedID);
                startActivity(intent);
            }
        });

    }

    //onClick to go back to the SelectAction Layout
    public void onClickBackToSelectAction(View w){
        Intent intent = new Intent(ExerciseView.this,SelectAction.class);
        startActivity(intent);
    }

    //onClick to go to the layout that allow to add a new exercise
    public void onClickGoToAddNewEx(View w){
        Intent intent = new Intent(ExerciseView.this,CreateExercise.class);
        startActivity(intent);
    }


}
