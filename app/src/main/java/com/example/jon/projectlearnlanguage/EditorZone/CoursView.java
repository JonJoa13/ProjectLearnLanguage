package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jon.projectlearnlanguage.R;

import java.util.ArrayList;
import java.util.Collections;

import db.object.ReaderContract;
import db.object.SQLiteHelper;

public class CoursView extends AppCompatActivity {
    private ListView coursList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_cours_view);

        readSQL();
    }

    //onClick to go back to the SelectAction Layout
    public void onClickBackToSelectAction(View w){
        Intent intent = new Intent(CoursView.this,SelectAction.class);
        startActivity(intent);
    }

    //onClick to go to the layout that allow to add a new cours
    public void onClickGoToAddNewCours(View w){
        Intent intent = new Intent(CoursView.this,CreateCours.class);
        startActivity(intent);
    }
    //Load the data from the table cours
    public void readSQL() {
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] coursListTitre = new String[]{
                ReaderContract.CoursEntry.KEY_TITRE,
                ReaderContract.CoursEntry.KEY_LEVEL
        };

        Cursor cursor = db.query(false, ReaderContract.CoursEntry.TABLE_COURS, coursListTitre,null, null, null, null, null, null);
        ArrayList<String> array = new ArrayList<String>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            array.add(cursor.getString(0));
            cursor.moveToNext();
        }

        db.close();
        generateUserList(array);
    }

    //Show the data in the list view, with the description
    public void generateUserList(ArrayList<String> array) {

        Collections.sort(array);

        coursList = (ListView) findViewById(R.id.Cours_List);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_view, R.id.tv_list, array);

        coursList.setAdapter(adapter);

    }

}
