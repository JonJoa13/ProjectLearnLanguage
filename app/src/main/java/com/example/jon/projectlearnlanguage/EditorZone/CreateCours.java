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

import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskCours;
import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.CoursDataSource;
import db.object.object.Cours;

public class CreateCours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cours);
    }

    //onClick go back to the CoursView layout
    public void onClickBackToCoursView(View w){
        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);
    }
    //onClick create a new cours in the database
    public void onClickCreateCours(View w){

        EditText editTextCours,
                 editTextLevel;

        editTextCours = (EditText)findViewById(R.id.et_cours);
        editTextLevel = (EditText)findViewById(R.id.et_level);

        String lecon = editTextCours.getText().toString();
        int level = Integer.parseInt(editTextLevel.getText().toString());

        CoursDataSource cds = new CoursDataSource(getApplicationContext());

        Long id = cds.createCours(new Cours(lecon,level));

        Cours cours = cds.getCoursById(id);

        servlets.backend.coursApi.model.Cours coursBackend = new servlets.backend.coursApi.model.Cours();

        coursBackend.setId(id);
        coursBackend.setTitre(cours.getTitre());
        coursBackend.setLevel(cours.getLevel());

        new EndpointsAsyncTaskCours(coursBackend).execute();


        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), R.string.da_alertCreate,
                Toast.LENGTH_SHORT).show();
    }

}
