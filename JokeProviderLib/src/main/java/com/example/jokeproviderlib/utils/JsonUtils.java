package com.example.jokeproviderlib.utils;


import com.example.jokeproviderlib.data.model.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mauricio Torres
 * on 05/04/2018.
 */

public class JsonUtils {
    private static final String JOKE_ID = "id";
    private static final String JOKE_TEXT = "joke";
    private static final String JOKE_AUTHOR = "author";
    private static final String JokesString = "[{\"id\":1,\"author\": \"https://www.hongkiat.com/blog/programming-jokes/\",\"joke\": \"Programmer(noun.): A machine that turns coffe into code.\"},{\"id\": 2,\"author\": \"https://www.hongkiat.com/blog/programming-jokes/\",\"joke\": \"Programmer(noun.): A person who fixed a problem that you don't know you have, in a way you don't understand.\"},{\"id\": 3,\"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Algorithm(noun.): Word used by programmers when... they do not want to explain what they did.\"}, {\"id\": 4, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Hardware(noun.): The part of a computer that you can kick.\"}, {\"id\": 5, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Q: What's the object-oriented way to become wealthy?\\nA: Inheritance.\"}, {\"id\": 6, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Q: What do you call a programmer from Finland?\\nA: Nerdic\"}, {\"id\": 7, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Q: Why did the programmer quit his job?\\nA: Because he didn't get arrays(a raise).\"}, {\"id\": 8, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Q: '0' is false and '1' is true, right?\\nA: 1\"}, {\"id\": 9, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Q: What do computers and air conditioners have in common?\\nA: They both become useless when you open windows.\"}, {\"id\": 10, \"author\": \"https://www.hongkiat.com/blog/programming-jokes/\", \"joke\": \"Q: Why do Java programmers have to wear glasses?\\nA: Because they don't C#.\"}]";

    public static Joke[] getJArray() {
        Joke[] jokes = null;
        try {
            JSONArray jJokeArray = new JSONArray(JokesString);
            int jokesLength = jJokeArray.length();
            jokes = new Joke[jokesLength];
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jokes;
    }
}
