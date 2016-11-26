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

import db.object.adapter.CoursDataSource;
import db.object.object.Cours;

public class ModifyDeleteCours extends AppCompatActivity {
    Bundle bundle;
    Integer coursId;
    EditText editTextCours,
             editTextLevel;
    CoursDataSource cds;
    Cours cours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_delete_cours);

        cds = new CoursDataSource(this);

        if(savedInstanceState == null){
            bundle = getIntent().getExtras();
            if(bundle == null){
                coursId = null;
            } else {
                coursId = bundle.getInt("idCours");
            }
        }else{
            coursId = (int) savedInstanceState.getSerializable("idCours");
        }

        editTextCours = (EditText) findViewById(R.id.et_cours);
        editTextLevel = (EditText) findViewById(R.id.et_level);

        cours = cds.getCoursById(coursId);

        editTextCours.setText(cours.getTitre());
        editTextLevel.setText(String.valueOf(cours.getLevel()));
    }

    public void onClickBackToCoursView(View w){
        Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
        startActivity(intent);
    }

    public void onClickAddExToCours(View w){
        Intent intent = new Intent(ModifyDeleteCours.this,AddExerciseToCours.class);
        startActivity(intent);
    }


    public void onClickModifyCours(View w){
        int id = cours.getId();
        String cours = editTextCours.getText().toString();
        int level = Integer.parseInt(editTextLevel.getText().toString());

        Cours updatedCours = new Cours(id, cours, level);
        cds.updateCours(updatedCours);

        Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
        startActivity(intent);
    }

    public void onClickDeleteCours(View w){
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
                int id = cours.getId();
                cds.deleteCours(id);
                Intent intent = new Intent(ModifyDeleteCours.this, CoursView.class);
                startActivity(intent);

                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on YES",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
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
