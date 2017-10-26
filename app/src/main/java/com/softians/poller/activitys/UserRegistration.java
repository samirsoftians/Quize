package com.softians.poller.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.softians.poller.model.CommonFloatingThings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * Created by Lenovo on 10/7/2017.
 */

public class UserRegistration extends AppCompatActivity {

    //Samir Mishra

    int valid=0;

    EditText user_name,user_email,user_mobile,user_address,user_password,confirm_password;
    Button user_submit;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samir_registration);

        user_name= (EditText) findViewById(R.id.user_name);
        user_email= (EditText)findViewById(R.id.user_email);
        user_mobile= (EditText)findViewById(R.id.user_mobile);
        user_address= (EditText)findViewById(R.id.user_address);
        user_password= (EditText)findViewById(R.id.user_password);

        confirm_password= (EditText)findViewById(R.id.confirm_password);

        user_submit= (Button) findViewById(R.id.user_submit);





        user_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid=0;
                validation();

                if (valid>0)
                {
                    Toast.makeText(UserRegistration.this, "Please Fill all the fields", Toast.LENGTH_LONG).show();
                }
                else {

                    final ProgressDialog myPd_ring= ProgressDialog.show(UserRegistration.this, "", "Please wait......", true);

                    myPd_ring.setCancelable(true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try
                            {
                                Thread.sleep(10000);
                            }catch(Exception e){

                            }

                        }
                    }).start();

                    StringRequest request = new StringRequest(Request.Method.POST, CommonFloatingThings.registration, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(UserRegistration.this, response, Toast.LENGTH_SHORT).show();



                            myPd_ring.dismiss();

                            Toast.makeText(UserRegistration.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(UserRegistration.this,Samir_Login.class);
                             startActivity(intent);
                            finish();

                            // Variables.CheckSecondNavigation=1;


                            // Toast.makeText(getContext(),  String.valueOf(sharedpreferences.getString(FirebaseInstanceIDService.userToken, "")), Toast.LENGTH_SHORT).show();




                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                            if (error instanceof NetworkError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(UserRegistration.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(UserRegistration.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                            } else if (error instanceof NoConnectionError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof TimeoutError) {
                                Toast.makeText(UserRegistration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            }
                            // counter++;
                        }

                        {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> parameters = new HashMap<String, String>();



                            parameters.put("name", user_name.getText().toString());
                            parameters.put("user_name", user_email.getText().toString());
                            parameters.put("user_phone", user_mobile.getText().toString());
                            parameters.put("user_address", user_address.getText().toString());
                            parameters.put("user_password", user_password.getText().toString());


                            return parameters;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
                }

            }
        });



    }

    //***************************************Validation starts here*****************************************
    public void validation()
    {
        if(user_name.getText().toString().trim().equals(""))
        {
            user_name.setError("please enter name");
            valid++;
        }

        if(user_email.getText().toString().trim().equals(""))
        {
            user_email.setError("please enter name");
            valid++;
        }

        if (user_mobile.getText().toString().length() < 10 || user_mobile.getText().toString().length() >= 12) {

            user_mobile.setError("Please enter valid phone number");
            // Toast.makeText(SignUpActivity.this,"Please enter valid phone number",Toast.LENGTH_SHORT).show();
            valid++;
        }

        if(user_address.getText().toString().trim().equals(""))
        {
            user_address.setError("please enter name");
            valid++;
        }

        if (!checkEmail(user_email.getText().toString())) {
            user_email.setError("Invalid Email");

            // Toast.makeText(SignUpActivity.this, "Paswword lenght should be greater than 6 char", Toast.LENGTH_SHORT).show();
            valid++;

        }


        if(user_password.getText().toString().trim().equals(""))
        {
            user_password.setError("please enter your password");
            valid++;
        }

        if (!isValidPassword(user_password.getText().toString())) {
            user_password.setError("Password length should be greater than 4 character");

            // Toast.makeText(SignUpActivity.this, "Paswword lenght should be greater than 6 char", Toast.LENGTH_SHORT).show();
            valid++;

        }

        if(!confirm_password.getText().toString().equals(user_password.getText().toString()))
        {

            confirm_password.setError("Password did not matched");
            valid++;
        }



    }

    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );

    private boolean isValidPassword(String pass)
    {
        if (pass != null && pass.length() > 4) {
            return true;
        }
        return false;

    }

    //**************************************************************Validation Ends Here********************************

    //*********************Using Network Library to insert in the database*********************

    public void  register(){


        //********************************Network Library ends here******************************

    }
}
