package com.developer.pritampc.fcmtest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by pritamPC on 2/6/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG="FCMsg";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived: "+remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0)
        {
            Log.d(TAG, "onMessageReceived: message"+remoteMessage.getData());
        }

        if(remoteMessage.getNotification()!=null)
        {
            Log.d(TAG, "onMessageReceived: "+remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String msg) {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri notificationUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        String channelId=getString(R.string.default_notification_channel_id);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_stat_ic_notification)
                .setContentText("Firebase Cloud Messaging")
                .setContentText(msg)
                .setAutoCancel(true)
                .setSound(notificationUri)
                .setContentIntent(pendingIntent);
        NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
