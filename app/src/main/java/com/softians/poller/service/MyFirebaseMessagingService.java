package com.softians.poller.service;

/**
 * Created by HP on 04-09-2017.
 */

public class MyFirebaseMessagingService /*extends com.google.firebase.messaging.FirebaseMessagingService*/{
//
//
//    //************************************Code to get Token *****************************************
////    private static final String TAG = "MyFirebaseMsgService";
////
////    @Override
////    public void onMessageReceived(RemoteMessage remoteMessage) {
////        //Displaying data in log
////        //It is optional
////
////        Intent intent = new Intent(this, MainActivity.class);
////        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
////                PendingIntent.FLAG_ONE_SHOT);
////        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
////        notificationBuilder.setContentTitle("Firebase Push Notification");
////        notificationBuilder.setContentText(remoteMessage.getNotification().getBody());
////        notificationBuilder.setAutoCancel(true);
////        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
////        notificationBuilder.setContentIntent(pendingIntent);
////
////        NotificationManager notificationManager =
////                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
////
////        notificationManager.notify(0, notificationBuilder.build());
////
//    //*******************************Code Ends here*****************************************************
////        Log.d(TAG, "From: " + remoteMessage.getFrom());
////        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
//
//    //Calling method to generate notification
//    //  sendNotification(remoteMessage.getNotification().getBody());
//
//    //  }
//
//    //This method is only generating push notification
//    //It is same as we did in earlier posts
//    private void sendNotification(String messageBody) {
//        Intent intent = new Intent(this, Tablay.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.logo)
//                .setContentTitle("Firebase Push Notification")
//                .setContentText(messageBody)
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri)
//                .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(0, notificationBuilder.build());
//    }
//
//    //  *********************************************************
//
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//
//        showNotification(remoteMessage.getData().get("message"));
//    }
//
//    private void showNotification(String message) {
//
//        Intent i = new Intent(this,Tablay.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
//                .setAutoCancel(true)
//                .setContentTitle("FCM Test")
//                .setContentText(message)
//                .setSmallIcon(R.drawable.logo)
//                .setContentIntent(pendingIntent);
//        Uri alarSound=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//        builder.setSound(alarSound);
//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        manager.notify(0,builder.build());
//    }

}
