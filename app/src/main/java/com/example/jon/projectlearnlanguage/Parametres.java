/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Parametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_parametres);
    }

    //OnClick go to the modifyMDP layout
    public void onClickModifyMDPFromParam(View w){
        Intent intent = new Intent(Parametres.this,ChangePWD.class);
        startActivity(intent);
    }

    //OnClick go to the login layout
    public void onClickLogout(View w){
        Intent intent = new Intent(Parametres.this,Login.class);
        startActivity(intent);
    }

    //OnClick go to the navLanguage layout
    public void onClickNavLanguage(View w){
        Intent intent = new Intent(Parametres.this,NavLanguage.class);
        startActivity(intent);
    }

    //OnClick go back to the choixLangues layout
    public void onClickBackToChoiceViewFromCreateChoice(View view) {
        Intent intent = new Intent(Parametres.this,ChoixLangues.class);
        startActivity(intent);
    }
}
