/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskUser;
import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskUserDelete;
import com.example.jon.projectlearnlanguage.EndpointsAsyncTaskUserUpdate;
import com.example.jon.projectlearnlanguage.R;

import db.object.ReaderContract;
import db.object.SQLiteHelper;
import db.object.adapter.UserDataSource;
import db.object.object.Exercise;
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

        //get the idUser of the user selected to return the information about it
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

    //On click on the button modify, ask if the user really want to do it with a warning
    // if yes save the changes in the database
    public void onClickModifyUser(View w){
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_editTitel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_editMessage);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.ic_delete_forever);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int id = user.getId();
                String name = editTextName.getText().toString();
                String firstname = editTextFirstname.getText().toString();
                String email = editTextEmail.getText().toString();
                String mdp = editTextMDP.getText().toString();

                User updatedUser = new User(id,name,firstname,email,mdp);
                uds.updateUser(updatedUser);

                servlets.backend.userApi.model.User userBackend = new servlets.backend.userApi.model.User();
                userBackend.setId(Long.valueOf(updatedUser.getId()));
                userBackend.setName(updatedUser.getName());
                userBackend.setFirstname(updatedUser.getFirstname());
                userBackend.setEmail(updatedUser.getEmail());
                userBackend.setMdp(updatedUser.getMdp());

                new EndpointsAsyncTaskUserUpdate(userBackend).execute();

                Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmEdit,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }

    //On click on the delete button, ask the user if he really want to delete it
    // with a warning, if yes, the choice is deleted from the database
    public void onClickDeleteUser(View w){
        AlertDialog.Builder alert = new AlertDialog.Builder (this);
        // Setting Dialog Title
        alert.setTitle(R.string.da_titel);

        // Setting Dialog Message
        alert.setMessage(R.string.da_message);

        // Setting Icon to Dialog
        alert.setIcon(R.drawable.ic_delete_forever);

        // Setting Positive "Yes" Button
        alert.setPositiveButton(R.string.da_btn_1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int id = user.getId();
                uds.deleteUser(id);

                servlets.backend.userApi.model.User userBackend = new servlets.backend.userApi.model.User();

                userBackend.setId(Long.valueOf(user.getId()));

                new EndpointsAsyncTaskUserDelete(userBackend).execute();

                Intent intent = new Intent(ModifyDeleteUser.this, UserView.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), R.string.da_alertConfirmDelete,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Neutral "Cancel" Button
        alert.setNeutralButton(R.string.da_btn_2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ModifyDeleteUser.this,UserView.class);
                startActivity(intent);
            }
        });

        // Showing Alert Message
        alert.show();
    }


}
