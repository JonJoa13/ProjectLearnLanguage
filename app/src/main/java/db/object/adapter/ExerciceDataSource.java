package db.object.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import db.object.ReaderContract.CoursUserEntry;
import db.object.ReaderContract.UserEntry;
import db.object.ReaderContract.ExerciseEntry;
import db.object.object.Choice;
import db.object.SQLiteHelper;
import db.object.object.Exercise;

/**
 * Created by TheoP on 18.11.2016.
 */

public class ExerciceDataSource {
    private SQLiteDatabase db;
    private Context context;

    public ExerciceDataSource(Context context){
        SQLiteHelper sqliteHelper = SQLiteHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert a new exercise
     */
    public long createExercise(Exercise exercise){
        long id;
        ContentValues values = new ContentValues();
        values.put(ExerciseEntry.KEY_TITRE, exercise.getTitre());
        values.put(ExerciseEntry.KEY_TYPE, exercise.getType());
        values.put(ExerciseEntry.KEY_IDCOURS, exercise.getIdCours());
        values.put(ExerciseEntry.KEY_DONNEE, exercise.getDonnee());
        values.put(ExerciseEntry.KEY_SOLUTION, exercise.getSolution());

        id = this.db.insert(ExerciseEntry.TABLE_EXERCISE, null, values);

        return id;
    }

    /**
     * Find one exercise by Id
     */
    public Exercise getExerciseById(long id){
        String sql = "SELECT * FROM " + ExerciseEntry.TABLE_EXERCISE +
                " WHERE " + ExerciseEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Exercise exercise = new Exercise();
        exercise.setId(cursor.getInt(cursor.getColumnIndex(ExerciseEntry.KEY_ID)));
        exercise.setTitre(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_TITRE)));
        exercise.setType(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_TYPE)));
        exercise.setIdCours(cursor.getInt(cursor.getColumnIndex(ExerciseEntry.KEY_IDCOURS)));
        exercise.setDonnee(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_DONNEE)));
        exercise.setSolution(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_SOLUTION)));


        return exercise;
    }

    /**
     * Get all Exercise
     */
    public List<Exercise> getAllExercises(){
        List<Exercise> exercises = new ArrayList<Exercise>();
        String sql = "SELECT * FROM " + ExerciseEntry.TABLE_EXERCISE + " ORDER BY " + ExerciseEntry.KEY_TITRE;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Exercise exercise = new Exercise();
                exercise.setId(cursor.getInt(cursor.getColumnIndex(ExerciseEntry.KEY_ID)));
                exercise.setTitre(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_TITRE)));
                exercise.setType(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_TYPE)));
                exercise.setIdCours(cursor.getInt(cursor.getColumnIndex(ExerciseEntry.KEY_IDCOURS)));
                exercise.setDonnee(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_DONNEE)));
                exercise.setSolution(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_SOLUTION)));

                exercises.add(exercise);
            } while(cursor.moveToNext());
        }

        return exercises;
    }
    /**
     * Get all Exercises for one User
     */
    public List<Exercise> getAllExercisesByUser(long user_id){
        List<Exercise> exercises = new ArrayList<Exercise>();
        String sql = "SELECT * FROM " + ExerciseEntry.TABLE_EXERCISE + " r, "
                + UserEntry.TABLE_USER + " p, " + CoursUserEntry.TABLE_COURS_USER + " pr "
                + " WHERE p." + ExerciseEntry.KEY_ID + " = " + user_id
                + " AND p." + ExerciseEntry.KEY_ID + " = " + "pr." + CoursUserEntry.KEY_USER_ID
                + " AND r." + ExerciseEntry.KEY_ID + " = " + "pr." + CoursUserEntry.KEY_COURS_ID;


        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Exercise exercise = new Exercise();
                exercise.setId(cursor.getInt(cursor.getColumnIndex(ExerciseEntry.KEY_ID)));
                exercise.setTitre(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_TITRE)));
                exercise.setType(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_TYPE)));
                exercise.setIdCours(cursor.getInt(cursor.getColumnIndex(ExerciseEntry.KEY_IDCOURS)));
                exercise.setDonnee(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_DONNEE)));
                exercise.setSolution(cursor.getString(cursor.getColumnIndex(ExerciseEntry.KEY_SOLUTION)));

                exercises.add(exercise);
            } while(cursor.moveToNext());
        }

        return exercises;
    }

    /**
     *  Update a Exercise
     */
    public int updateExercise(Exercise exercise){
        ContentValues values = new ContentValues();
        values.put(ExerciseEntry.KEY_TITRE, exercise.getTitre());
        values.put(ExerciseEntry.KEY_TYPE, exercise.getType());
        values.put(ExerciseEntry.KEY_IDCOURS, exercise.getIdCours());
        values.put(ExerciseEntry.KEY_DONNEE, exercise.getDonnee());
        values.put(ExerciseEntry.KEY_SOLUTION, exercise.getSolution());

        return this.db.update(ExerciseEntry.TABLE_EXERCISE, values, ExerciseEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(exercise.getId()) });
    }

    public int updateCoursToExercise(Exercise exercise){
        ContentValues values = new ContentValues();
        values.put(ExerciseEntry.KEY_IDCOURS, exercise.getIdCours());
        return this.db.update(ExerciseEntry.TABLE_EXERCISE, values, ExerciseEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(exercise.getId()) });
    }

    /**
     * Delete an Exercise - this will also delete all choices for the exercise
     */
    public void deleteExercise(long id){

        ChoiceDataSource pra = new ChoiceDataSource(context);
        //get all choices of an exercise
        List<Choice> choices = pra.getAllChoicesByExercise(id);

        for(Choice choice : choices){
            pra.deleteChoice(choice.getId());
         }

        //delete the choice
        this.db.delete(ExerciseEntry.TABLE_EXERCISE, ExerciseEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(id) });

    }
}
