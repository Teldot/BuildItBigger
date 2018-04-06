package com.example.android.joketellinglib.data;

import android.content.Context;

import com.example.android.joketellinglib.data.model.Joke;
import com.example.android.joketellinglib.utils.AsyncTaskCompleteListener;
import com.example.android.joketellinglib.utils.FetchDataTask;

import java.util.Random;

/**
 * Created by Mauricio Torres
 * on 05/04/2018.
 */

public class JokeProvider implements AsyncTaskCompleteListener {
    private final Context context;

    private Joke[] jokes;

    public JokeProvider(Context _context) {
        this.context = _context;
        loadJokes();
    }

    private void loadJokes() {
        FetchDataTask dataTask = new FetchDataTask(context, this);
        dataTask.execute();
    }

    public Joke tellMeAJoke() {
        if (jokes == null || jokes.length == 0)
            return new Joke(0, "loading jokes...", "");

        Random rand = new Random();
        int jokeIdx = rand.nextInt(jokes.length);
        return jokes[jokeIdx];
    }

    @Override
    public void onTaskComplete(Object result) {
        jokes = (Joke[]) result;
    }

    @Override
    public void onPreExecute() {

    }
}
