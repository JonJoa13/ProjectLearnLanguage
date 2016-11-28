/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jon.projectlearnlanguage.R;

import java.util.ArrayList;
import java.util.List;

import db.object.SQLiteHelper;
import db.object.adapter.UserAdapter;
import db.object.adapter.UserDataSource;
import db.object.object.User;

public class UserView extends AppCompatActivity {
    private ListView userList;
    Context context;
    List<User> users;
    User user;
    SQLiteHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        context = this;

        //Add the list of user in the listview
        final UserDataSource uds = new UserDataSource(this);
        helper.getInstance(context);

        userList = (ListView) findViewById(R.id.Users_List);

        users = new ArrayList<User>();

        users = uds.getAllUsers();

        UserAdapter adapter = new UserAdapter(context,users);
        userList.setAdapter(adapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user = (User) parent.getItemAtPosition(position);
                int userSelectedID = user.getId();
                Intent intent = new Intent(UserView.this,ModifyDeleteUser.class);
                intent.putExtra("idUser",userSelectedID);
                startActivity(intent);
            }
        });

    }

    //onClick to go back to the SelectAction Layout
    public void onClickBackToSelectAction(View w) {
        Intent intent = new Intent(UserView.this, SelectAction.class);
        startActivity(intent);
    }

    //onClick to go to the layout that allow to add a new user
    public void onClickGoToAddNewUser(View w) {
        Intent intent = new Intent(UserView.this, CreateUser.class);
        startActivity(intent);
    }
}
