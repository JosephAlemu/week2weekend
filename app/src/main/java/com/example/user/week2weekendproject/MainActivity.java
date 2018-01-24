package com.example.user.week2weekendproject;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communications  {

    NotificationManager notificationManager;
    private static final String id = "45612";

    public static final String NOTIFICATION_CHANNEL_ID = "4565";
    NotificationCompat.Builder notificationBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // private static int SPLASH_TIME_OUT = 2000;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "id_product");
        notificationBuilder.setAutoCancel(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            // The user-visible name of the channel.
            CharSequence name = "Product";
            // The user-visible description of the channel.
            String description = "Notifications regarding our products";

            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);
            // Configure the notification channel.
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            // Sets the notification light color for notifications posted to this
            // channel, if the device supports this feature.
            mChannel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(mChannel);


        } else {

            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        }


    }


    public void onHandlePdfClicked(View view) {
        Toast.makeText(this, "i am here", Toast.LENGTH_SHORT).show();


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Confirmation");
        alertDialogBuilder.setMessage("would you like to open the PDF file");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(getApplicationContext(), PdfviewerActivity.class);
                startActivity(intent);
                dialog.cancel();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }




    public void OnNotificationSend(View view) {


        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 123, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setSmallIcon(R.drawable.alert) // icon
                .setBadgeIconType(R.drawable.alert) //  icon
                .setChannelId(id)
                .setContentTitle("Notification Title ")
                .setAutoCancel(true).setContentIntent(pendingIntent)
                .setNumber(1)
                .setColor(255)
                .setContentText("Hello there you just clicked notification, peace")
                .setWhen(System.currentTimeMillis());
        notificationManager.notify(1, notificationBuilder.build());


    }

    public void OnSMSSender(View view) {

        Intent intent = new Intent(getApplicationContext(), SMSActivity.class);
        startActivity(intent);
    }

    @Override
    public void listener(String data) {

           // FragmentManager fragmentManager = getFragmentManager();
            FragmentTwo  fragmentTwo  = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.frag2);
        fragmentTwo.updateCounter(data);

    }
}
