package com.somallg.usingintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by somallg on 2/17/15.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactiviy);
    }

    public void onClick(View view) {
        Intent data = new Intent();

        // get the EditText view
        EditText txtUsername = (EditText) findViewById(R.id.txt_username);

        // set the data to pass back
        data.setData(Uri.parse(txtUsername.getText().toString()));
        setResult(RESULT_OK, data);

        // closes the activity
        finish();
    }
}
