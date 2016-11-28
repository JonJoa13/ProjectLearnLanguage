/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
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
        setContentView(R.layout.activity_select_action);
    }

    //onClick go back to the welcomePage layout
    public void onClickBackToWelcomePage(View w){
        Intent intent = new Intent(SelectAction.this,WelcomePage.class);
        startActivity(intent);
    }
    //onClick go back to the UsersView layout
    public void onClickSelectUsers(View w){
        Intent intent = new Intent(SelectAction.this,UserView.class);
        startActivity(intent);
    }
    //onClick go back to the CoursView layout
    public void onClickSelectCours(View w){
        Intent intent = new Intent(SelectAction.this,CoursView.class);
        startActivity(intent);
    }
    //onClick go back to the ExercisesView layout
    public void onClickSelectExercises(View w){
        Intent intent = new Intent(SelectAction.this,ExerciseView.class);
        startActivity(intent);
    }
    //onClick go back to the ChoiceView layout
    public void onClickSelectChoice(View w){
        Intent intent = new Intent(SelectAction.this,ChoiceView.class);
        startActivity(intent);
    }

}
