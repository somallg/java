package com.somallg.uicode;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class UICodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_uicode);

        // param for views
        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        // create a layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // create a textview
        TextView tv = new TextView(this);
        tv.setText("This is a TextView");
        tv.setLayoutParams(params);


        // create a button
        Button btn = new Button(this);
        btn.setText("This is a Button");
        btn.setLayoutParams(params);

        // adds the textview
        layout.addView(tv);

        // adds the button
        layout.addView(btn);

        // create a layout param for the layout
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        this.addContentView(layout, layoutParams);

    }

}
