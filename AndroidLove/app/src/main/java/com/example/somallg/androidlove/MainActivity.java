package com.example.somallg.androidlove;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoveButtonClicked(View view) {
        TextView haikuTextView = (TextView) findViewById(R.id.haiku);
        haikuTextView.setVisibility(View.VISIBLE);
    }
}