package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class CoursView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_cours_view);
    }

    public void onClickBackToSelectAction(View w){
        Intent intent = new Intent(CoursView.this,SelectAction.class);
        startActivity(intent);
    }

    public void onClickGoToAddNewCours(View w){
        Intent intent = new Intent(CoursView.this,CreateCours.class);
        startActivity(intent);
    }

    public void onClickGoToModifyDeleteCours(View w){
        Intent intent = new Intent(CoursView.this,ModifyDeleteCours.class);
        startActivity(intent);
    }

}
