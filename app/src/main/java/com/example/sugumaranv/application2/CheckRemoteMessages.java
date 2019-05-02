package com.example.sugumaranv.application2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.messaging.RemoteMessage;

//import com.google.firebase.messaging.RemoteMessage;

public class CheckRemoteMessages {

    private static CheckRemoteMessages sSoleInstance;

    //private constructor.
    private CheckRemoteMessages(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static CheckRemoteMessages getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new CheckRemoteMessages();
        }

        return sSoleInstance;
    }

    public void checkRemoteMessagess(Context context, RemoteMessage remoteMessage){

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

 public void checkIntentMessages(Context context, Intent intent){


        String line2 = intent.getStringExtra("line2");
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
