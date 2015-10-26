package com.somallg.usingintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class UsingIntentActivity extends Activity {

    int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_intent);
    }

    public void onClick(View view) {
        //startActivity(new Intent("com.somallg.usingintent.SecondActivity"));

        startActivityForResult(new Intent("com.somallg.usingintent.SecondActivity"), requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
