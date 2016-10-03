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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivityFragment extends Fragment {
    Button button;
    String jokeString;
    FetchJoke fetchJoke;
    InterstitialAd mInterstitialAd;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        button=(Button)root.findViewById(R.id.tellJokeButton);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        final Joke joke=new Joke();
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                startDetailActivity();
            }
        });

        requestNewInterstitial();

        //Toast.makeText(getContext(),jokeString.getJoke(),Toast.LENGTH_SHORT).show();


        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        fetchJoke=new FetchJoke(this);
        fetchJoke.execute();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }else{
                    startDetailActivity();
                }
            }
        });

        return root;
    }

    private void startDetailActivity() {
        Intent myIntent = new Intent(getContext(), AndroidLibraryMainActivity.class);
        myIntent.putExtra(getResources().getString(R.string.joke), jokeString);
        startActivity(myIntent);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(getResources().getString(R.string.device_id))
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

}
