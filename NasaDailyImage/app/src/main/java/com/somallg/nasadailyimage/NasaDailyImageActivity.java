package com.somallg.nasadailyimage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class NasaDailyImageActivity extends Activity {

    private Handler handler;
    private IotdHandler iotdHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // fix NetworkOnMainThreadException
        // StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        // StrictMode.setThreadPolicy(policy);

        handler = new Handler();
        refreshFromFeed();
    }

    private void resetDisplay(String title, String date, Bitmap image, String description) {
        TextView titleView = (TextView) findViewById(R.id.imageTitle);
        titleView.setText(title);

        TextView dateView = (TextView) findViewById(R.id.imageDate);
        dateView.setText(date);

        ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        imageView.setImageBitmap(image);

        TextView descriptionView = (TextView) findViewById(R.id.imageDescription);
        descriptionView.setText(description);
    }

    public void onRefresh(View view) {
        refreshFromFeed();
    }

    private void refreshFromFeed() {
        final ProgressDialog dialog = ProgressDialog.show(this,
                "Loading",
                "Loading image of the day");

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (iotdHandler == null) {
                    iotdHandler = new IotdHandler();
                }

                iotdHandler.processFeed();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resetDisplay(iotdHandler.getTitle(), iotdHandler.getDate(), iotdHandler.getImage(), iotdHandler.getDescription());
                        dialog.dismiss();
                    }
                });
            }
        }).start();
    }

    public void onSetWallpaper(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(NasaDailyImageActivity.this);
                try {
                    wallpaperManager.setBitmap(iotdHandler.getImage());

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NasaDailyImageActivity.this, "Wallpaper set", Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NasaDailyImageActivity.this, "Error setting wallpaper", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }
}
