
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

    public void onClickModifyMDPFromParam(View w){
        Intent intent = new Intent(Parametres.this,ChangePWD.class);
        startActivity(intent);
    }

    public void onClickLogout(View w){
        Intent intent = new Intent(Parametres.this,Login.class);
        startActivity(intent);
    }

    public void onClickNavLanguage(View w){
        Intent intent = new Intent(Parametres.this,NavLanguage.class);
        startActivity(intent);
    }



    public void onClickMenuParamFromParametres(View w){
        Intent intent = new Intent(Parametres.this,MenuParam.class);
        startActivity(intent);
    }


    public void onClickBackToChoiceViewFromCreateChoice(View view) {
        Intent intent = new Intent(Parametres.this,ChoixLangues.class);
        startActivity(intent);
    }
}
