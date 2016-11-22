package com.example.jon.projectlearnlanguage.EditorZone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jon.projectlearnlanguage.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import db.object.ReaderContract;
import db.object.SQLiteHelper;
import db.object.object.User;

public class UserView extends AppCompatActivity {
    private ListView userList;
    protected Object [] items;

    protected Button modifyDeleteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.activity_user_view);

        readSQL();




    }

    public void onClickBackToSelectAction(View w) {
        Intent intent = new Intent(UserView.this, SelectAction.class);
        startActivity(intent);
    }

    public void onClickGoToAddNewUser(View w) {
        Intent intent = new Intent(UserView.this, CreateUser.class);
        startActivity(intent);
    }

    public void onClickGoToModifyDeleteUser(View w) {
        Intent intent = new Intent(UserView.this, ModifyDeleteUser.class);
        startActivity(intent);
    }

    public void readSQL() {
        SQLiteHelper mDbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] userListNameFirstName = new String[]{
                ReaderContract.UserEntry.KEY_FIRSTNAME,
                ReaderContract.UserEntry.KEY_NAME
        };

        Cursor cursor = db.query(false, ReaderContract.UserEntry.TABLE_USER, userListNameFirstName, null, null, null, null, null, null);
        ArrayList<String> array = new ArrayList<String>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            array.add(cursor.getString(1));
            cursor.moveToNext();
        }

        db.close();
        generateUserList(array);
    }

    public void generateUserList(ArrayList<String> array) {

        Collections.sort(array);

        userList = (ListView) findViewById(R.id.Users_List);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_view, R.id.tv_list, array);

        userList.setAdapter(adapter);

    }

    public class SelectUserAction implements AdapterView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        }
    }
}
