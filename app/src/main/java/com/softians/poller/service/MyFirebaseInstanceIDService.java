package com.softians.poller.service;

/**
 * Created by HP on 04-09-2017.
 */

public class MyFirebaseInstanceIDService  /*extends FirebaseInstanceIdService*/ {
//    public static SharedPreferences sharedpreferences1;
//
//    //*****************************SHARRED PREFERENCES TO STORE DATA****
//    public static final String myToken = "mytoken";
//    public static final String userToken = "token";
//    //****************************END HERE*************************z
//
//
//    //*********************Code to check if token did receive or not *****************************************
////    private static final String TAG = "MyFirebaseIIDService";
////
////    @Override
////    public void onTokenRefresh() {
////
////        //Getting registration token
////        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
////
////        //Displaying token on logcat
////        Log.d(TAG, "Refreshed token: " + refreshedToken);
////        Toast.makeText(this, refreshedToken, Toast.LENGTH_SHORT).show();
////
////    }
//
////    private void sendRegistrationToServer(String token) {
////        //You can implement this method to store the token on your server
////        //Not required for current project
////    }
////**************************************************Ends Here*************************************************
//
//
//    @Override
//    public void onTokenRefresh() {
//        sharedpreferences1 = getSharedPreferences(myToken, Context.MODE_PRIVATE);
//
////        if(sharedpreferences.contains(MainActivity.Email))
////        {
//////            Variables.a++;
//////            Variables.islogin=2;
////            Variables.client_email = sharedpreferences.getString(MainActivity.Email, "");
////
////        }
//
//        Config.token = FirebaseInstanceId.getInstance().getToken();
//        System.out.println("Token :-"+Config.token);
//
//        Log.d(TAG, "***Refreshed token:*** " + Config.token);
//
//
//
//
//        //*****************************Storing token in the shared preference********************
//        // String tn = token;
//        SharedPreferences.Editor editor = sharedpreferences1.edit();
//        editor.putString(userToken, Config.token);
//
//        editor.apply();
//        // *******************************Shared preferece ends here********************************
//        //registerToken(token);
//
//
//
//    }
//
////    private void registerToken(String token) {
////        String mail = sharedpreferences.getString(MainActivity.Email, "");//"abc@example.com";
////        OkHttpClient client = new OkHttpClient();
////        FormBody.Builder formbuilders= new FormBody.Builder().add("Token",token);
////        formbuilders.add("Mail",mail);
////
////        RequestBody body = formbuilders.build();
////        //
////        Request request = new Request.Builder()
////                .url(Links.USER_TOKEN)
////                .post(body)
////                .build();
////
////        try {
////            client.newCall(request).execute();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
}
