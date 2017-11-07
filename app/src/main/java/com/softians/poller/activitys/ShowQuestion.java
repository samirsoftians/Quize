package com.softians.poller.activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
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
import com.softians.poller.model.CommonFloatingThings;

import java.util.HashMap;
import java.util.Map;

import static com.softians.poller.activitys.Samir_Login.Email;
import static com.softians.poller.activitys.Samir_Login.mypreference;
import static com.softians.poller.app.Config.module;

/**
 * Created by Lenovo on 10/7/2017.
 */

public class ShowQuestion extends AppCompatActivity{


    CardView cv_ingredient1;
    CardView cv_ingredient2;
    CardView cv_ingredient3;
    CardView cv_ingredient4;
    CardView cv_ingredient5;
    int a;

    int stats=0;
    int check=0;

    TextView question1,question2,question3,question4,question5;

    EditText answer1,answer2,answer3,answer4,answer5;

    Button submit_answers;
    RequestQueue requestQueue;
     ProgressDialog myPd_ring;
    public static SharedPreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_question);

       // QuestionListAdapter.questionAnswerPair.put("submission_time",String.valueOf(System.currentTimeMillis()));
     //   Toast.makeText(this, String.valueOf(System.currentTimeMillis()), Toast.LENGTH_SHORT).show();
        // bindViews();
         myPd_ring= ProgressDialog.show(ShowQuestion.this, "", "Please wait......", true);

        requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(ShowQuestion.this);

        sharedpreferences = getApplication().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        question1 = (TextView) findViewById(R.id.question1);
        question2 = (TextView) findViewById(R.id.question2);
        question3 = (TextView) findViewById(R.id.question3);
        question4 = (TextView) findViewById(R.id.question4);
        question5 = (TextView) findViewById(R.id.question5);

         cv_ingredient1 = (CardView) findViewById(R.id.question_card1);
         cv_ingredient2 = (CardView) findViewById(R.id.question_card2);
         cv_ingredient3 = (CardView) findViewById(R.id.question_card3);
         cv_ingredient4 = (CardView) findViewById(R.id.question_card4);
         cv_ingredient5 = (CardView) findViewById(R.id.question_card5);


        answer1 = (EditText) findViewById(R.id.answer1);
        answer2 = (EditText) findViewById(R.id.answer2);
        answer3 = (EditText) findViewById(R.id.answer3);
        answer4 = (EditText) findViewById(R.id.answer4);
        answer5 = (EditText) findViewById(R.id.answer5);


        submit_answers= (Button) findViewById(R.id.submit_answers);




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



        submit_answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myPd_ring= ProgressDialog.show(ShowQuestion.this, "", "Please wait......", true);

                //Toast.makeText(ShowQuestion.this, "Please wait......", Toast.LENGTH_LONG).show();

                stats=0;
//                myPd_ring.setCancelable(true);
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        try
//                        {
//                            Thread.sleep(10000);
//                        }catch(Exception e){
//
//                        }
//
//                    }
//                }).start();














