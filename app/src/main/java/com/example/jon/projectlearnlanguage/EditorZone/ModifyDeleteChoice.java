package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
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

    public void onClickBackToChoiceViewFromModifyDelete(View w){
        Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
        startActivity(intent);
    }

    public void onClickModifyChoice(View w){
        Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
        startActivity(intent);
    }

    public void onClickDeleteChoice(View w){
        Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
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
                Intent intent = new Intent(ModifyDeleteChoice.this,ChoiceView.class);
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
