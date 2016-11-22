package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;

public class CreateUser extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_create_user);


    }

    public void onClickBackToUserView(View w){
        Intent intent = new Intent(CreateUser.this, UserView.class);
        startActivity(intent);
    }

    public void onClickCreateUser(View w){

        createUser();


    }

    public void createUser(){
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        EditText editTextName,
                editTextFirstname,
                editTextEmail,
                editTextMDP;

        editTextName = (EditText)findViewById(R.id.et_name);
        editTextFirstname = (EditText) findViewById(R.id.et_firstname);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextMDP = (EditText) findViewById(R.id.et_mdp);

        String name = editTextName.getText().toString();
        String firstname = editTextFirstname.getText().toString();
        String email = editTextEmail.getText().toString();
        String mdp = editTextMDP.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ReaderContract.UserEntry.KEY_NAME, name);
        values.put(ReaderContract.UserEntry.KEY_FIRSTNAME,firstname);
        values.put(ReaderContract.UserEntry.KEY_EMAIL, email);
        values.put(ReaderContract.UserEntry.KEY_MDP, mdp);

        db.insert(ReaderContract.UserEntry.TABLE_USER, ReaderContract.UserEntry.KEY_NULLABLE,values);

        db.close();

        Intent intent = new Intent(CreateUser.this, UserView.class);
        startActivity(intent);
    }

}
