package com.somallg.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;


public class FragmentsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /*
        // add fragments dynamically
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // get the current display info
        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();

        if (d.getWidth() > d.getHeight()) {
            // landscape mode
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(android.R.id.content, fragment1);
        } else {
            // portrait mode
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(android.R.id.content, fragment2);
        }
        fragmentTransaction.commit(); */
    }
}
