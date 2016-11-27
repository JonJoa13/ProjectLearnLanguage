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
import db.object.object.Choice;
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
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_editTitel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_editMessage);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.ic_delete_forever);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int id = exercise.getId();
                String titre = editTextTitel.getText().toString();
                String type = editTextType.getText().toString();
                String content = editTextContent.getText().toString();
                String solution = editTextSolution.getText().toString();

                Exercise updatedExercise = new Exercise(id,titre,type,content,solution);
                eds.updateExercise(updatedExercise);

                Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmEdit,
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }

    public void onClickDeleteEx(View w){
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_titel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_message);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.ic_delete_forever);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int id = exercise.getId();
                eds.deleteExercise(id);
                Intent intent = new Intent(ModifyDeleteExercise.this, ExerciseView.class);
                startActivity(intent);

                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmDelete,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteExercise.this,ExerciseView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }
}
