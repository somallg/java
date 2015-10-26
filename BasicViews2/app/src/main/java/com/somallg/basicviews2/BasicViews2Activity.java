package com.somallg.basicviews2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;


public class BasicViews2Activity extends Activity {
    static int progress;
    ProgressBar progressBar;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        progress = 0;
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setMax(200);

        // do some work in the background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do some work here
                while (progressStatus < 100) {
                    progressStatus = doSomeWork();

                    // Update the progress bar
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                }

                // hide the progressbar
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 0 - VISIBLE, 4 - INVISIBLE, 8 - GONE
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }

            private int doSomeWork() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return progress++;
            }
        }).start();
    }
}
