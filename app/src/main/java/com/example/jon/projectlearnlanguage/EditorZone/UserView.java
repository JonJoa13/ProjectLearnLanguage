package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class UserView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_user_view);
    }

    public void onClickBackToSelectAction(View w){
        Intent intent = new Intent(UserView.this,SelectAction.class);
        startActivity(intent);
    }

    public void onClickGoToAddNewUser(View w){
        Intent intent = new Intent(UserView.this,CreateUser.class);
        startActivity(intent);
    }

    public void onClickGoToModifyDeleteUser(View w){
        Intent intent = new Intent(UserView.this,ModifyDeleteUser.class);
        startActivity(intent);
    }
}
