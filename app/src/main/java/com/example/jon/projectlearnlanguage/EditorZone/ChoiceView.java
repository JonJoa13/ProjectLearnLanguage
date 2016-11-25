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

public class ChoiceView extends AppCompatActivity {
    private ListView choiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_choice_view);

        readSQL();
    }

    public void onClickBackToSelectAction(View w) {
        Intent intent = new Intent(ChoiceView.this, SelectAction.class);
        startActivity(intent);
    }

    public void onClickGoToAddNewChoice(View w) {
        Intent intent = new Intent(ChoiceView.this, CreateChoice.class);
        startActivity(intent);
    }

    public void readSQL() {
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] choiceListDescritption = new String[]{
                ReaderContract.ChoiceEntry.KEY_DESCR,
                ReaderContract.ChoiceEntry.KEY_CHOICE1,
                ReaderContract.ChoiceEntry.KEY_CHOICE2,
                ReaderContract.ChoiceEntry.KEY_CHOICE3
                };

        Cursor cursor = db.query(false, ReaderContract.ChoiceEntry.TABLE_CHOICE, choiceListDescritption,null, null, null, null, null, null);
        ArrayList<String> array = new ArrayList<String>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            array.add(cursor.getString(0));
            cursor.moveToNext();
        }

        db.close();
        generateChoiceList(array);
    }

    public void generateChoiceList(ArrayList<String> array) {

        Collections.sort(array);

        choiceList = (ListView) findViewById(R.id.Choice_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_view, R.id.tv_list, array);

        choiceList.setAdapter(adapter);

    }
}