//                Toast.makeText(ShowQuestion.this, ParseJSON.answers[0]+"-------"+answer1.getText().toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(ShowQuestion.this, ParseJSON.answers[1]+"-------"+answer2.getText().toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(ShowQuestion.this, ParseJSON.answers[2]+"-------"+answer3.getText().toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(ShowQuestion.this, ParseJSON.answers[3]+"-------"+answer4.getText().toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(ShowQuestion.this, ParseJSON.answers[4]+"-------"+answer5.getText().toString(), Toast.LENGTH_SHORT).show();



                if(answer1.getText().toString().equalsIgnoreCase(ParseJSON.answers[0]))
                {

                    check++;
                   // Toast.makeText(ShowQuestion.this, ParseJSON.questions[0]+"-------"+answer1.getText().toString(), Toast.LENGTH_SHORT).show();
                    stats++;
                }

                else
                {
                    check++;

                }

                if(answer2.getText().toString().equalsIgnoreCase(ParseJSON.answers[1]))
                {

                  //  Toast.makeText(ShowQuestion.this, ParseJSON.questions[1]+"-------"+answer2.getText().toString(), Toast.LENGTH_SHORT).show();
                    check++;

                    stats++;
                }
                else
                {
                    check++;

                }

                if(answer3.getText().toString().equalsIgnoreCase(ParseJSON.answers[2]))
                {
                    check++;

                    //Toast.makeText(ShowQuestion.this, ParseJSON.questions[2]+"-------"+answer3.getText().toString(), Toast.LENGTH_SHORT).show();

                    stats++;
                }
                else
                {
                    check++;

                }

                if(answer4.getText().toString().equalsIgnoreCase(ParseJSON.answers[3]))
                {
                    check++;

//                    Toast.makeText(ShowQuestion.this, ParseJSON.questions[3]+"-------"+answer4.getText().toString(), Toast.LENGTH_SHORT).show();

                    stats++;
                }
                else
                {
                    check++;

                }
                if(answer5.getText().toString().equalsIgnoreCase(ParseJSON.answers[4]))
                {
                    check++;

//                    Toast.makeText(ShowQuestion.this, ParseJSON.questions[4]+"-------"+answer5.getText().toString(), Toast.LENGTH_SHORT).show();

                    stats++;
                }
                else
                {
                    check++;

                }
                String mm= String.valueOf(stats);
              //Toast.makeText(ShowQuestion.this, mm, Toast.LENGTH_SHORT).show();

              //  Toast.makeText(ShowQuestion.this,"Answer Submitted Successfully", Toast.LENGTH_LONG).show();



                //if(check>0) {

                    StringRequest request = new StringRequest(Request.Method.POST, CommonFloatingThings.answers, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            //Toast.makeText(ShowQuestion.this, "Answer Submitted", Toast.LENGTH_LONG).show();
                            myPd_ring.dismiss();

//                        a = Integer.parseInt(sharedpreferences.getString(Email, ""));
//                        a++;
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//                         editor.putString(totalmodule, String.valueOf(a));

//                        int b=1;
//                        if(sharedpreferences.contains(totalmodule))
//                        {
//
//                             a = Integer.parseInt(sharedpreferences.getString(Email, ""));
//                            a++;
//                            // getImage();
//
//                        }
//                        else
//                        {
//                            //String e = login_email.getText().toString();
//                           // String n = login_password.getText().toString();
//                            SharedPreferences.Editor editor = sharedpreferences.edit();
//                            editor.putString(totalmodule, String.valueOf(b));
//                        }

//                        int ll= Integer.parseInt(sharedpreferences.getString(Email, ""));
//
//                        ll++;

                            //String l= String.valueOf(sendTopicId);
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//                        editor.putString(totalmodule, String.valueOf(ll));
//
//                        editor.commit();

                            Toast.makeText(ShowQuestion.this, "Answer submitted successfully", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(ShowQuestion.this,Tablay.class);
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
                                Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(ShowQuestion.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(ShowQuestion.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                            } else if (error instanceof NoConnectionError) {
                                Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            } else if (error instanceof TimeoutError) {
                                Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                            }
                            // counter++;
                        }

                        {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> parameters = new HashMap<String, String>();

//                               double starttime,endtime,answertime;
//                               double avg;
//                               starttime= Integer.parseInt(Config.startTime);
//                               endtime= Integer.parseInt(Config.endTime);//(int) System.currentTimeMillis();
//                            answertime=(endtime-starttime)/1000;
//                               avg=stats/answertime;
//                               String average= String.valueOf(avg);
                            parameters.put("answer1", answer1.getText().toString());
                            parameters.put("answer2", answer2.getText().toString());
                            parameters.put("answer3", answer3.getText().toString());
                            parameters.put("answer4", answer4.getText().toString());
                            parameters.put("answer5", answer5.getText().toString());
                            parameters.put("module", module);
                            parameters.put("email", sharedpreferences.getString(Email,""));//sharedpreferences.getString(Email, "")
                            parameters.put("score", String.valueOf(stats * 100 / 5));
                            parameters.put("submission_time", String.valueOf(System.currentTimeMillis()));
                         //   parameters.put("average", average);


                            return parameters;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
              //  }

//                Intent intent=new Intent(ShowQuestion.this,Tablay.class);
//                startActivity(intent);
//                finish();
            }
        });




