package com.softians.poller.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.softians.poller.R;
import com.softians.poller.app.Config;

import static com.softians.poller.activitys.Samir_Login.Email;
import static com.softians.poller.activitys.Samir_Login.mypreference;


public class SplashScreenActivity extends AppCompatActivity {
    public static SharedPreferences sharedpreferences;

    //public static SharedPreferences sharedpreferences;
//
//    //*****************************SHARRED PREFERENCES TO STORE DATA****
//    public static final String mypreference = "mypref";
//    public static final String Password = "nameKey";
//    public static final String Email = "emailKey";
//    //****************************END HERE*************************


    public static int  splash=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);


        FirebaseMessaging.getInstance().subscribeToTopic("Test");
        FirebaseInstanceId.getInstance().getToken();
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        FirebaseInstanceIDService.sharedpreferences1 = getSharedPreferences(FirebaseInstanceIDService.myToken, Context.MODE_PRIVATE);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();


        FirebaseInstanceIDService.sharedpreferences1 = this.getSharedPreferences(FirebaseInstanceIDService.myToken, Context.MODE_PRIVATE);

       Config.token=FirebaseInstanceIDService.sharedpreferences1.getString(FirebaseInstanceIDService.userToken, "");
        //Toast.makeText(this, tok2, Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                if(sharedpreferences.contains(Email))
                {

                    splash=1;
                    Intent ints = new Intent(SplashScreenActivity.this, ProfilePage.class);

                    ints.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(ints);
                    finish();


                }
                else {

                    setContentView(R.layout.activity_splash_screen);


                    Intent ints = new Intent(SplashScreenActivity.this, Samir_Login.class);
                    ints.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(ints);
                    finish();
                }



            }
        }, 3000);








    }
}
