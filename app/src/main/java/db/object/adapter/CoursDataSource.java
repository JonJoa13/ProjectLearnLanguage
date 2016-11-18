package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import db.object.SQLiteHelper;

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
         * Insert a new person
         */
//        public long createPerson(Person person){
//            long id;
//            ContentValues values = new ContentValues();
//            values.put(PersonEntry.KEY_NAME, person.getName());
//            values.put(PersonEntry.KEY_PRENAME, person.getPrename());
//            values.put(PersonEntry.KEY_BIRTHDATE, person.getBirthdate());
//
//            id = this.db.insert(PersonEntry.TABLE_PERSON, null, values);
//
//            return id;
//        }
//
//        /**
//         * Find one Person by Id
//         */
//        public Person getPersonById(long id){
//            String sql = "SELECT * FROM " + PersonEntry.TABLE_PERSON +
//                    " WHERE " + PersonEntry.KEY_ID + " = " + id;
//
//            Cursor cursor = this.db.rawQuery(sql, null);
//
//            if(cursor != null){
//                cursor.moveToFirst();
//            }
//
//            Person person = new Person();
//            person.setId(cursor.getInt(cursor.getColumnIndex(PersonEntry.KEY_ID)));
//            person.setName(cursor.getString(cursor.getColumnIndex(PersonEntry.KEY_NAME)));
//            person.setPrename(cursor.getString(cursor.getColumnIndex(PersonEntry.KEY_PRENAME)));
//            person.setBirthdate(cursor.getString(cursor.getColumnIndex(PersonEntry.KEY_BIRTHDATE)));
//
//
//            return person;
//        }
//
//        /**
//         * Get all Persons
//         */
//        public List<Person> getAllPersons(){
//            List<Person> persons = new ArrayList<Person>();
//            String sql = "SELECT * FROM " + PersonEntry.TABLE_PERSON + " ORDER BY " + PersonEntry.KEY_NAME;
//
//            Cursor cursor = this.db.rawQuery(sql, null);
//
//            if(cursor.moveToFirst()){
//                do{
//                    Person person = new Person();
//                    person.setId(cursor.getInt(cursor.getColumnIndex(PersonEntry.KEY_ID)));
//                    person.setName(cursor.getString(cursor.getColumnIndex(PersonEntry.KEY_NAME)));
//                    person.setPrename(cursor.getString(cursor.getColumnIndex(PersonEntry.KEY_PRENAME)));
//                    person.setBirthdate(cursor.getString(cursor.getColumnIndex(PersonEntry.KEY_BIRTHDATE)));
//
//                    persons.add(person);
//                } while(cursor.moveToNext());
//            }
//
//            return persons;
//        }
//
//        /**
//         *  Update a Person
//         */
//        public int updatePerson(Person person){
//            ContentValues values = new ContentValues();
//            values.put(PersonEntry.KEY_NAME, person.getName());
//            values.put(PersonEntry.KEY_PRENAME, person.getPrename());
//            values.put(PersonEntry.KEY_BIRTHDATE, person.getBirthdate());
//
//            return this.db.update(PersonEntry.TABLE_PERSON, values, PersonEntry.KEY_ID + " = ?",
//                    new String[] { String.valueOf(person.getId()) });
//        }
//
//        /**
//         * Delete a Person - this will also delete all records
//         * for the person
//         */
//        public void deletePerson(long id){
//            RecordDataSource pra = new RecordDataSource(context);
//            //get all records of the user
//            List<Record> records = pra.getAllRecordsByPerson(id);
//
//            for(Record record : records){
//                pra.deleteRecord(record.getId());
//            }
//
//            //delete the person
//            this.db.delete(PersonEntry.TABLE_PERSON, PersonEntry.KEY_ID + " = ?",
//                    new String[] { String.valueOf(id) });
//
//        }
}
