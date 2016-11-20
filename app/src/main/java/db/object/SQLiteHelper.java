package db.object;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import db.object.ReaderContract.CoursEntry;
import db.object.ReaderContract.ChoiceEntry;
import db.object.ReaderContract.ExerciseEntry;
import db.object.ReaderContract.UserEntry;
import db.object.ReaderContract.ExerciseChoiceEntry;
import db.object.ReaderContract.CoursUserEntry;

import db.object.ReaderContract;
import android.support.annotation.RequiresPermission;

/**
 * Created by TheoP on 18.11.2016.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    //Infos about database
    private static final String DATABASE_NAME = "learnLanguage.db";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteHelper instance;


    //use a singleton
    //we want always just one instance of the database
    private SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public static SQLiteHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SQLiteHelper(context.getApplicationContext());
            //Enable foreign key support
            instance.db.execSQL("PRAGMA foreign_keys = ON;");
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ChoiceEntry.CREATE_TABLE_CHOICE);
        db.execSQL(CoursEntry.CREATE_TABLE_COURS);
        db.execSQL(ExerciseEntry.CREATE_TABLE_EXERCISE);
        db.execSQL(UserEntry.CREATE_TABLE_TABLE_USER);
        db.execSQL(ExerciseChoiceEntry.CREATE_TABLE_EXERCISE_CHOICE);
        db.execSQL(CoursUserEntry.CREATE_TABLE_COURS_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop old tables
        db.execSQL("DROP TABLE IF EXISTS " + ChoiceEntry.TABLE_CHOICE);
        db.execSQL("DROP TABLE IF EXISTS " + CoursEntry.TABLE_COURS);
        db.execSQL("DROP TABLE IF EXISTS " + ExerciseEntry.TABLE_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + ExerciseChoiceEntry.TABLE_EXERCISE_CHOICE);
        db.execSQL("DROP TABLE IF EXISTS " + CoursUserEntry.TABLE_COURS_USER);

        //create new tables
        onCreate(db);
    }
}