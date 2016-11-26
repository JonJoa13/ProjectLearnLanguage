package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        editTextLevel.setText(String.valueOf(cours.getId()));
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
        Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
        startActivity(intent);
    }

    public void onClickDeleteCours(View w){
        Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
        startActivity(intent);
    }
}
