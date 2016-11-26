package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_titel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_message);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.exit_icon);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

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
