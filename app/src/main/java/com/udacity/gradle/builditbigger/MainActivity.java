package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.jokedisplayer.JokeDisplayerActivity;
import com.example.android.joketellinglib.data.JokeProvider;
import com.example.android.joketellinglib.data.model.Joke;


public class MainActivity extends AppCompatActivity {
    JokeProvider jokeProvider;
    private static final String K_JOKE_INFO = "K_JOKE_INFO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeProvider = new JokeProvider(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Joke joke = jokeProvider.tellMeAJoke();
        Toast.makeText(this, joke.Joke, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, JokeDisplayerActivity.class);
        intent.putExtra(K_JOKE_INFO, joke);
        startActivity(intent);
    }


}
