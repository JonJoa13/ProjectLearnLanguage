package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.EditorZone.SelectAction;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_welcome_page);
    }

    public void onClickEditorMode(View w){
        Intent intent = new Intent(WelcomePage.this, SelectAction.class);
        startActivity(intent);
    }

    public void onClickUserMode(View w){
        Intent intent = new Intent(WelcomePage.this, Login.class);
        startActivity(intent);
    }




}
