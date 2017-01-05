package com.example.jon.projectlearnlanguage;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import servlets.backend.choiceApi.ChoiceApi;
import servlets.backend.choiceApi.model.Choice;

/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */

public class EndpointsAsyncTaskChoice extends AsyncTask<Void, Void, List<Choice>> {
    private static ChoiceApi choiceApi = null;
    private static final String TAG = EndpointsAsyncTaskChoice.class.getName();
    private Choice choice;

    EndpointsAsyncTaskChoice(){}

    public EndpointsAsyncTaskChoice(Choice choice){
        this.choice = choice;
    }

    @Override
    protected List<Choice> doInBackground(Void... params) {

        if(choiceApi == null){
            // Only do this once
            ChoiceApi.Builder builder = new ChoiceApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // if you deploy on the cloud backend, use your app name
                    // such as https://<your-app-id>.appspot.com
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            choiceApi = builder.build();
        }

        try{
            // Call here the wished methods on the Endpoints
            // For instance insert
            if(choice != null){
                choiceApi.insert(choice).execute();
                Log.i(TAG, "insert choice");
            }
            // and for instance return the list of all employees
            return choiceApi.list().execute().getItems();

        } catch (IOException e){
            Log.e(TAG, e.toString());
            return new ArrayList<Choice>();

        }
    }

    //This method gets executed on the UI thread - The UI can be manipulated directly inside
    //of this method
    @Override
    protected void onPostExecute(List<Choice> result){

        if(result != null) {
            for (Choice choice : result) {
                Log.i(TAG, "Description : " + choice.getDescription());

            }
        }
    }

}
