package com.softians.poller.activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.softians.poller.R;
import com.softians.poller.app.Config;
import com.softians.poller.model.CommonFloatingThings;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Lenovo on 10/8/2017.
 */

public class Samir_Login extends AppCompatActivity{

     ProgressDialog myPd_ring;

    String tok2;


    public static String user;
    Context context;

    int a=0;
    public static SharedPreferences sharedpreferences;

    EditText login_email,login_password;
    TextView login_signup1,login_signup2,forgot_pasword;
    Button login_submit;

    int valid=0;
    String status;

    RequestQueue requestQueue;

    //*****************************SHARRED PREFERENCES TO STORE DATA****
    public static final String mypreference = "mypref";
    public static final String Password = "nameKey";
    public static final String Email = "emailKey";
    public static final String lastmodule = "lastmodule";
    public static final String totalmodule = "totalmodule";
    //****************************END HERE*************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.samir_login);

        sharedpreferences = getApplication().getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        user=sharedpreferences.getString(Email, "");
        Config.email=sharedpreferences.getString(Email, "");

//        FirebaseMessaging.getInstance().subscribeToTopic("Test");
//        FirebaseInstanceId.getInstance().getToken();
//        MyFirebaseInstanceIDService.sharedpreferences1 = getSharedPreferences(MyFirebaseInstanceIDService.myToken, Context.MODE_PRIVATE);
//        tok2=MyFirebaseInstanceIDService.sharedpreferences1.getString(MyFirebaseInstanceIDService.userToken, "");
//
//
//        Toast.makeText(Samir_Login.this, tok2, Toast.LENGTH_SHORT).show();








        login_email= (EditText) findViewById(R.id.login_email);
        login_password= (EditText) findViewById(R.id.login_password);

        login_signup1= (TextView) findViewById(R.id.login_signup1);
        login_signup2= (TextView) findViewById(R.id.login_signup2);
        forgot_pasword= (TextView) findViewById(R.id.forgot_pasword);

        login_email.setText("");
        login_password.setText("");


        forgot_pasword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Samir_Login.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

        login_signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Samir_Login.this,UserRegistration.class);
                startActivity(intent);
            }
        });

        login_signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Samir_Login.this,UserRegistration.class);
                startActivity(intent);
            }
        });

        login_submit= (Button) findViewById(R.id.login_submit);


        login_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int b=0;
                if(sharedpreferences.contains(totalmodule))
                {

//                    a = Integer.parseInt(sharedpreferences.getString(Email, ""));
//                    a++;
                    // getImage();

                }
                else
                {
                    //String e = login_email.getText().toString();
                    // String n = login_password.getText().toString();
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(totalmodule, String.valueOf(b));
                }


                valid=0;
                validation();
                if(valid>0)
                {
                    Toast.makeText(Samir_Login.this, "Please check the fields", Toast.LENGTH_SHORT).show();
                }
                else {



                     myPd_ring= ProgressDialog.show(Samir_Login.this, "", "Please wait....", true);

//                    myPd_ring.setCancelable(true);
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            try
//                            {
//                                Thread.sleep(10000);
//                            }catch(Exception e){
//
//                            }
//
//                        }
//                    }).start();

                    //Toast.makeText(Samir_Login.this, "Please wait.....", Toast.LENGTH_SHORT).show();
                    StringRequest request = new StringRequest(Request.Method.POST, CommonFloatingThings.login, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {





                            // Variables.CheckSecondNavigation=1;
                            status=response;



                            // Toast.makeText(getContext(),  String.valueOf(sharedpreferences.getString(FirebaseInstanceIDService.userToken, "")), Toast.LENGTH_SHORT).show();


                            if(response.trim().equals("Login Successful"))
                            {
                                updatetoken();

                                myPd_ring.dismiss();

                                Toast.makeText(Samir_Login.this, "Please Wait...", Toast.LENGTH_LONG).show();
//
//                                Intent intent=new Intent(Samir_Login.this,ProfilePage.class);
//                                startActivity(intent);


//                                Config.email=login_email.getText().toString();
//                                String e = login_email.getText().toString();
//                                String n = login_password.getText().toString();
//                                SharedPreferences.Editor editor = sharedpreferences.edit();
//                                editor.putString(Password, n);
//                                editor.putString(Email, e);
//
//
//                                editor.commit();
//
//
//
//                                myPd_ring.dismiss();

//                                Intent intent=new Intent(Samir_Login.this,ProfilePage.class);
//                                startActivity(intent);

                            }
                            else
                            {
                                myPd_ring.dismiss();

                                Toast.makeText(Samir_Login.this, response, Toast.LENGTH_SHORT).show();
                            }






                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                            if (error instanceof NetworkError) {
                                Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(Samir_Login.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(Samir_Login.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                            } else if (error instanceof NoConnectionError) {
                                Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof TimeoutError) {
                                Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            }
                            // counter++;
                        }

                        {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> parameters = new HashMap<String, String>();




                            parameters.put("user_name", login_email.getText().toString());

                            parameters.put("user_password", login_password.getText().toString());


                            return parameters;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(request);

                }

            }
        });




    }

    public void validation()
    {
        if(login_email.getText().toString().trim().equals(""))
        {
            login_email.setError("please enter email");
            valid++;
        }

        if(login_password.getText().toString().trim().equals(""))
        {
            login_password.setError("please enter password");
            valid++;
        }


    }


    public void volley()
    {

        //********************************Network Library ends here******************************
    }


    public void onBackPressed() {

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }

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
                Config.navi = 0;
                //ExitActivity.exitApplication(context);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);


            }
        });
        AlertDialog alert = ad1.create();
        alert.show();
    }



    public void updatetoken()
    {
        StringRequest request = new StringRequest(Request.Method.POST,CommonFloatingThings.token, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                myPd_ring.dismiss();

                Toast.makeText(Samir_Login.this, status, Toast.LENGTH_SHORT).show();
                Config.email=login_email.getText().toString();
                String e = login_email.getText().toString();
                String n = login_password.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Password, n);
                editor.putString(Email, e);


                editor.commit();




                

                Intent intent=new Intent(Samir_Login.this,ProfilePage.class);
                startActivity(intent);



//                myPd_ring.dismiss();
//
//                Intent intent=new Intent(Samir_Login.this,ProfilePage.class);
//                startActivity(intent);


                //Variables.islogin=2;

//                MainActivity.loginregester2.setVisibility(View.INVISIBLE);
//                MainActivity.loginlogin2.setVisibility(View.INVISIBLE);


             //   getImage();

               // MainActivity.welcome1.setText(loginEmail.getText().toString());

//                String e = loginEmail.getText().toString();
//                String n = loginPassword.getText().toString();
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putString(Password, n);
//                editor.putString(Email, e);
//                editor.commit();





              //  Variables.CheckSecondNavigation=0;//to make only to execute only when registration is done


//                Variables.client_email=loginEmail.getText().toString();
//                Variables.client_email2=loginEmail.getText().toString();
//                Toast.makeText(getContext(),"Login Successful", Toast.LENGTH_LONG).show();




//                AllJobs display= new AllJobs();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frame, display);
//                fragmentTransaction.commit();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                if (error instanceof NetworkError) {
                    Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(Samir_Login.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(Samir_Login.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(Samir_Login.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                }
                // counter++;
            }

            {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                //String tok2=FirebaseInstanceIDService.sharedpreferences1.getString(FirebaseInstanceIDService.userToken, "");
                parameters.put("token",Config.token );
                parameters.put("email",login_email.getText().toString());
                return parameters;
            }
        };
        RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(Samir_Login.this);
        requestQueue.add(request);
    }

    }



