package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import com.example.jon.projectlearnlanguage.R;

import java.io.Reader;

import db.object.ReaderContract;
import db.object.SQLiteHelper;

public class CreateCours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_create_cours);
    }

    //onClick go back to the CoursView layout
    public void onClickBackToCoursView(View w){
        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);
    }

    public void onClickCreateCours(View w){
        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);

        createCours();
    }
    //onClick create a new cours in the database
    public void createCours(){
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        EditText editTextCours,
                editTextLevel;

        editTextCours = (EditText)findViewById(R.id.et_cours);
        editTextLevel = (EditText)findViewById(R.id.et_level);

        String cours = editTextCours.getText().toString();
        String level = editTextLevel.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ReaderContract.CoursEntry.KEY_TITRE, cours);
        values.put(ReaderContract.CoursEntry.KEY_LEVEL, level);

        db.insert(ReaderContract.CoursEntry.TABLE_COURS, ReaderContract.CoursEntry.KEY_NULLABLE, values);
        db.close();

        Intent intent = new Intent(CreateCours.this, CoursView.class);
        startActivity(intent);
    }


}
