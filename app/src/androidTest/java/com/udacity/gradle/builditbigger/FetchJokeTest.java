package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;

public class FetchJokeTest {
    String asyncResult;

    @Test
    public void asyncTaskShouldNotReturnNull() throws InterruptedException, ExecutionException {

        final CountDownLatch signal = new CountDownLatch(1);

        com.udacity.gradle.builditbigger.FetchJoke fetchJoke = new com.udacity.gradle.builditbigger.FetchJoke(new com.udacity.gradle.builditbigger.MainActivityFragment()) {
            @Override
            protected void onPostExecute(String result) {
                asyncResult = result;
            }
        };

        fetchJoke.execute();
        signal.await(10, TimeUnit.SECONDS);
        assertNotNull(asyncResult);
    }
}
