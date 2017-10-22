package com.softians.poller.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.softians.poller.R;

import java.util.HashMap;
import java.util.Map;

import static com.softians.poller.model.CommonFloatingThings.forgot;

/**
 * Created by Lenovo on 10/8/2017.
 */

public class ForgotPassword  extends Activity {

    EditText forgot_email;
    Button forgot_submit;
    RequestQueue requestQueue7;
    //String insertUrl7 =Config.DATA_FORGOT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        forgot_email = (EditText) findViewById(R.id.forgot_email);
        forgot_submit = (Button) findViewById(R.id.forgot_submit);
        requestQueue7 = Volley.newRequestQueue(getApplicationContext());
        forgot_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //////========================================================================================================

                StringRequest request1 = new StringRequest(Request.Method.POST, forgot, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        System.out.println(response.toString());

                        Toast.makeText(ForgotPassword.this, response, Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("email", forgot_email.getText().toString());

                        return parameters;
                    }
                };
                requestQueue7.add(request1);
                //=============================================================================================================
                Intent i = new Intent(ForgotPassword.this, Samir_Login.class);
                startActivity(i);
                finish();
            }
        });

    }
}