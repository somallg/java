package com.somallg.notifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

/**
 * Created by somallg on 2/17/15.
 */
public class NotificationView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        // look up the notification manager service
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(getIntent().getExtras().getInt("notificationID"));
    }
}
