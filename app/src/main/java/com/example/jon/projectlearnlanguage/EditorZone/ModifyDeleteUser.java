package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jon.projectlearnlanguage.R;

public class ModifyDeleteUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_modify_delete_user);
    }

    public void onClickBackToUserView(View w){
        Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
        startActivity(intent);
    }

    public void onClickModifyUser(View w){
        Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
        startActivity(intent);
    }

    public void onClickDeleteUser(View w){
        Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
        startActivity(intent);
    }
}
