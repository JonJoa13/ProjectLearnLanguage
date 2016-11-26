package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.ExerciceDataSource;
import db.object.object.Exercise;

public class ModifyDeleteExercise extends AppCompatActivity {
    Bundle bundle;
    Integer exerciseId;
    EditText editTextTitre,
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

        editTextTitre = (EditText) findViewById(R.id.et_titelEx);
        editTextType = (EditText) findViewById(R.id.et_type);
        editTextContent = (EditText) findViewById(R.id.et_content);
        editTextSolution = (EditText) findViewById(R.id.et_solution);

        exercise = eds.getExerciseById(exerciseId);

        editTextTitre.setText(exercise.getTitre());
        editTextType.setText(exercise.getType());
        editTextContent.setText(exercise.getDonnee());
        editTextSolution.setText(exercise.getSolution());

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
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_titel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_message);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.exit_icon);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on YES",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
                startActivity(intent);
                // User pressed Cancel button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alert.show();
    }
}
