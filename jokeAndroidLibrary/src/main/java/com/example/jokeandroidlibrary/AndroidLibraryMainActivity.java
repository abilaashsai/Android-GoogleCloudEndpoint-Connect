package com.example.jokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidLibraryMainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_library_main);
        textView=(TextView)findViewById(R.id.joke_text);
        Intent intent=getIntent();
        String joke=intent.getStringExtra("JOKE");
        textView.setText(joke);
    }
}
