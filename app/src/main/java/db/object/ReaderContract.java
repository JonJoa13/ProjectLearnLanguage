package db.object;

import android.provider.BaseColumns;

import db.object.object.Exercise;


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

        //Cours Column names
        public static final String KEY_ID = "id";
        public static final String KEY_TITRE = "titre";
        public static final String KEY_LEVEL = "level";
        public static final String KEY_NULLABLE = "";

        //Table Cours create statement
        public static final String CREATE_TABLE_COURS = "CREATE TABLE "
                + CoursEntry.TABLE_COURS + " ("
                + CoursEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + CoursEntry.KEY_TITRE + " TEXT, "
                + CoursEntry.KEY_LEVEL + " INTEGER, "
                + CoursEntry.KEY_NULLABLE + "TEXT"
                + " )";
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
        public static final String KEY_NULLABLE = "";

        //Table Exercise create statement
        public static final String CREATE_TABLE_EXERCISE = "CREATE TABLE "
                + ExerciseEntry.TABLE_EXERCISE + " ("
                + ExerciseEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ExerciseEntry.KEY_TITRE + " TEXT, "
                + ExerciseEntry.KEY_TYPE + " TEXT, "
                + ExerciseEntry.KEY_IDCOURS + " INTEGER, "
                + ExerciseEntry.KEY_DONNEE + " TEXT, "
                + ExerciseEntry.KEY_SOLUTION + " TEXT, "
                + ExerciseEntry.KEY_NULLABLE + "TEXT"
                + " )";
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
        public static final String KEY_NULLABLE = "";

        //Table User create statement
        public static final String CREATE_TABLE_USER = "CREATE TABLE "
                + UserEntry.TABLE_USER + " ("
                + UserEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + UserEntry.KEY_NAME + " TEXT, "
                + UserEntry.KEY_FIRSTNAME + " TEXT, "
                + UserEntry.KEY_EMAIL + " TEXT, "
                + UserEntry.KEY_MDP + " TEXT, "
                + UserEntry.KEY_NULLABLE + " TEXT"
                + " )";
    }

    //Represents the rows of a table
    public static abstract class ChoiceEntry implements BaseColumns {
        //Table name
        public static final String TABLE_CHOICE = "choix";

        //Choice Column names
        public static final String KEY_ID = "id";
        public static final String KEY_DESCR = "descr";
        public static final String KEY_CHOICE1 = "choice1";
        public static final String KEY_CHOICE2 = "choice2";
        public static final String KEY_CHOICE3 = "choice3";
        public static final String KEY_NULLABLE = "";

        //Table choice create statement
        public static final String CREATE_TABLE_CHOICE = "CREATE TABLE "
                + ChoiceEntry.TABLE_CHOICE + "("
                + ChoiceEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ChoiceEntry.KEY_DESCR + " TEXT, "
                + ChoiceEntry.KEY_CHOICE1 + " TEXT, "
                + ChoiceEntry.KEY_CHOICE2 + " TEXT, "
                + ChoiceEntry.KEY_CHOICE3 + " TEXT, "
                + ChoiceEntry.KEY_NULLABLE + " TEXT"
                + " )";
    }

    //Represents the rows of a table
    public static abstract class CoursUserEntry implements BaseColumns{
        //Table name
        public static final String TABLE_COURS_USER = "cours_user";

        //Table cours_user Column names
        public static final String KEY_ID = "id";
        public static final String KEY_COURS_ID = "cours_id";
        public static final String KEY_USER_ID = "user_id";
        public static final String KEY_NULLABLE = "";

        //Table cours_user create statement
        public static final String CREATE_TABLE_COURS_USER = "CREATE TABLE "
                + CoursUserEntry.TABLE_COURS_USER + " ("
                + CoursUserEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + CoursUserEntry.KEY_COURS_ID + " INTEGER, "
                + CoursUserEntry.KEY_USER_ID + " INTEGER, "
                + CoursUserEntry.KEY_NULLABLE + "TEXT,"
                + "FOREIGN KEY (" + KEY_COURS_ID + ") REFERENCES " + CoursEntry.TABLE_COURS + " (" + KEY_ID + "), "
                + "FOREIGN KEY (" + KEY_USER_ID + ") REFERENCES " + UserEntry.TABLE_USER + " (" + KEY_ID +")"
                + " )";
    }

    public static abstract class ExerciseChoiceEntry implements BaseColumns{
        //Table name
        public static final String TABLE_EXERCISE_CHOICE = "exercise_choice";

        //Table exercice_choice Column names
        public static final String KEY_ID = "id";
        public static final String KEY_EXERCISE_ID = "exercice_id";
        public static final String KEY_CHOICE_ID = "choice_id";
        public static final String KEY_NULLABLE = "";

        //Table exercice_choice create statement
        public static final String CREATE_TABLE_EXERCISE_CHOICE = "CREATE TABLE "
                + ExerciseChoiceEntry.TABLE_EXERCISE_CHOICE + "("
                + ExerciseChoiceEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + ExerciseChoiceEntry.KEY_EXERCISE_ID + " INTEGER, "
                + ExerciseChoiceEntry.KEY_CHOICE_ID + " INTEGER, "
                + ExerciseChoiceEntry.KEY_NULLABLE + "TEXT,"
                + "FOREIGN KEY (" + KEY_EXERCISE_ID + ") REFERENCES " + ExerciseEntry.TABLE_EXERCISE + " (" + KEY_ID + "), "
                + "FOREIGN KEY (" + KEY_CHOICE_ID + ") REFERENCES " + ChoiceEntry.TABLE_CHOICE + " (" + KEY_ID +") "
                + " )";
    }

}
