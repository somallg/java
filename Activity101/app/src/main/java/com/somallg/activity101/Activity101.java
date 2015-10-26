package com.somallg.activity101;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class Activity101 extends Activity {
    String tag = "Lifecycle";

    /** Called when the activity is first created **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_activity101);
        Log.d(tag, "In the onCreate() event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }
}
