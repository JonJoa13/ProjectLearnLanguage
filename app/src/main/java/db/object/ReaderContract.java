package db.object;

import android.provider.BaseColumns;

/**
 * Created by TheoP on 15.11.2016.
 */

public final class ReaderContract {
    public ReaderContract(){
        //empty constructor
        //should never be instantiated
    }

    //Represents the rows of a table
    public static abstract class CoursEntry implements BaseColumns {
        //Table name
        public static final String TABLE_COURS = "cours";

        //Person Column names
        public static final String KEY_ID = "id";
        public static final String KEY_TITRE = "titre";
        public static final String KEY_LEVEL = "level";

        //Table person create statement
        public static final String CREATE_TABLE_COURS = "CREATE TABLE "
                + TABLE_COURS + "("
                + CoursEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + CoursEntry.KEY_TITRE + " TEXT, "
                + CoursEntry.KEY_LEVEL + " INTEGER, "
                + ");";


    }

    public static abstract class ExerciseEntry implements BaseColumns{
        //Table name
        public static final String TABLE_EXERCISE = "exercise";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_TITRE = "titre";
        public static final String KEY_TYPE = "type";
        public static final String KEY_IDCOURS = "idcours";
        public static final String KEY_DONNEE = "donnee";
        public static final String KEY_SOLUTION = "solution";
        public static final String KEY_CHOIX = "choix";

        //Table record create statement
        public static final String CREATE_TABLE_EXERCISE = "CREATE TABLE "
                + TABLE_EXERCISE + "("
                + ExerciseEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ExerciseEntry.KEY_TITRE + " TEXT, "
                + ExerciseEntry.KEY_TYPE + " TEXT, "
                + ExerciseEntry.KEY_IDCOURS + " INTEGER, "
                + ExerciseEntry.KEY_DONNEE + " TEXT "
                + ExerciseEntry.KEY_SOLUTION + " TEXT, "
                + ExerciseEntry.KEY_CHOIX + " TEXT "
                + ");";
    }


    public static abstract class UserEntry implements BaseColumns{
        //Table name
        public static final String TABLE_USER = "user";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_FIRSTNAME = "firstname";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_MDP= "mdp";

        //Table record create statement
        public static final String CREATE_TABLE_TABLE_USER = "CREATE TABLE "
                + TABLE_USER + "("
                + UserEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + UserEntry.KEY_NAME + " TEXT, "
                + UserEntry.KEY_FIRSTNAME + " TEXT, "
                + UserEntry.KEY_EMAIL + " TEXT, "
                + UserEntry.KEY_MDP + " TEXT "
                + ");";
    }

    //Represents the rows of a table
    public static abstract class CoursUserEntry implements BaseColumns{
        //Table name
        public static final String TABLE_COURS_USER = "cours_user";

        //Table person_record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_COURS_ID = "cours_id";
        public static final String KEY_USER_ID = "user_id";

        //Table person_record create statement
        public static final String CREATE_TABLE_COURS_USER = "CREATE TABLE "
                + TABLE_COURS_USER + "("
                + CoursUserEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + CoursUserEntry.KEY_COURS_ID + " INTEGER, "
                + CoursUserEntry.KEY_USER_ID + " INTEGER, "
                + "FOREIGN KEY (" + KEY_COURS_ID + ") REFERENCES " + CoursEntry.TABLE_COURS + " (" + KEY_ID + "), "
                + "FOREIGN KEY (" + KEY_USER_ID + ") REFERENCES " + UserEntry.TABLE_USER + " (" + KEY_ID +") "
                + ");";
    }

}
