package com.example.jon.projectlearnlanguage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jon.projectlearnlanguage.EditorZone.SelectAction;

public class ChoixLangues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_langues);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Acceuil_item:
                startActivity(new Intent(this,ChoixLangues.class));
                break;
            case R.id.Parametres_item:
                startActivity(new Intent(this,Parametres.class));
                break;
        }
        return true;
    }

    public void onClickIChoixDifficulte(View w){
        Intent intent = new Intent(ChoixLangues.this,ChoixDifficulte.class);
        startActivity(intent);
    }

    public void onClickBackToSelectActionFromCL(View view) {
        Intent intent = new Intent(ChoixLangues.this,WelcomePage.class);
        startActivity(intent);
    }
}
