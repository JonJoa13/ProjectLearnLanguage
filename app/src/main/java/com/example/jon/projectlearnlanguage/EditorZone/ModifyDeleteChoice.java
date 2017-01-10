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

import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskChoiceDelete;
import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskChoiceUpdate;
import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.ChoiceDataSource;
import db.object.object.Choice;

public class ModifyDeleteChoice extends AppCompatActivity {
    Bundle bundle;
    Integer choiceId;
    EditText editTextDescription,
             editTextChoice1,
             editTextChoice2,
             editTextChoice3;
    ChoiceDataSource cds;
    Choice choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_delete_choice);

        //get the idChoice of the choice selected to return the information about it
        cds = new ChoiceDataSource(this);

        if(savedInstanceState == null){
            bundle = getIntent().getExtras();
            if(bundle == null){
                choiceId = null;
            } else {
                choiceId = bundle.getInt("idChoice");
            }
        }else{
            choiceId = (int) savedInstanceState.getSerializable("idChoice");
        }

        editTextDescription = (EditText) findViewById(R.id.et_description);
        editTextChoice1 = (EditText) findViewById(R.id.et_choice1);
        editTextChoice2 = (EditText) findViewById(R.id.et_choice2);
        editTextChoice3 = (EditText) findViewById(R.id.et_choice3);

        choice = cds.getChoiceById(choiceId);

        editTextDescription.setText(choice.getDescription());
        editTextChoice1.setText(choice.getChoice1());
        editTextChoice2.setText(choice.getChoice2());
        editTextChoice3.setText(choice.getChoice3());


    }
    // On click back to the choiceView layout
    public void onClickBackToChoiceViewFromModifyDelete(View w){
        Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
        startActivity(intent);
    }

    //On click on the button modify, save the changes in the database
    // and ask if the user really want to do it with a warning
    public void onClickModifyChoice(View w){
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
                int id = choice.getId();
                String description = editTextDescription.getText().toString();
                String choice1 = editTextChoice1.getText().toString();
                String choice2 = editTextChoice2.getText().toString();
                String choice3 = editTextChoice3.getText().toString();

                Choice updatedChoice = new Choice(id,description,choice1,choice2,choice3);
                cds.updateChoice(updatedChoice);

                servlets.backend.choiceApi.model.Choice choiceBackend = new servlets.backend.choiceApi.model.Choice();

                choiceBackend.setId(Long.valueOf(updatedChoice.getId()));
                choiceBackend.setDescription(updatedChoice.getDescription());
                choiceBackend.setChoice1(updatedChoice.getChoice1());
                choiceBackend.setChoice2(updatedChoice.getChoice2());
                choiceBackend.setChoice3(updatedChoice.getChoice3());

                new EndpointsAsyncTaskChoiceUpdate(choiceBackend).execute();


                Intent intent = new Intent(ModifyDeleteChoice.this, ChoiceView.class);
                startActivity(intent);

                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmEdit,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }
    //On click on the delete button, ask the user if he really want to delete it
    // with a warning, if yes, the choice is deleted from the database
    public void onClickDeleteChoice(View w){
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
                int id = choice.getId();
                cds.deleteChoice(id);

                servlets.backend.choiceApi.model.Choice choiceBackend = new servlets.backend.choiceApi.model.Choice();

                choiceBackend.setId(Long.valueOf(choice.getId()));

                new EndpointsAsyncTaskChoiceDelete(choiceBackend).execute();

                Intent intent = new Intent(ModifyDeleteChoice.this, ChoiceView.class);
                startActivity(intent);

                // User pressed YES button. Write Logic Here
                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmDelete,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }
}
