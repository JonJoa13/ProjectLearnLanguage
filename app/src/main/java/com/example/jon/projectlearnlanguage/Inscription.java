package com.example.jon.projectlearnlanguage;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EditorZone.AddExerciseToCours;
import com.example.jon.projectlearnlanguage.EditorZone.ModifyDeleteCours;
import com.example.jon.projectlearnlanguage.EditorZone.ModifyDeleteUser;
import com.example.jon.projectlearnlanguage.EditorZone.SelectAction;
import com.example.jon.projectlearnlanguage.EditorZone.UserView;

import db.object.adapter.UserDataSource;
import db.object.object.User;

public class Inscription extends AppCompatActivity {
    EditText editTextName,
            editTextFirstname,
            editTextEmail,
            editTextMDP;
    UserDataSource uds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inscription);
    }

    public void onClickBackToSelectActionFromRegister(View w){
        Intent intent = new Intent(Inscription.this,WelcomePage.class);
        startActivity(intent);
    }

    public void onClickChoixLanguesFromInscription(View w){
        editTextName = (EditText)findViewById(R.id.et_name);
        editTextFirstname = (EditText) findViewById(R.id.et_firstname);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextMDP = (EditText) findViewById(R.id.et_mdp);

        String name = editTextName.getText().toString();
        String firstname = editTextFirstname.getText().toString();
        String email = editTextEmail.getText().toString();
        String mdp = editTextMDP.getText().toString();

        uds = new UserDataSource(getApplicationContext());

        if(name.equals("") || firstname.equals("")|| email.equals("") || mdp.equals("")){
            AlertDialog.Builder alert = new AlertDialog.Builder (this);
            // Setting Dialog Title
            alert.setTitle(R.string.da_titelError);

            // Setting Dialog Message
            alert.setMessage(R.string.da_errorMessage);

            // Setting Icon to Dialog
            alert.setIcon(R.drawable.ic_delete_forever);

            // Setting Positive "Yes" Button
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            // Showing Alert Message
            alert.show();
        }
        else{
            uds.createUser(new User(name,firstname,email,mdp));

            Intent intent = new Intent(Inscription.this,ChoixLangues.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), R.string.da_alertCreate,
                    Toast.LENGTH_SHORT).show();
        }


    }

}
