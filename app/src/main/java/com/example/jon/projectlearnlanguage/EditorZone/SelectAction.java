package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;
import com.example.jon.projectlearnlanguage.WelcomePage;

public class SelectAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_select_action);
    }

    public void onClickBackToWelcomePage(View w){
        Intent intent = new Intent(SelectAction.this,WelcomePage.class);
        startActivity(intent);
    }

    public void onClickSelectUsers(View w){
        Intent intent = new Intent(SelectAction.this,UserView.class);
        startActivity(intent);
    }

    public void onClickSelectCours(View w){
        Intent intent = new Intent(SelectAction.this,CoursView.class);
        startActivity(intent);
    }

    public void onClickSelectExercises(View w){
        Intent intent = new Intent(SelectAction.this,ExerciseView.class);
        startActivity(intent);
    }


}
