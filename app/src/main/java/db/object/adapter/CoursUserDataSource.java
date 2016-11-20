package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import db.object.SQLiteHelper;
import db.object.ReaderContract.CoursUserEntry;

/**
 * Created by TheoP on 18.11.2016.
 */

public class CoursUserDataSource {
    private SQLiteDatabase db;

    public CoursUserDataSource(Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
    }

    /**
     * inserts a reference between a cours and a user
     */
    public long createCoursUser (long cours_id, long user_id){
        ContentValues values = new ContentValues();
        values.put(CoursUserEntry.KEY_COURS_ID, cours_id);
        values.put(CoursUserEntry.KEY_USER_ID, user_id);

        return this.db.insert(CoursUserEntry.CREATE_TABLE_COURS_USER, null, values);
    }
}
