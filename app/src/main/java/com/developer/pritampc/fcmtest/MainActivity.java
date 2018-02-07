package com.developer.pritampc.fcmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // FirebaseMessaging.getInstance().subscribeToTopic();
        MyFirebaseInstanceIDService service=new MyFirebaseInstanceIDService();
        service.onTokenRefresh();
       // MyFirebaseMessagingService myFirebaseMessagingService=new MyFirebaseMessagingService();
    }
}
