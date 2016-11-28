package com.example.jon.projectlearnlanguage;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EditorZone.SelectAction;

import db.object.object.User;

public class Login extends AppCompatActivity {
    EditText editTextEmail,
             editTextMDP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextMDP = (EditText) findViewById(R.id.et_mdp);
    }

    public void onClickBackToSelectActionFromLogin(View w){
        Intent intent = new Intent(Login.this,WelcomePage.class);
        startActivity(intent);
    }

    public void onClickIncriptionFromLogin(View w){
        Intent intent = new Intent(Login.this,Inscription.class);
        startActivity(intent);
    }

    public void onClickChoixLanguesFromLogin(View w){
        String email = editTextEmail.getText().toString();
        String mdp = editTextMDP.getText().toString();

        if(email.equals("") || mdp.equals("")){
            final AlertDialog.Builder alert = new AlertDialog.Builder (this);
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

            Intent intent = new Intent(Login.this,ChoixLangues.class);
            startActivity(intent);
        }
    }
}
