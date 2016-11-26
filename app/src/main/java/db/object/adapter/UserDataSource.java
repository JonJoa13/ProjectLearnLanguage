package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import db.object.ReaderContract.UserEntry;
import db.object.SQLiteHelper;
import db.object.object.Exercise;
import db.object.object.User;

/**
 * Created by TheoP on 18.11.2016.
 */

public class UserDataSource {
    private SQLiteHelper helper;
    private SQLiteDatabase db;
    private Context context;

    public UserDataSource(Context context){
        helper = SQLiteHelper.getInstance(context);
        this.context = context;
    }

    /**
     * Insert a new User
     */
    public long createUser(User user){
        long id;
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserEntry.KEY_NAME, user.getName());
        values.put(UserEntry.KEY_FIRSTNAME, user.getFirstname());
        values.put(UserEntry.KEY_EMAIL, user.getEmail());
        values.put(UserEntry.KEY_MDP, user.getMdp());

        id = this.db.insert(UserEntry.TABLE_USER, null, values);

        return id;
    }

    /**
     * Find one choice by Id
     */
    public User getUserById(long id){
        db = helper.getWritableDatabase();
        String sql = "SELECT * FROM " + UserEntry.TABLE_USER +
                " WHERE " + UserEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(UserEntry.KEY_ID)));
        user.setName(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_NAME)));
        user.setFirstname(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_FIRSTNAME)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_EMAIL)));
        user.setMdp(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_MDP)));

        return user;
    }

    /**
     * Get all User
     */
    public List<User> getAllUsers(){
        db = helper.getReadableDatabase();
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM " + UserEntry.TABLE_USER + " ORDER BY " + UserEntry.KEY_NAME;


        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(UserEntry.KEY_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_NAME)));
                user.setFirstname(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_FIRSTNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_EMAIL)));
                user.setMdp(cursor.getString(cursor.getColumnIndex(UserEntry.KEY_MDP)));

                users.add(user);
            } while(cursor.moveToNext());
        }

        return users;
    }

    /**
     *  Update a User
     */
    public int updateUser(User user){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserEntry.KEY_NAME, user.getName());
        values.put(UserEntry.KEY_FIRSTNAME, user.getFirstname());
        values.put(UserEntry.KEY_EMAIL, user.getEmail());
        values.put(UserEntry.KEY_MDP, user.getMdp());

        return this.db.update(UserEntry.TABLE_USER, values, UserEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    /**
     * Delete a User - this will also delete all exercises
     */
    public void deleteUser(long id){
        db = helper.getWritableDatabase();
        ExerciceDataSource pra = new ExerciceDataSource(context);
        //get all exercises of the user
        List<Exercise> exercises = pra.getAllExercisesByUser(id);

        for(Exercise exercise : exercises){
            pra.deleteExercise(exercise.getId());
         }

        //delete the user
        this.db.delete(UserEntry.CREATE_TABLE_USER, UserEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(id) });

    }
}
