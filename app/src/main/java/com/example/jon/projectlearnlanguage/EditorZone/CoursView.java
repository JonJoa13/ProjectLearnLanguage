/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jon.projectlearnlanguage.R;

import java.util.ArrayList;
import java.util.List;

import db.object.SQLiteHelper;
import db.object.adapter.CoursAdapter;
import db.object.adapter.CoursDataSource;
import db.object.object.Cours;

public class CoursView extends AppCompatActivity {
    private ListView coursList;
    Context context;
    List<Cours> courses;
    Cours cours;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours_view);

        context = this;

        //Add the list of cours in the listview
        final CoursDataSource cds = new CoursDataSource(this);
        helper.getInstance(context);

        coursList = (ListView) findViewById(R.id.Cours_List);

        courses = new ArrayList<Cours>();

        courses = cds.getAllCours();

        CoursAdapter adapter = new CoursAdapter(context,courses);
        coursList.setAdapter(adapter);

        coursList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cours = (Cours) parent.getItemAtPosition(position);
                int coursSelectedId = cours.getId();
                Intent intent = new Intent(CoursView.this,ModifyDeleteCours.class);
                intent.putExtra("idCours",coursSelectedId);
                startActivity(intent);
            }
        });

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


}
