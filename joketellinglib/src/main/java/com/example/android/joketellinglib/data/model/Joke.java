package com.example.android.joketellinglib.data.model;

/**
 * Created by Mauricio Torres
 * on 05/04/2018.
 */

public class Joke {
    public int Id;
    public String Joke;
    public String Author;

    public Joke(int id, String joke, String author) {
        Id = id;
        Joke = joke;
        Author = author;
    }
}
