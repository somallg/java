package com.somallg.passingdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class PassingDataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);
    }

    public void onClick(View view) {
        Intent i = new Intent("com.somallg.passingdata.SecondActivity");

        // use putExtra() to add new name/value pairs
        i.putExtra("str1", "This is a string");
        i.putExtra("age1", 25);

        // use Bundle object to add new name/value paris
        Bundle extras = new Bundle();
        extras.putString("str2", "This is another string");
        extras.putInt("age2", 35);

        // attach the Bundle object to the Intent object
        i.putExtras(extras);

        // start the activity to get the result back
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // get the result using getExtra()
                Toast.makeText(this, Integer.toString(
                        data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();

                // get the result using getData()
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
