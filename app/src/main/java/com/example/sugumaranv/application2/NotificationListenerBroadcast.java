package com.example.sugumaranv.application2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationListenerBroadcast extends BroadcastReceiver {

    public static final String ACTION_CUSTOM = "notification.app.one.receive";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_CUSTOM.equals(intent.getAction())) {
            // do custom action
//            Toast.makeText(NotificationListenerBroadcast.this, "App one notification from broadcast receiver",Toast.LENGTH_SHORT).show();
            System.out.println("App one notification from broadcast receiver.........*************");
        }
    }
}
