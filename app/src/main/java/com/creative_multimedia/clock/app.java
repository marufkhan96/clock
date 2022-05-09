package com.creative_multimedia.clock;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class app extends Application {
    public static final String CHANNELID   = "Foreground Service ID";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificaionChannel();
    }

    private void createNotificaionChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           NotificationChannel channel = new NotificationChannel(
                    CHANNELID,
                    "app notification",
                    NotificationManager.IMPORTANCE_HIGH
            );

           NotificationManager manager = getSystemService(NotificationManager.class);
           manager.createNotificationChannel(channel);
        }
    }
}
