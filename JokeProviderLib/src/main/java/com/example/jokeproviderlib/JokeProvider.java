package com.example.jokeproviderlib;

import com.example.jokeproviderlib.data.model.Joke;
import com.example.jokeproviderlib.utils.JsonUtils;

import java.util.Random;

public class JokeProvider {

    private Joke[] jokes;

    public JokeProvider() {
        loadJokes();
    }

    private void loadJokes() {
        jokes = JsonUtils.getJArray();
    }

    public Joke tellMeAJoke() {
        if (jokes == null || jokes.length == 0)
            return new Joke(0, "loading jokes...", "");

        Random rand = new Random();
        int jokeIdx = rand.nextInt(jokes.length);
        return jokes[jokeIdx];
    }
}

