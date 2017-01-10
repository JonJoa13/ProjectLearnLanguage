/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskCoursDelete;
import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskCoursUpdate;
import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.CoursDataSource;
import db.object.object.Choice;
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

        //get the idCours of the cours selected to return the information about it
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

    //On click back to the CoursView layout
    public void onClickBackToCoursView(View w){
        Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
        startActivity(intent);
    }
    //On click, go to the addExToCours layout
    public void onClickAddExToCours(View w){
        Intent intent = new Intent(ModifyDeleteCours.this,AddExerciseToCours.class);
        startActivity(intent);
    }

    //On click on the button modify, ask if the user really want to do it with a warning
    // if yes save the changes in the database
    public void onClickModifyCours(View w){
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_editTitel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_editMessage);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.ic_delete_forever);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int id = cours.getId();
                String cours = editTextCours.getText().toString();
                int level = Integer.parseInt(editTextLevel.getText().toString());

                Cours updatedCours = new Cours(id, cours, level);
                cds.updateCours(updatedCours);

                servlets.backend.coursApi.model.Cours coursBackend = new servlets.backend.coursApi.model.Cours();

                coursBackend.setId(Long.valueOf(updatedCours.getId()));
                coursBackend.setTitre(updatedCours.getTitre());
                coursBackend.setLevel(updatedCours.getLevel());

                new EndpointsAsyncTaskCoursUpdate(coursBackend).execute();

                Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmEdit,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }

    //On click on the delete button, ask the user if he really want to delete it
    // with a warning, if yes, the choice is deleted from the database
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

                servlets.backend.coursApi.model.Cours coursBackend = new servlets.backend.coursApi.model.Cours();

                coursBackend.setId(Long.valueOf(cours.getId()));

                new EndpointsAsyncTaskCoursDelete(coursBackend).execute();

                Intent intent = new Intent(ModifyDeleteCours.this, CoursView.class);
                startActivity(intent);

                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmDelete,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteCours.this,CoursView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }

}
