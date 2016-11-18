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
    public static abstract class ChoiceEntry implements BaseColumns {
        //Table name
        public static final String TABLE_CHOICE = "choix";

        //Choice Column names
        public static final String KEY_ID = "id";
        public static final String KEY_DESCRIPTION = "description";

        //Table choice create statement
        public static final String CREATE_TABLE_CHOICE = "CREATE TABLE "
                + TABLE_CHOICE + "("
                + ChoiceEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ChoiceEntry.KEY_DESCRIPTION + " TEXT, "
                + ");";
    }

    //Represents the rows of a table
    public static abstract class CoursEntry implements BaseColumns {
        //Table name
        public static final String TABLE_COURS = "cours";

        //Cours Column names
        public static final String KEY_ID = "id";
        public static final String KEY_TITRE = "titre";
        public static final String KEY_LEVEL = "level";

        //Table Cours create statement
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

        //Exercise Column names
        public static final String KEY_ID = "id";
        public static final String KEY_TITRE = "titre";
        public static final String KEY_TYPE = "type";
        public static final String KEY_IDCOURS = "idcours";
        public static final String KEY_DONNEE = "donnee";
        public static final String KEY_SOLUTION = "solution";

        //Table Exercise create statement
        public static final String CREATE_TABLE_EXERCISE = "CREATE TABLE "
                + TABLE_EXERCISE + "("
                + ExerciseEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ExerciseEntry.KEY_TITRE + " TEXT, "
                + ExerciseEntry.KEY_TYPE + " TEXT, "
                + ExerciseEntry.KEY_IDCOURS + " INTEGER, "
                + ExerciseEntry.KEY_DONNEE + " TEXT "
                + ExerciseEntry.KEY_SOLUTION + " TEXT, "
                + ");";
    }

    public static abstract class UserEntry implements BaseColumns{
        //Table name
        public static final String TABLE_USER = "user";

        //User Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_FIRSTNAME = "firstname";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_MDP= "mdp";

        //Table User create statement
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

        //Table cours_user Column names
        public static final String KEY_ID = "id";
        public static final String KEY_COURS_ID = "cours_id";
        public static final String KEY_USER_ID = "user_id";

        //Table cours_user create statement
        public static final String CREATE_TABLE_COURS_USER = "CREATE TABLE "
                + TABLE_COURS_USER + "("
                + CoursUserEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + CoursUserEntry.KEY_COURS_ID + " INTEGER, "
                + CoursUserEntry.KEY_USER_ID + " INTEGER, "
                + "FOREIGN KEY (" + KEY_COURS_ID + ") REFERENCES " + CoursEntry.TABLE_COURS + " (" + KEY_ID + "), "
                + "FOREIGN KEY (" + KEY_USER_ID + ") REFERENCES " + UserEntry.TABLE_USER + " (" + KEY_ID +") "
                + ");";
    }

    public static abstract class ExerciseChoiceEntry implements BaseColumns{
        //Table name
        public static final String TABLE_EXERCISE_CHOICE = "exercise_choice";

        //Table exercice_choice Column names
        public static final String KEY_ID = "id";
        public static final String KEY_EXERCISE_ID = "exercice_id";
        public static final String KEY_CHOICE_ID = "choice_id";

        //Table exercice_choice create statement
        public static final String CREATE_TABLE_EXERCISE_CHOICE = "CREATE TABLE "
                + TABLE_EXERCISE_CHOICE + "("
                + ExerciseChoiceEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ExerciseChoiceEntry.KEY_EXERCISE_ID + " INTEGER, "
                + ExerciseChoiceEntry.KEY_CHOICE_ID + " INTEGER, "
                + "FOREIGN KEY (" + KEY_EXERCISE_ID + ") REFERENCES " + ExerciseEntry.TABLE_EXERCISE + " (" + KEY_ID + "), "
                + "FOREIGN KEY (" + KEY_CHOICE_ID + ") REFERENCES " + ChoiceEntry.TABLE_CHOICE + " (" + KEY_ID +") "
                + ");";
    }

}
