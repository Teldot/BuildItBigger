package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;


interface AsyncTaskCompleteListener {
    void onTaskComplete(Joke result);
}
