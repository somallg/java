package com.somallg.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("Fragment 2", "onCreateView");

        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Fragment 2", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment 2", "onCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment 2", "onActivity");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment 2", "onStart");

        // Button view
        Button btnGetText = (Button) getActivity().findViewById(R.id.btnGetText);
        btnGetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.lblFragment1);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment 2", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment 2", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment 2", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment 2", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment 2", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment 2", "onDetach");
    }
}
