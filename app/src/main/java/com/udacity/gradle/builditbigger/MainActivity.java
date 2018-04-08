package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.jokedisplayer.JokeDisplayerActivity;
import com.example.jokeproviderlib.JokeProvider;
import com.example.jokeproviderlib.data.model.Joke;


public class MainActivity extends AppCompatActivity implements AsyncTaskCompleteListener {
    private JokeProvider jokeProvider;
    private static final String K_JOKE_INFO = "K_JOKE_INFO";
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.progressBar1);
        jokeProvider = new JokeProvider();
        spinner.setVisibility(View.GONE);
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
        spinner.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }


    @Override
    public void onTaskComplete(com.udacity.gradle.builditbigger.backend.myApi.model.Joke result) {
        if (result == null)
            Toast.makeText(this, getString(R.string.endpoint_error), Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(this, result.getJoke(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, JokeDisplayerActivity.class);
            Joke serializableJoke = new Joke(0, result.getJoke(), result.getAuthor());
            intent.putExtra(K_JOKE_INFO, serializableJoke);
            startActivity(intent);
        }
        spinner.setVisibility(View.GONE);
    }
}
