package com.example.jon.projectlearnlanguage;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import servlets.backend.coursApi.CoursApi;
import servlets.backend.coursApi.model.Cours;

/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */

public class EndpointsAsyncTaskCoursUpdate extends AsyncTask<Void, Void, List<Cours>> {
    private static CoursApi coursApi = null;
    private static final String TAG = EndpointsAsyncTaskCours.class.getName();
    private Cours cours;

    EndpointsAsyncTaskCoursUpdate(){}

    public EndpointsAsyncTaskCoursUpdate(Cours cours){
        this.cours = cours;
    }

    @Override
    protected List<Cours> doInBackground(Void... params) {

        if(coursApi == null){
            // Only do this once
            CoursApi.Builder builder = new CoursApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // if you deploy on the cloud backend, use your app name
                    // such as https://<your-app-id>.appspot.com
                    .setRootUrl("https://hes-project-learnlanguage.appspot.com/_ah/api/");

            coursApi = builder.build();
        }

        try{
            // Call here the wished methods on the Endpoints
            // For instance insert
            if(cours != null){
                coursApi.update(cours.getId(),cours).execute();
                Log.i(TAG, "update cours");
            }
            // and for instance return the list of all employees
            return coursApi.list().execute().getItems();

        } catch (IOException e){
            Log.e(TAG, e.toString());
            return new ArrayList<Cours>();
        }
    }

    //This method gets executed on the UI thread - The UI can be manipulated directly inside
    //of this method
    @Override
    protected void onPostExecute(List<Cours> result){

        if(result != null) {
            for (Cours cours : result) {
                Log.i(TAG, "Titel: " + cours.getTitre() + " / Level : "
                        + cours.getLevel());

            }
        }
    }

}
