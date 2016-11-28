package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.R;

import java.util.ArrayList;
import java.util.List;

import db.object.SQLiteHelper;
import db.object.adapter.ExerciceAdapter;
import db.object.adapter.ExerciceDataSource;
import db.object.object.Exercise;

public class AddExerciseToCours extends AppCompatActivity {
    private ListView exerciseList;
    Context context;
    List<Exercise> exercises;
    Exercise exercise;
    ExerciceDataSource eds;
    SQLiteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise_to_cours);

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
                addExToCours(exerciseSelectedID);
                Intent intent = new Intent(AddExerciseToCours.this,ModifyDeleteCours.class);
                startActivity(intent);
            }
        });
    }

    public void onClickBackToModifyCours(View w){
        Intent intent = new Intent(AddExerciseToCours.this,ModifyDeleteCours.class);
        startActivity(intent);
    }

    public void addExToCours(int exerciseId){

        Exercise updatedExercise = new Exercise(exerciseId-1);
        eds.updateCoursToExercise(updatedExercise);

        Intent intent = new Intent(AddExerciseToCours.this,ExerciseView.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), R.string.da_alertConfirmEdit,
                Toast.LENGTH_SHORT).show();

    }

}
