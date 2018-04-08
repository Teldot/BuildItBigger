package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;

class EndpointsAsyncTask  extends AsyncTask<Void, Void, Joke> {
    private static MyApi myApiService = null;
    private final AsyncTaskCompleteListener listener;

    public EndpointsAsyncTask(AsyncTaskCompleteListener _listener) {
        listener = _listener;
    }

    @Override
    protected Joke doInBackground(Void... voids) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        //context = params[0].first;
        //String name = params[0].second;

        Joke res = null;
        try {
            res = myApiService.getJoke().execute().getMyJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    @Override
    protected void onPostExecute(Joke result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        listener.onTaskComplete(result);
    }


}
