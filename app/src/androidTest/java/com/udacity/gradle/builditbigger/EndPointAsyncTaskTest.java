package com.udacity.gradle.builditbigger;


import android.util.Log;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import org.junit.Test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;


public class EndPointAsyncTaskTest {
    private Joke myJoke = null;


    @Test
    public void getJoke() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointsAsyncTask task = new EndpointsAsyncTask(new AsyncTaskCompleteListener() {
            @Override
            public void onTaskComplete(Joke result) {
                myJoke = result;
                signal.countDown();
            }
        });
        task.execute();
        signal.await(10, TimeUnit.SECONDS);
        assertNotNull("myJoke is not null:",myJoke);
        assertNotNull("myJoke.getJoke():",myJoke.getJoke());
        Log.i("testGetJoke",myJoke.getJoke());
    }
}
