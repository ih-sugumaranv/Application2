 package com.example.sugumaranv.application2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.adjust.sdk.Adjust;

//import com.google.firebase.iid.FirebaseInstanceId;

 public class AppTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);


        setContentView(R.layout.activity_app_two);

        WebView  webView = findViewById(R.id.webView);
        webView.loadUrl("https://app.iicontact.com/");

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                Log.d("APPTWO", "Key: " + key + " Value: " + value);

            }
        }

//        String notificationToken = FirebaseInstanceId.getInstance().getToken();
//        System.out.println("notificationToken: "+notificationToken);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("push.foreground.app2.Activity"));

    }


     private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
         @Override
         public void onReceive(Context context, Intent intent) {

             if(intent!=null && intent.hasExtra("title")&& intent.hasExtra("body")&& intent.hasExtra("line1")&& intent.hasExtra("line2")){
                 String title = intent.getStringExtra("title");
                 String message = intent.getStringExtra("body");
                 String line1 = intent.getStringExtra("line1");
                 String line2 = intent.getStringExtra("line2");

                 Toast.makeText(AppTwo.this,
                         "Title:"+title+
                                 " Body:"+message+
                                 " line1:"+line1+
                                 " line2:"+line2,
                         Toast.LENGTH_SHORT).show();
             }
         }
     };

     @Override
     protected void onPause() {
         super.onPause();
         LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
     }

     @Override
     protected void onResume() {
         super.onResume();
         Intent intent = getIntent();

         if(intent!=null && intent.hasExtra("title")&& intent.hasExtra("body")){
             String title = intent.getStringExtra("title");
             String message = intent.getStringExtra("body");
             Toast.makeText(AppTwo.this, "Title:"+title+"\n Message:"+message, Toast.LENGTH_SHORT).show();
         }
     }
 }