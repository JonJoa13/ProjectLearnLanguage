package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jon.projectlearnlanguage.R;

import java.util.ArrayList;
import java.util.Collections;

import db.object.ReaderContract;
import db.object.SQLiteHelper;

public class ExerciseView extends AppCompatActivity {
    private ListView exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_exercise_view);

        readSQL();
    }

    //onClick to go back to the SelectAction Layout
    public void onClickBackToSelectAction(View w){
        Intent intent = new Intent(ExerciseView.this,SelectAction.class);
        startActivity(intent);
    }

    //onClick to go to the layout that allow to add a new exercise
    public void onClickGoToAddNewEx(View w){
        Intent intent = new Intent(ExerciseView.this,CreateExercise.class);
        startActivity(intent);
    }

    //Load the data from the table exercise
    public void readSQL() {
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] exerciseListTitle = new String[]{
                ReaderContract.ExerciseEntry.KEY_TITRE,
                ReaderContract.ExerciseEntry.KEY_DONNEE
        };

        Cursor cursor = db.query(false, ReaderContract.ExerciseEntry.TABLE_EXERCISE, exerciseListTitle,null, null, null, null, null, null);
        ArrayList<String> array = new ArrayList<String>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            array.add(cursor.getString(0));
            cursor.moveToNext();
        }

        db.close();
        generateChoiceList(array);
    }

    //Show the data in the list view, with the description
    public void generateChoiceList(ArrayList<String> array) {

        Collections.sort(array);

        exerciseList = (ListView) findViewById(R.id.Exercises_List);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_view, R.id.tv_list, array);

        exerciseList.setAdapter(adapter);

    }
}
