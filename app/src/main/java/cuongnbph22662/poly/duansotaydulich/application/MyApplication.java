package cuongnbph22662.poly.duansotaydulich.application;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;

public class MyApplication extends Application {
    private static final String CHANNEL_ID = "push_notification_id";

    @Override
    public void onCreate() {
        super.onCreate();
        createChannelNotifcation();
        DataLocalManager.init(getApplicationContext());
    }

    private void createChannelNotifcation() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"PushNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }


}
