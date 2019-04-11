package com.example.firebasenotification;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        FirebaseApp.initializeApp(this);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody()) ;
    }

    public void showNotification(String title,String message){
       /* @SuppressLint("ResourceAsColor") NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"MyNotification")
                .setContentTitle(title)
                .setColor(R.color.colorAccent)
                .setAutoCancel(true)
                .setContentText(message);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(11,builder.build());*/
        Notification notification=new NotificationCompat.Builder(this).setContentTitle(title).setContentText(message)
                .setAutoCancel(true).build();
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);
    }
}