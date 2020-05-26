package com.example.example;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class BroadcastD2 extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.shoot);//Assign notification photos

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,//Implementing a move by pressing a notification
                new Intent(context.getApplicationContext(), Num2Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        String channelId = "channel";
        String channelName = "channel Name";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.enableVibration(true);
        notificationManager.createNotificationChannel(channel);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)//Notificationavatar
                .setSmallIcon(R.drawable.shoot)
                .setContentTitle("There is a notification ~")
                .setContentText("Check Out Today's Lucky Numbers!")
                .setDefaults(Notification.DEFAULT_ALL)
                .setLargeIcon(bitmap)
                .setTicker("Single line output")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager_1 = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager_1.notify(0, builder.build());
    }
}
