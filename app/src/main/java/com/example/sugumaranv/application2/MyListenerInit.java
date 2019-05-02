package com.example.sugumaranv.application2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.google.firebase.messaging.RemoteMessage;

public class MyListenerInit {

    public void initBroadCastListener(Context context){

//        NotificationListenerBroadcast broadcastReceiver = new NotificationListenerBroadcast();

        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, new IntentFilter("push.foreground.app2.MyListenerInit"));
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent!=null && intent.hasExtra("title")&& intent.hasExtra("body")&& intent.hasExtra("line1")&& intent.hasExtra("line2")){
                String title = intent.getStringExtra("title");
                String message = intent.getStringExtra("body");
                String line1 = intent.getStringExtra("line1");
                String line2 = intent.getStringExtra("line2");

                Toast.makeText(context,
                        "Title:"+title+
                                " Body:"+message+
                                " line1:"+line1+
                                " line2:"+line2,
                        Toast.LENGTH_SHORT).show();
            }
        }
    };


    public void checkRemoteMessages(Context context, RemoteMessage remoteMessage){

        RemoteMessage.Notification  notification = remoteMessage.getNotification();

        String line1 = remoteMessage.getData().get("line1");
        String line2 = remoteMessage.getData().get("line2");
//
//        String body = notification.getBody();
//        String title = notification.getTitle();
//
//        Intent intent = new Intent("push.foreground");
//        intent.putExtra("title", title);
//        intent.putExtra("body", body);
//        intent.putExtra("line1", line1);
//        intent.putExtra("line2", line2);
//        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
//        localBroadcastManager.sendBroadcast(intent);

        if(line2.equalsIgnoreCase("From App Two")) {
            context.startActivity(new Intent(context, AppTwo.class));
        }

    }
}
