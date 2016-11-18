package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class CreateCours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_create_cours);
    }

    public void onClickBackToCoursView(View w){
        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);
    }

    public void onClickCreateCours(View w){
        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);
    }


}
