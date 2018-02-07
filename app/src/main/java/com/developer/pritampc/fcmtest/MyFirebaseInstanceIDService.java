package com.developer.pritampc.fcmtest;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by pritamPC on 2/6/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG="IdService";
    @Override
    public void onTokenRefresh() {
        String token= FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG, "onTokenRefresh: "+token);
        sendtoserver(token);
    }

    private void sendtoserver(String token) {
        // send token to app server/database
    }
}
