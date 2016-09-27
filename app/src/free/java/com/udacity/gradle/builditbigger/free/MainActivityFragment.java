package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.Joke;
import com.example.jokeandroidlibrary.AndroidLibraryMainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment {
    Button button;
    String jokeString;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        button=(Button)root.findViewById(R.id.tellJokeButton);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        final Joke joke=new Joke();
        //Toast.makeText(getContext(),jokeString.getJoke(),Toast.LENGTH_SHORT).show();


        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        FetchJoke fetchJoke=new FetchJoke(this);
        fetchJoke.execute(new Pair<Context, String>(getContext(), "Manfred"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(),AndroidLibraryMainActivity.class);
                myIntent.putExtra("JOKE", jokeString);
                startActivity(myIntent);
            }
        });

        return root;
    }
}
