package com.example.jokeproviderlib.data.model;

import java.io.Serializable;

/**
 * Created by Mauricio Torres
 * on 05/04/2018.
 */

public class Joke implements Serializable {
    private final int Id;
    public final String Joke;
    public final String Author;

    public Joke(int id, String joke, String author) {
        Id = id;
        Joke = joke;
        Author = author;
    }
}
