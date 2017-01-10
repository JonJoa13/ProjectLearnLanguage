/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskUser;
import com.example.jon.projectlearnlanguage.R;

import db.object.adapter.UserDataSource;
import db.object.object.User;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

    }
    //onClick go back to the UserView layout
    public void onClickBackToUserView(View v){
        Intent intent = new Intent(CreateUser.this, UserView.class);
        startActivity(intent);
    }

    //onClick create a new user in the database
    public void onClickCreateUser(View v){

        EditText editTextName,
                 editTextFirstname,
                 editTextEmail,
                 editTextMDP;

        editTextName = (EditText)findViewById(R.id.et_name);
        editTextFirstname = (EditText) findViewById(R.id.et_firstname);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextMDP = (EditText) findViewById(R.id.et_mdp);

        String name = editTextName.getText().toString();
        String firstname = editTextFirstname.getText().toString();
        String email = editTextEmail.getText().toString();
        String mdp = editTextMDP.getText().toString();

        UserDataSource uds = new UserDataSource(getApplicationContext());

        Long id = uds.createUser(new User(name,firstname,email,mdp));

        User user = uds.getUserById(id);

        servlets.backend.userApi.model.User  userBackend= new servlets.backend.userApi.model.User();

        userBackend.setId(id);
        userBackend.setName(user.getName());
        userBackend.setFirstname(user.getFirstname());
        userBackend.setEmail(user.getEmail());
        userBackend.setMdp(user.getMdp());

        new EndpointsAsyncTaskUser(userBackend).execute();

        Intent intent = new Intent(CreateUser.this, UserView.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), R.string.da_alertCreate,
                Toast.LENGTH_SHORT).show();
    }

}
