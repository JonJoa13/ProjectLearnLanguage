package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import db.object.ReaderContract.ChoiceEntry;
import db.object.ReaderContract.ExerciseEntry;
import db.object.ReaderContract.ExerciseChoiceEntry;
import db.object.SQLiteHelper;
import db.object.object.Choice;

/**
 * Created by TheoP on 18.11.2016.
 */

public class ChoiceDataSource {

    private SQLiteDatabase db;
    private Context context;

    public ChoiceDataSource(Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert a new choice
     */
    public long createChoice(Choice choice){
        long id;
        ContentValues values = new ContentValues();
        values.put(ChoiceEntry.KEY_DESCR, choice.getDescription());
        values.put(ChoiceEntry.KEY_CHOICE1, choice.getChoice1());
        values.put(ChoiceEntry.KEY_CHOICE2, choice.getChoice2());
        values.put(ChoiceEntry.KEY_CHOICE3, choice.getChoice3());

        id = this.db.insert(ChoiceEntry.TABLE_CHOICE, null, values);

        return id;
    }

    /**
     * Find one choice by Id
     */
    public Choice getChoiceById(long id){
        String sql = "SELECT * FROM " + ChoiceEntry.TABLE_CHOICE +
                " WHERE " + ChoiceEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Choice choice = new Choice();
        choice.setId(cursor.getInt(cursor.getColumnIndex(ChoiceEntry.KEY_ID)));
        choice.setDescription(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_DESCR)));
        choice.setChoice1(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE1)));
        choice.setChoice2(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE2)));
        choice.setChoice3(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE3)));


        return choice;
    }

    /**
     * Get all Choices for one Exercise
     */
    public List<Choice> getAllChoicesByExercise(long exercise_id){
        List<Choice> choices = new ArrayList<Choice>();
        String sql = "SELECT * FROM " + ChoiceEntry.TABLE_CHOICE + " r, "
                + ExerciseEntry.TABLE_EXERCISE + " p, " + ExerciseChoiceEntry.TABLE_EXERCISE_CHOICE + " pr "
                + " WHERE p." + ChoiceEntry.KEY_ID + " = " + exercise_id
                + " AND p." + ChoiceEntry.KEY_ID + " = " + "pr." + ExerciseChoiceEntry.KEY_EXERCISE_ID
                + " AND r." + ChoiceEntry.KEY_ID + " = " + "pr." + ExerciseChoiceEntry.KEY_CHOICE_ID;


        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Choice choice = new Choice();
                choice.setId(cursor.getInt(cursor.getColumnIndex(ChoiceEntry.KEY_ID)));
                choice.setDescription(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_DESCR)));
                choice.setChoice1(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE1)));
                choice.setChoice2(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE2)));
                choice.setChoice3(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE3)));

                choices.add(choice);
            } while(cursor.moveToNext());
        }

        return choices;
    }

    /**
     * Get all Choice
     */
    public List<Choice> getAllChoices(){
        List<Choice> choices = new ArrayList<Choice>();
        String sql = "SELECT * FROM " + ChoiceEntry.TABLE_CHOICE + " ORDER BY " + ChoiceEntry.KEY_ID;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Choice choice = new Choice();
                choice.setId(cursor.getInt(cursor.getColumnIndex(ChoiceEntry.KEY_ID)));
                choice.setDescription(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_DESCR)));
                choice.setChoice1(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE1)));
                choice.setChoice2(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE2)));
                choice.setChoice3(cursor.getString(cursor.getColumnIndex(ChoiceEntry.KEY_CHOICE3)));

                choices.add(choice);
            } while(cursor.moveToNext());
        }

        return choices;
    }

    /**
     *  Update a Choice
     */
    public int updateChoice(Choice choice){
        ContentValues values = new ContentValues();
        values.put(ChoiceEntry.KEY_DESCR,choice.getDescription());
        values.put(ChoiceEntry.KEY_CHOICE1, choice.getChoice1());
        values.put(ChoiceEntry.KEY_CHOICE2, choice.getChoice2());
        values.put(ChoiceEntry.KEY_CHOICE3, choice.getChoice3());

        return this.db.update(ChoiceEntry.TABLE_CHOICE, values, ChoiceEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(choice.getId()) });
    }

    /**
     * Delete a Choice
     */
    public void deleteChoice(long id){

        //delete the choice
        this.db.delete(ChoiceEntry.TABLE_CHOICE, ChoiceEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(id) });

    }
}
