/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */

package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class AddExerciseToCours extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise_to_cours);

    }
// Back to to ModifyDeleteCours Layout
    public void onClickBackToModifyCours(View w){
        Intent intent = new Intent(AddExerciseToCours.this,ModifyDeleteCours.class);
        startActivity(intent);
    }



}