//*****************************************************************************************************************

        //****************************************Volley to get data fill in the Edittext**********************//?id="+id+

        StringRequest stringRequest841 = new StringRequest(CommonFloatingThings.questions+ module, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //myPd_ring.dismiss();

                 //Toast.makeText(ShowQuestion.this,Config.module,Toast.LENGTH_LONG ).show();

                myPd_ring.dismiss();

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof NetworkError) {
                            //neterror(v);
                            Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(ShowQuestion.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            // neterror(v);
                            Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(ShowQuestion.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                        } else if (error instanceof NoConnectionError) {
                            //neterror(v);
                            Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof TimeoutError) {
                            //neterror(v);
                            Toast.makeText(ShowQuestion.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        }

                        //Toast.makeText(Update.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
//                        Config.refresh++;
//
//                        if(Config.refresh>2)
//                        {
//                            Refresh();
//                        }
//                        else
//                        {
//                            Intent intent = new Intent(Update2.this, Update2.class);
//                            Bundle bundle = new Bundle();
//                            bundle.putString("cemail1", myString2);
//                            intent.putExtras(bundle);
//                            startActivity(intent);
//                        }


                    }
                });

        RequestQueue requestQueue841 = Volley.newRequestQueue(ShowQuestion.this);
        requestQueue841.add(stringRequest841);
    }

        //************************************End of volley here*************************************************




        //***********************************************************************************************************

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();


        if(ParseJSON.questions[0].equals("") || ParseJSON.questions[0].equals("null") )
        {
            cv_ingredient1.setVisibility(View.GONE);
        }

        else
        {
            question1.setText(ParseJSON.questions[0] );
        }

        if(ParseJSON.questions[1].equals("") || ParseJSON.questions[1].equals("null"))
        {
            cv_ingredient2.setVisibility(View.GONE);
        }

        else
        {
            question2.setText(ParseJSON.questions[1] );

        }

        if(ParseJSON.questions[2].equals("") || ParseJSON.questions[2].equals("null"))
        {
            cv_ingredient3.setVisibility(View.GONE);
        }
        else
        {
            question3.setText(ParseJSON.questions[2]);

        }

        if(ParseJSON.questions[3].equals("") || ParseJSON.questions[3].equals("null"))
        {
            cv_ingredient4.setVisibility(View.GONE);
        }
        else
        {
            question4.setText(ParseJSON.questions[3]);

        }

        if(ParseJSON.questions[4].equals("") || ParseJSON.questions[4].equals("null"))
        {
            cv_ingredient5.setVisibility(View.GONE);
        }
        else
        {
            question5.setText(ParseJSON.questions[4]);

        }



//        question1.setText(ParseJSON.questions[0]);
//        question2.setText(ParseJSON.questions[1]);
//        question3.setText(ParseJSON.questions[2]);
//        question4.setText(ParseJSON.questions[3]);
//        question5.setText(ParseJSON.questions[4]);



//        // Toast.makeText(getContext(),ParseJSON.su, Toast.LENGTH_SHORT).show();
//        CustomList c1 = new CustomList(getActivity(), ParseJSON.ids, ParseJSON.locations, ParseJSON.qualifications,ParseJSON.experiences,ParseJSON.subjects,ParseJSON.useremail);
//        listView.setAdapter(c1);







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

                Intent intent=new Intent(ShowQuestion.this,Tablay.class);
                startActivity(intent);
                finish();


            }
        });
        AlertDialog alert = ad1.create();
        alert.show();

    }

}
