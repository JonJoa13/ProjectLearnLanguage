/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.jon.projectlearnlanguage.EditorZone.SelectAction;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }

    //On click go to the SelectAction layout
    public void onClickEditorMode(View w){
        Intent intent = new Intent(WelcomePage.this, SelectAction.class);
        startActivity(intent);
    }
    //On click go to the Login layout
    public void onClickUserMode(View w){
        Intent intent = new Intent(WelcomePage.this, Login.class);
        startActivity(intent);
    }




}
