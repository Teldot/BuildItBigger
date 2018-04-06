package com.example.android.joketellinglib.utils;

import android.content.Context;
import android.os.AsyncTask;

import com.example.android.joketellinglib.data.model.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Mauricio Torres
 * on 05/04/2018.
 */

public class FetchDataTask extends AsyncTask {
    private final Context context;
    private final AsyncTaskCompleteListener<Object> listener;

    private static final String JOKE_ID = "id";
    private static final String JOKE_TEXT = "joke";
    private static final String JOKE_AUTHOR = "author";

    public FetchDataTask(Context _context, AsyncTaskCompleteListener<Object> _listener) {
        this.context = _context;
        listener = _listener;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        JSONArray jJokeArray = JsonUtils.getJArray(context);
        if (jJokeArray == null) return null;
        int jokesLength = jJokeArray.length();
        Joke[] jokes = new Joke[jokesLength];
        for (int i = 0; i < jokesLength; i++) {
            JSONObject jokeObj = null;
            Joke joke = null;
            try {
                jokeObj = jJokeArray.getJSONObject(i);
                joke = new Joke(jokeObj.getInt(JOKE_ID),
                        jokeObj.getString(JOKE_TEXT),
                        jokeObj.getString(JOKE_AUTHOR));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            jokes[i] = joke;
        }
        return jokes;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        listener.onTaskComplete(o);
    }
}

