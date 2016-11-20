package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import db.object.ReaderContract;
import db.object.SQLiteHelper;
import db.object.ReaderContract.ExerciseChoiceEntry;

/**
 * Created by TheoP on 18.11.2016.
 */

public class ExerciseChoiceDataSource {

    private SQLiteDatabase db;

    public ExerciseChoiceDataSource(Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
    }

    /**
     * inserts a reference between a exercise and a choice
     */
    public long createExerciseChoice (long exercise_id, long choice_id){
        ContentValues values = new ContentValues();
        values.put(ExerciseChoiceEntry.KEY_EXERCISE_ID, exercise_id);
        values.put(ExerciseChoiceEntry.KEY_CHOICE_ID, choice_id);

        return this.db.insert(ExerciseChoiceEntry.CREATE_TABLE_EXERCISE_CHOICE, null, values);
    }
}
