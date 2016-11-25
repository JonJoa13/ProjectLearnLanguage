package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;

public class CreateChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_create_choice);
    }

    public void onClickBackToChoiceView(View v){
        Intent intent = new Intent(CreateChoice.this,ChoiceView.class);
    }

    public void onClickCreateChoice(View v){
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        EditText editTextChoice1,
                 editTextChoice2,
                 editTextChoice3;

        editTextChoice1 = (EditText) findViewById(R.id.et_choice1);
        editTextChoice2 = (EditText) findViewById(R.id.et_choice2);
        editTextChoice3 = (EditText) findViewById(R.id.et_choice3);

        String choice1 = editTextChoice1.getText().toString();
        String choice2 = editTextChoice1.getText().toString();
        String choice3 = editTextChoice1.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ReaderContract.ChoiceEntry.KEY_CHOICE_1, choice1);
        values.put(ReaderContract.ChoiceEntry.KEY_CHOICE_2, choice2);
        values.put(ReaderContract.ChoiceEntry.KEY_CHOICE_3, choice3);

        db.insert(ReaderContract.ChoiceEntry.TABLE_CHOICE, ReaderContract.ChoiceEntry.KEY_NULLABLE, values);

        db.close();

        Intent intent = new Intent (CreateChoice.this,UserView.class);
        startActivity(intent);

    }

}
