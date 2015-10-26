package com.somallg.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class NotificationsActivity extends Activity {

    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View view) {
        displayNotification();
    }

    private void displayNotification() {
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notif = new Notification(
                R.drawable.ic_launcher,
                "Reminder: Meeting starts in 5 mins",
                System.currentTimeMillis()
        );

        CharSequence from = "System Alarm";
        CharSequence message = "Meeting with customer at 3pm...";

        notif.setLatestEventInfo(this, from, message, pendingIntent);

        notif.vibrate = new long[]{100, 250, 100, 500};
        nm.notify(notificationID, notif);
    }
}
