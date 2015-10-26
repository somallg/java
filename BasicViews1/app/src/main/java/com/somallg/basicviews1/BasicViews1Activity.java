package com.somallg.basicviews1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;


public class BasicViews1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_views1);

        // Button view
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayToast("You have clicked the open button");
            }
        });

        // Button view
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayToast("You have clicked the save button");
            }
        });

        // checkbox
        CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    DisplayToast("Checkbox is checked");
                } else {
                    DisplayToast("Checkbox is unchecked");
                }
            }
        });

        // RadioButton
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdbGp1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(R.id.rdb1);

                DisplayToast("Option " + checkedId + " selected");

                if (rb.isChecked()) {
                    DisplayToast("Option 1 checked");
                } else {
                    DisplayToast("Option 2 checked");
                }
            }
        });

        // ToggleButton
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle1);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ToggleButton) v).isChecked()) {
                    DisplayToast("Toggle button is on");
                } else {
                    DisplayToast("Toggle button is off");
                }
            }
        });

    }

    private void DisplayToast(String s) {
        Toast.makeText(getBaseContext(), s,
                Toast.LENGTH_SHORT).show();
    }

}
