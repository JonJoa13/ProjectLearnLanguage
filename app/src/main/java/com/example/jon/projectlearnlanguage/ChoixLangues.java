package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoixLangues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_choix_langues);
    }

    public void onClickIChoixDifficulte(View w){
        Intent intent = new Intent(ChoixLangues.this,ChoixDifficulte.class);
        startActivity(intent);
    }

    public void onClickMenuFromChoixLangues(View w){
        Intent intent = new Intent(ChoixLangues.this,MenuParam.class);
        startActivity(intent);
    }

}
