package com.example.android.jokedisplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jokeproviderlib.data.model.Joke;

public class JokeDisplayerActivity extends AppCompatActivity {

    private Joke joke;

    private static final String K_JOKE_INFO = "K_JOKE_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);

        if (savedInstanceState != null)
            joke = (Joke) savedInstanceState.getSerializable(K_JOKE_INFO);
        else {
            Bundle intentExtras = getIntent().getExtras();
            joke = (Joke) intentExtras.getSerializable(K_JOKE_INFO);
        }
        loadData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(K_JOKE_INFO, joke);
    }

    private void loadData() {
        ((TextView) findViewById(R.id.tv_author)).setText(joke.Author);
        ((TextView) findViewById(R.id.tv_joke)).setText(joke.Joke);
    }
}
