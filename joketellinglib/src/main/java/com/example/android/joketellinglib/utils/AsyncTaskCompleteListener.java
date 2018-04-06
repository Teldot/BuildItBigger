package com.example.android.joketellinglib.utils;

public interface AsyncTaskCompleteListener<T> {
    void onTaskComplete(T result);
    void onPreExecute();
}
