package com.marketplace.kelompok2.kue.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.marketplace.kelompok2.kue.R;
import com.marketplace.kelompok2.kue.ui.home.HomeActivity;

import java.util.Map;
import java.util.Random;

public class PembeliFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().isEmpty()) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
         //   sendNotification(remoteMessage.getNotification().getBody());
        }

        sendNotification(remoteMessage.getData());

    }

    private void sendNotification(Map<String, String> data) {

        String messageBody = data.get("body");
       // String messageBody = "LALALALA";
        String title = data.get("title");
        String NOTIFIKASION_CHANNEL_ID = "com.marketplace.kelompok2.kue.service";
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("state", 2);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                    new NotificationChannel(NOTIFIKASION_CHANNEL_ID,"notification",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("FCM test");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(R.color.biru);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            notificationChannel.enableLights(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                ;

        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());
    }

//    private void sendNotification(String messageBody) {
//        String NOTIFIKASION_CHANNEL_ID = "com.marketplace.kelompok2.kue.service";
//        Intent intent = new Intent(this, HomeActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            NotificationChannel notificationChannel =
//                    new NotificationChannel(NOTIFIKASION_CHANNEL_ID,"notification",NotificationManager.IMPORTANCE_DEFAULT);
//            notificationChannel.setDescription("FCM test");
//            notificationChannel.enableLights(true);
//            notificationChannel.setLightColor(R.color.biru);
//            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
//            notificationChannel.enableLights(true);
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("FCM Message")
//                .setContentText(messageBody)
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri)
//                //.setContentIntent(pendingIntent)
//        ;
//
//        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());
//    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d(TAG, "Refreshed token: " + s);
    }
}