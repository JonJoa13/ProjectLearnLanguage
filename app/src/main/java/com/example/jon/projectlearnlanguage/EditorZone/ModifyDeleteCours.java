package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class ModifyDeleteCours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_modify_delete_cours);
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
