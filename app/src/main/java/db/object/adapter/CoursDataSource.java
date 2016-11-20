package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import db.object.ReaderContract.CoursEntry;
import java.util.ArrayList;
import java.util.List;

import db.object.SQLiteHelper;
import db.object.object.Cours;

/**
 * Created by TheoP on 18.11.2016.
 */

public class CoursDataSource {

        private SQLiteDatabase db;
        private Context context;

        public CoursDataSource(Context context){
            SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
            db = sqliteHelper.getWritableDatabase();
            this.context = context;
        }

        /**
         * Insert a new cours
         */

        public long createCours(Cours cours){
            long id;
            ContentValues values = new ContentValues();
            values.put(CoursEntry.KEY_TITRE, cours.getTitre());
            values.put(CoursEntry.KEY_LEVEL, cours.getLevel());

            id = this.db.insert(CoursEntry.TABLE_COURS, null, values);

            return id;
        }

        /**
         * Find one cours by Id
         */
        public Cours getCoursById(long id){
            String sql = "SELECT * FROM " + CoursEntry.TABLE_COURS +
                    " WHERE " + CoursEntry.KEY_ID + " = " + id;

            Cursor cursor = this.db.rawQuery(sql, null);

            if(cursor != null){
                cursor.moveToFirst();
            }

            Cours cours= new Cours();
            cours.setId(cursor.getInt(cursor.getColumnIndex(CoursEntry.KEY_ID)));
            cours.setTitre(cursor.getString(cursor.getColumnIndex(CoursEntry.KEY_TITRE)));
            cours.setLevel(cursor.getInt(cursor.getColumnIndex(CoursEntry.KEY_LEVEL)));


            return cours;
        }

        /**
         * Get all Cours
         */
        public List<Cours> getAllCours(){
            List<Cours> courses = new ArrayList<Cours>();
            String sql = "SELECT * FROM " + CoursEntry.TABLE_COURS + " ORDER BY " + CoursEntry.KEY_TITRE;

            Cursor cursor = this.db.rawQuery(sql, null);

            if(cursor.moveToFirst()){
                do{
                    Cours cours = new Cours();
                    cours.setId(cursor.getInt(cursor.getColumnIndex(CoursEntry.KEY_ID)));
                    cours.setTitre(cursor.getString(cursor.getColumnIndex(CoursEntry.KEY_TITRE)));
                    cours.setLevel(cursor.getInt(cursor.getColumnIndex(CoursEntry.KEY_LEVEL)));

                    courses.add(cours);
                } while(cursor.moveToNext());
            }

            return courses;
        }

        /**
         *  Update a Cours
         */
        public int updateCours(Cours cours){
            ContentValues values = new ContentValues();
            values.put(CoursEntry.KEY_TITRE, cours.getTitre());
            values.put(CoursEntry.KEY_LEVEL, cours.getLevel());

            return this.db.update(CoursEntry.TABLE_COURS, values, CoursEntry.KEY_ID + " = ?",
                    new String[] { String.valueOf(cours.getId()) });
        }

        /**
         * Delete a Cours - this will also delete all records
         * for the cours
         */
        public void deleteCours(long id){

            //RecordDataSource pra = new RecordDataSource(context);
            //get all records of the user
            //List<Record> records = pra.getAllRecordsByPerson(id);

            //for(Record record : records){
            //    pra.deleteRecord(record.getId());
           // }

            //delete the cours
            this.db.delete(CoursEntry.TABLE_COURS, CoursEntry.KEY_ID + " = ?",
                    new String[] { String.valueOf(id) });

        }
}
