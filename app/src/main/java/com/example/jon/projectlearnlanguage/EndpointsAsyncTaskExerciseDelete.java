package com.example.jon.projectlearnlanguage;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import servlets.backend.exerciseApi.ExerciseApi;
import servlets.backend.exerciseApi.model.Exercise;

/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */

public class EndpointsAsyncTaskExerciseDelete extends AsyncTask<Void, Void, List<Exercise>> {
    private static ExerciseApi exerciseApi = null;
    private static final String TAG = EndpointsAsyncTaskExercise.class.getName();
    private Exercise exercise;

    EndpointsAsyncTaskExerciseDelete(){}

    public EndpointsAsyncTaskExerciseDelete(Exercise exercise){
        this.exercise = exercise;
    }

    @Override
    protected List<Exercise> doInBackground(Void... params) {

        if(exerciseApi == null){
            // Only do this once
            ExerciseApi.Builder builder = new ExerciseApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // if you deploy on the cloud backend, use your app name
                    // such as https://<your-app-id>.appspot.com
                    .setRootUrl("https://hes-project-learnlanguage.appspot.com/_ah/api/");

            exerciseApi = builder.build();
        }

        try{
            // Call here the wished methods on the Endpoints
            // For instance insert
            if(exercise != null){
                exerciseApi.remove(exercise.getId()).execute();
                Log.i(TAG, "delete exercise");
            }
            // and for instance return the list of all employees
            return exerciseApi.list().execute().getItems();

        } catch (IOException e){
            Log.e(TAG, e.toString());
            return new ArrayList<Exercise>();
        }
    }

    //This method gets executed on the UI thread - The UI can be manipulated directly inside
    //of this method
    @Override
    protected void onPostExecute(List<Exercise> result){

        if(result != null) {
            for (Exercise exercise : result) {
                Log.i(TAG, "Title : " + exercise.getTitre() + " / rule : " +exercise.getDonnee());

            }
        }
    }

}
