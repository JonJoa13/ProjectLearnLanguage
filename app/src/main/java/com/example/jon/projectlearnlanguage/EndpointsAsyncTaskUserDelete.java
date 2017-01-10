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

import servlets.backend.userApi.UserApi;
import servlets.backend.userApi.model.User;

/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */

public class EndpointsAsyncTaskUserDelete extends AsyncTask<Void, Void, List<User>> {
    private static UserApi userApi = null;
    private static final String TAG = EndpointsAsyncTaskUser.class.getName();
    private User user;

    EndpointsAsyncTaskUserDelete(){}

    public EndpointsAsyncTaskUserDelete(User user){
        this.user = user;
    }

    @Override
    protected List<User> doInBackground(Void... params) {

        if(userApi == null){
            // Only do this once
            UserApi.Builder builder = new UserApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // if you deploy on the cloud backend, use your app name
                    // such as https://<your-app-id>.appspot.com
                    .setRootUrl("https://hes-project-learnlanguage.appspot.com/_ah/api/");

            userApi = builder.build();
        }

        try{
            // Call here the wished methods on the Endpoints
            // For instance insert
            if(user != null){
                userApi.remove(user.getId()).execute();
                Log.i(TAG, "delete user");
            }
            // and for instance return the list of all employees
            return userApi.list().execute().getItems();

        } catch (IOException e){
            Log.e(TAG, e.toString());
            return new ArrayList<User>();
        }
    }

    //This method gets executed on the UI thread - The UI can be manipulated directly inside
    //of this method
    @Override
    protected void onPostExecute(List<User> result){

        if(result != null) {
            for (User user : result) {
                Log.i(TAG, "First name: " + user.getFirstname() + " Last name: "
                        + user.getName());

            }
        }
    }

}
