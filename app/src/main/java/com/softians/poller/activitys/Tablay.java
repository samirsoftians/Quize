package com.softians.poller.activitys;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.softians.poller.R;
import com.softians.poller.adapter.ViewPagerAdapter;
import com.softians.poller.app.Config;
import com.softians.poller.fragments.fragment_question;
import com.softians.poller.fragments.fragment_user_stats;
import com.softians.poller.fragments.fragment_winners;


public class Tablay extends AppCompatActivity {
    private static final String TAG = Tablay.class.getSimpleName();
    Toolbar toolbar;
    TabLayout tablayout;
    ViewPager viewPager;
    public static int defaultPos = 0;
    private BroadcastReceiver mRegistrationBroadcastReceiver ;
    ViewPagerAdapter viewPagerAdapter;

    public  static ProgressDialog myPd_ring2;

   public static int increment=0,check=0;

    //CollapsingToolbarLayout collapingsToollbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablay);
        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Config.email=(mSharedPreference.getString("Email", "Default_Value"));
      // Config.email= sharedpreferences.getString(Email, "");
         bindview();
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(Config.REGISTRATION_COMPLETE))
                {
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    //displayFirebaseRegId();
                }
                else if(intent.getAction().equals(Config.PUSH_NOTIFICATION))
                {
                    String message = intent.getStringExtra("message");
                    Toast.makeText(getApplicationContext(),"Push_Notification "+message,Toast.LENGTH_LONG).show();
                }
            }
        };
        int page = getIntent().getIntExtra("position",defaultPos);
        viewPager.setCurrentItem(page);

        //displayFirebaseRegId();







    }
    private void displayFirebaseRegId()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF,0);
        String regId = pref.getString("regId",null);
        Log.e(TAG, "Firebase reg id: " + regId);
        //Log.d("***", regId);
        if (!TextUtils.isEmpty(regId))
            Toast.makeText(getApplicationContext(),"Firebase Reg Id: " + regId,Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Firebase Reg Id is not received yet!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        //NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }


    private void bindview() {

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Give Answers and win");
        setSupportActionBar(toolbar);
        tablayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new fragment_question(),"Questions");
        viewPagerAdapter.addFragment(new fragment_winners(),"Winners");
        viewPagerAdapter.addFragment(new fragment_user_stats(),"Stats");
        viewPager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewPager);
        //collapingsToollbar=(CollapsingToolbarLayout)findViewById(R.id.collapings);

        //collapingsToollbar.setTitle("Softians Technology");

//*********************************************************************************************
      /*  tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                String g= String.valueOf(position);

                if(position==1 && increment<=0)
                {
                    check++;
                    myPd_ring2 = ProgressDialog.show(Tablay.this, "", "Please wait......", true);
                    myPd_ring2.setCancelable(true);

                    increment++;

                }

//                Toast.makeText(Tablay.this, g, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

//***********************************************************************

//        tablayout.setOnTabSelectedListener(new tablayout.OnTabSelectedListener(){
//            @Override
//            public void onTabSelected(TabLayout.Tab tab){
//                int position = tab.getPosition();
//            }
//        });



       /* viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int pos) {




                if(increment<=0) {


                    myPd_ring2 = ProgressDialog.show(Tablay.this, "", "Please wait......", true);

                }
                //This is because progress is 0 at the start of the program
//                progress++;
//                ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
//                progress.setProgress(position++);
            }

        });*/


    }
    @Override
    public void onBackPressed() {


//        myPd_ring2.dismiss();

        //super.onBackPressed();
        Log.d("back button", "back button pressed");
        AlertDialog.Builder ad1 = new AlertDialog.Builder(this);
        ad1.setMessage("Are you sure you want to exit ?");
        ad1.setCancelable(false);


        ad1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        ad1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Tablay.increment=0;
                Tablay.check=0;//check=0;

                Intent intent=new Intent(Tablay.this,ProfilePage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();


            }
        });
        AlertDialog alert = ad1.create();
        alert.show();

    }

}
