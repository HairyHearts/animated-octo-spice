package org.hairyhearts;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GCMService extends IntentService {

    public GCMService() {
        super("GCMService");

        Log.d("GCMService", "");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        String messageType = gcm.getMessageType(intent);
        if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Log.d("RECEIVED", "MESSAGE: " + extras.toString());
            }
        }
        GCMReceiver.completeWakefulIntent(intent);
    }
}
