/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EditorZone.ExerciseView;
import com.example.jon.projectlearnlanguage.EditorZone.ModifyDeleteExercise;

import db.object.adapter.ChoiceDataSource;
import db.object.adapter.UserDataSource;
import db.object.object.Choice;
import db.object.object.User;

public class ChangePWD extends AppCompatActivity implements View.OnClickListener {
    public EditText editText_currentMdp,
            editText_newMdp,
            editText_confirmMdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_change_pwd);

        editText_currentMdp = (EditText)findViewById(R.id.et_mdpactuel);
        editText_newMdp = (EditText)findViewById(R.id.et_newmdp);
        editText_confirmMdp = (EditText)findViewById(R.id.et_confirmmdp);

        editText_currentMdp.setOnClickListener(this);
        editText_newMdp.setOnClickListener(this);
        editText_confirmMdp.setOnClickListener(this);
    }

        //on click on the modify button, ask if the user really want to do it
        // with a warning, if yes, change in the database
       public void onClickModifyMDP(View w){
           if(editText_newMdp == editText_confirmMdp){
               AlertDialog.Builder alertEdit = new AlertDialog.Builder (this);
               // Setting Dialog Title
               alertEdit.setTitle(R.string.da_editTitel);

               // Setting Dialog Message
               alertEdit.setMessage(R.string.da_editMessage);

               // Setting Icon to Dialog
               alertEdit.setIcon(R.drawable.ic_delete_forever);

               // Setting Positive "Yes" Button
               alertEdit.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       Intent intent = new Intent(ChangePWD.this,Parametres.class);
                       startActivity(intent);

                       Toast.makeText(getApplicationContext(), R.string.da_alertConfirmEdit,
                               Toast.LENGTH_SHORT).show();
                   }
               });

               // Setting Neutral "Cancel" Button
               alertEdit.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       Intent intent = new Intent(ChangePWD.this,Parametres.class);
                       startActivity(intent);
                   }
               });

               // Showing Alert Message
               alertEdit.show();
           }else {
               Toast.makeText(getApplicationContext(), R.string.da_alertNotSamePDW,
                       Toast.LENGTH_SHORT).show();
           }

    }
    //onClick back to the settings layout
    public void onClickBackToParam(View w){
        Intent intent = new Intent(ChangePWD.this,Parametres.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
    }

}
