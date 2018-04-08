package com.udacity.gradle.builditbigger.backend;

import com.example.jokeproviderlib.data.model.Joke;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private Joke MyJoke;

    public Joke getMyJoke() {
        return MyJoke;
    }

    public void setMyJoke(Joke myJoke) {
        MyJoke = myJoke;
    }


}