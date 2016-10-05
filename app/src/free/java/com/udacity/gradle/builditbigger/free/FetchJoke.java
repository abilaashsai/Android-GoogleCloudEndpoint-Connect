package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;

import com.example.abilashr.myapplication.backend.myApi.MyApi;
import com.example.jokeandroidlibrary.AndroidLibraryMainActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;

public class FetchJoke extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private com.udacity.gradle.builditbigger.MainActivityFragment mainActivityFragment;
    Intent myIntent;

    public FetchJoke(com.udacity.gradle.builditbigger.MainActivityFragment mainActivityFragment) {

        this.mainActivityFragment = mainActivityFragment;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }
        String name = "joke";
        try {
            return myApiService.sayHi(name).execute().getData();

        } catch(IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        myIntent = new Intent(mainActivityFragment.getContext(), AndroidLibraryMainActivity.class);
        myIntent.putExtra(mainActivityFragment.getResources().getString(R.string.joke), result);
    }
    public void startDetailActivity(){
        mainActivityFragment.startActivity(myIntent);
    }
}