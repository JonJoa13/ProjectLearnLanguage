package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;
import db.object.adapter.UserDataSource;
import db.object.object.User;

public class ModifyDeleteUser extends AppCompatActivity {
    Bundle bundle;
    Integer userId;
    EditText editTextName,
             editTextFirstname,
             editTextEmail,
             editTextMDP;
    UserDataSource uds;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_delete_user);

        uds = new UserDataSource(this);

        if(savedInstanceState == null){
            bundle = getIntent().getExtras();
            if(bundle == null){
                userId = null;
            } else {
                userId = bundle.getInt("idUser");
            }
        }else{
            userId = (int) savedInstanceState.getSerializable("idUser");
        }


        editTextName = (EditText) findViewById(R.id.et_name);
        editTextFirstname = (EditText) findViewById(R.id.et_firstname);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextMDP = (EditText) findViewById(R.id.et_mdp);

        user = uds.getUserById(userId);

        editTextName.setText(user.getName());
        editTextFirstname.setText(user.getFirstname());
        editTextEmail.setText(user.getEmail());
        editTextMDP.setText(user.getMdp());
    }

    public void onClickBackToUserView(View w){
        Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
        startActivity(intent);
    }

    public void onClickModifyUser(View w){
        int id = user.getId();
        String name = editTextName.getText().toString();
        String firstname = editTextFirstname.getText().toString();
        String email = editTextEmail.getText().toString();
        String mdp = editTextMDP.getText().toString();

        User updatedUser = new User(id,name,firstname,email,mdp);
        uds.updateUser(updatedUser);

        Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
        startActivity(intent);
    }

    public void onClickDeleteUser(View w){
        Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
        startActivity(intent);
    }


}
