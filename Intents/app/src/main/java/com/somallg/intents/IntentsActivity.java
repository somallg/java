package com.somallg.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class IntentsActivity extends Activity {

    int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickWebBrowser(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(i);
    }

    public void onClickMakeCalls(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+123456789"));
        startActivity(i);
    }

    public void onClickShowMap(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
        startActivity(i);
    }

    public void onClickLaunchMyBrowser(View view) {
        //Intent i = new Intent("com.somallg.MyBrowser");
        //i.setData(Uri.parse("http://www.google.com"));
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        i.addCategory("com.somallg.Apps");
        startActivity(i);
    }
}
