package com.example.android.joketellinglib.data.model;

import java.io.Serializable;

/**
 * Created by Mauricio Torres
 * on 05/04/2018.
 */

public class Joke implements Serializable {
    public int Id;
    public String Joke;
    public String Author;

    public Joke(int id, String joke, String author) {
        Id = id;
        Joke = joke;
        Author = author;
    }
}
