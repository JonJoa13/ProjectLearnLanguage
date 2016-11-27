package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;
import db.object.adapter.ChoiceDataSource;
import db.object.object.Choice;

public class CreateChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_choice);
    }

    //onClick go back to the ChoiceView layout
    public void onClickBackToChoiceView(View v){
        Intent intent = new Intent(CreateChoice.this,ChoiceView.class);
        startActivity(intent);
    }

    //onClick create a new choice in the database
    public void onClickCreateChoice(View v){

        EditText editTextDescription,
                 editTextChoice1,
                 editTextChoice2,
                 editTextChoice3;

        editTextDescription = (EditText) findViewById(R.id.et_description);
        editTextChoice1 = (EditText) findViewById(R.id.et_choice1);
        editTextChoice2 = (EditText) findViewById(R.id.et_choice2);
        editTextChoice3 = (EditText) findViewById(R.id.et_choice3);

        String description = editTextDescription.getText().toString();
        String choice1 = editTextChoice1.getText().toString();
        String choice2 = editTextChoice2.getText().toString();
        String choice3 = editTextChoice3.getText().toString();

        ChoiceDataSource cds = new ChoiceDataSource(getApplicationContext()) ;

        cds.createChoice(new Choice(description,choice1,choice2,choice3));

        Intent intent = new Intent (CreateChoice.this,ChoiceView.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), R.string.da_alertCreate,
                Toast.LENGTH_SHORT).show();
    }

}
