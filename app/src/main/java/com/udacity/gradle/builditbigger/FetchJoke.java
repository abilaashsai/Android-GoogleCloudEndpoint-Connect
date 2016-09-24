package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchJoke extends AsyncTask<Void,Void,Void>{
    @Override
    protected Void doInBackground(Void... params) {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://10.0.3.2:8080/");

            urlConnection = (HttpURLConnection) url
                    .openConnection();
            InputStream in = urlConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }
//            System.out.println(result.toString());
            Log.v("hai",result.toString());

//            InputStreamReader isw = new InputStreamReader(in);
//            String s;
//
//            int data = isw.read();
//            while (data != -1) {
//                s=data;
//                char current = (char) data;
//                data = isw.read();
//                System.out.print(current);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }
}
