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
import db.object.adapter.ChoiceAdapter;
import db.object.adapter.ChoiceDataSource;
import db.object.object.Choice;

public class ChoiceView extends AppCompatActivity {
    private ListView choiceList;
    Context context;
    List<Choice> choices;
    Choice choice;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_view);

        context = this;


        final ChoiceDataSource cds = new ChoiceDataSource(this);
        helper.getInstance(context);

        choiceList = (ListView) findViewById(R.id.Choice_list);

        choices = new ArrayList<Choice>();

        choices = cds.getAllChoices();

        ChoiceAdapter adapter = new ChoiceAdapter(context,choices);
        choiceList.setAdapter(adapter);

        choiceList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                choice = (Choice) parent.getItemAtPosition(position);
                int choiceSelectID = choice.getId();
                Intent intent = new Intent(ChoiceView.this,ModifyDeleteChoice.class);
                intent.putExtra("idChoice",choiceSelectID);
                startActivity(intent);
            }
        });

    }

    //onClick to go back to the SelectAction Layout
    public void onClickBackToSelectAction(View w) {
        Intent intent = new Intent(ChoiceView.this, SelectAction.class);
        startActivity(intent);
    }
    //onClick to go to the layout that allow to add new choices
    public void onClickGoToAddNewChoice(View w) {
        Intent intent = new Intent(ChoiceView.this, CreateChoice.class);
        startActivity(intent);
    }

}
