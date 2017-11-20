package com.softians.poller.activitys;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.mikephil.charting.charts.Chart.LOG_TAG;

/**
 * Created by Lenovo on 11/14/2017.
 */

public class CustomAdapterTopics2 extends RecyclerView.Adapter<CustomAdapterTopics2.ViewHolder2> {


    private Context pContext;
    private List<ImageList> topicLists;
    private final List<ViewHolder2> viewHolderlist2;
    private Handler pHandler = new Handler();
    String feedback="null",feedDetails,demail,selectedModule;


    public CustomAdapterTopics2(Context pContext, List<ImageList> topicLists) {

        super();
        this.pContext=pContext;
        this.topicLists=topicLists;
        viewHolderlist2 = new ArrayList<>();
    }


    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.winner_cardview,parent,false);
      //  return new CustomAdapterTopics2.ViewHolder2(itemView);

        return new ViewHolder2(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder2 holder, int position) {
        holder.winnerName.setTag(position);


       holder.winnerEdit(topicLists.get(position));
        holder.setData(topicLists.get(position));
    }

    @Override
    public int getItemCount() {

        return topicLists.size();
    }












    public class ViewHolder2 extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView winnerName;//,winnerText;
        ImageView profilePic;
        ImageList mTopicList;
        CardView winners_cardview;
        Button winnerText;



        public void winnerEdit(ImageList t)
        {
            mTopicList=t;

            selectedModule=  mTopicList.getModules();


            if (mTopicList.getEmails().equals(Config.email) ) {
               // winnerText.setEnabled(true);
              //  winnerText.setVisibility(View.VISIBLE);
                winnerText.setText("write");
                winnerText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        LayoutInflater layoutInflater = LayoutInflater.from(pContext);
                        View rootView = layoutInflater.inflate(R.layout.dialogbox, null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(pContext);
                        alertDialogBuilder.setView(rootView);

                        final EditText yourEditText = (EditText) rootView.findViewById(R.id.etComments);

                        alertDialogBuilder.setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id)
                                    {
//***********************************************Volley Starts Here*****************************
                                        if(yourEditText.getText().toString().equals("") || yourEditText.getText().equals(null))
                                        {
                                            feedback="";
                                            feedback();
                                        }
                                        else
                                        {
                                            feedback = yourEditText.getText().toString().substring(0,1).toUpperCase() + yourEditText.getText().toString().substring(1).toLowerCase();
                                            feedback();
                                        }

                                    }
                                })
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                dialog.cancel();

                                            }
                                        });

                        AlertDialog alert = alertDialogBuilder.create();
                        alert.show();
                    }
                });


            } else {
                winnerText.setText("Details");
                winnerText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     //   Toast.makeText(pContext, "was clicked", Toast.LENGTH_SHORT).show();

                        //*********************Display Data*********************************

                        StringRequest request = new StringRequest(Request.Method.POST, CommonFloatingThings.feed2, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                             //   Toast.makeText(pContext, response, Toast.LENGTH_SHORT).show();

                                JSONObject j = null;
                                try
                                {

                                    JSONObject jsonObject = new JSONObject(response);
                                    JSONArray result = jsonObject.getJSONArray("result");
                                    JSONObject collegeData = result.getJSONObject(0);
                                    demail = collegeData.getString("feed");

                                    //Toast.makeText(pContext, demail, Toast.LENGTH_SHORT).show();



                                    LayoutInflater layoutInflater = LayoutInflater.from(pContext);
                                    View rootView = layoutInflater.inflate(R.layout.display_dialog, null);
                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(pContext);
                                    alertDialogBuilder.setView(rootView);
                                    final TextView yourEditText = (TextView) rootView.findViewById(R.id.dialog_details);
                                    yourEditText.setText(demail);



                                    alertDialogBuilder.setCancelable(false)
                                            .setPositiveButton("back", new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id)
                                                {
//***********************************************Volley Starts Here*****************************
                                                    dialog.cancel();
                                                    // feedback = yourEditText.getText().toString().substring(0,1).toUpperCase() + yourEditText.getText().toString().substring(1).toLowerCase();
                                                    //feedback();
                                                }
                                            });
//                                .setNegativeButton("Cancel",
//                                        new DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface dialog, int id) {
//
//                                                dialog.cancel();
//
//                                            }
//                                        });

                                    AlertDialog alert = alertDialogBuilder.create();
                                    alert.show();





                                     yourEditText.setText(demail);

                                } catch (JSONException e)
                                {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                                if (error instanceof NetworkError) {
                                    Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                                } else if (error instanceof ServerError) {
                                    Toast.makeText(pContext, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                                } else if (error instanceof AuthFailureError) {
                                    Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                } else if (error instanceof ParseError) {
                                    Toast.makeText(pContext, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                                } else if (error instanceof NoConnectionError) {
                                    Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                } else if (error instanceof TimeoutError) {
                                    Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                }
                                // counter++;
                            }

                            {

                            }
                        }) {

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> parameters = new HashMap<String, String>();



                                parameters.put("email", Config.email);




                                return parameters;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(pContext);
                        requestQueue.add(request);



                        //****************************Display Ends HERE***********************








                       // yourEditText.setText("I am samir i am happy that i won a car of my own choice");





















                       // displayWinner();
//                        feedback = dialog_details.getText().toString().substring(0,1).toUpperCase() + dialog_details.getText().toString().substring(1).toLowerCase();


                    }
                });
            }


        }






        public void setData(ImageList topl)
        {
            mTopicList=topl;
           // winnerName.setText(mTopicList.getpEndTimer());//getpTopicName()
           // updateTimeRemaining(System.currentTimeMillis());
            Bitmap bitmap2= BitmapFactory.decodeResource(pContext.getResources(),R.drawable.prifileimage);




            if (mTopicList.getpTopicName().equals("") || mTopicList.getpTopicName().equals("null")) {
                winnerName.setText(mTopicList.getpEndTimer() + " " + "has won");
                profilePic.setImageBitmap(bitmap2);
            } else {
                try {

                    byte[] encodeByte = Base64.decode(mTopicList.getpTopicName(), Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                    winnerName.setText(mTopicList.getpEndTimer() + " " + "has won");
                    profilePic.setImageBitmap(bitmap);

                    //myPd_ring.dismiss();

                } catch (Exception e) {
                    e.getMessage();
                    Log.e(LOG_TAG, "[ONACTIVITYRESULT] Could not bind input to the bytearray: " + e.getMessage());
                }
            }
        }




        public ViewHolder2(View itemView) {
            super(itemView);
            winnerName = (TextView)itemView.findViewById(R.id.winnersName);
            profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
            winners_cardview = (CardView)itemView.findViewById(R.id.winners_cardview);
            winnerText=(Button) itemView.findViewById(R.id.winnerText);
//            Typeface number = Typeface.createFromAsset(pContext.getAssets(), "fonts/number.ttf");
//            pTimer.setTypeface(number);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int sendTopicId = topicLists.get(getAdapterPosition()).getId();
//**************************Shared preference**********************************

            Toast.makeText(pContext, "Please wait retriving more data", Toast.LENGTH_LONG).show();
            String l= String.valueOf(sendTopicId);

//            SharedPreferences.Editor editor = sharedpreferences.edit();
//
//            editor.putString(lastmodule, l);
//
//            editor.commit();


//            //*********************Shared Preference ends here*********************
//            Intent toQuestion = new Intent(pContext, ShowQuestion.class);//ShowQuestionList.class
//            //  toQuestion.putExtra("topicId",sendTopicId);
//
//            Config.module= String.valueOf(sendTopicId);
//            pContext.startActivity(toQuestion);
        }
    }

public void feedback()
{
    StringRequest request = new StringRequest(Request.Method.POST, CommonFloatingThings.feed, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            Toast.makeText(pContext, "Thanks for you feedback", Toast.LENGTH_SHORT).show();

          //  myPd_ring.dismiss();

          //  Toast.makeText(UserRegistration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//
//            Intent intent=new Intent(UserRegistration.this,Samir_Login.class);
//            startActivity(intent);
//            finish();

            // Variables.CheckSecondNavigation=1;


            // Toast.makeText(getContext(),  String.valueOf(sharedpreferences.getString(FirebaseInstanceIDService.userToken, "")), Toast.LENGTH_SHORT).show();




        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
            if (error instanceof NetworkError) {
                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
            } else if (error instanceof ServerError) {
                Toast.makeText(pContext, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
            } else if (error instanceof AuthFailureError) {
                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
            } else if (error instanceof ParseError) {
                Toast.makeText(pContext, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

            } else if (error instanceof NoConnectionError) {
                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
            } else if (error instanceof TimeoutError) {
                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
            }
            // counter++;
        }

        {

        }
    }) {

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> parameters = new HashMap<String, String>();



            parameters.put("email", Config.email);

            parameters.put("module", selectedModule);

            if(feedback.equals("null") || feedback.equals(""))
            {
                parameters.put("feed", "No Info");
            }
            else
            {
                parameters.put("feed", feedback);
            }




            return parameters;
        }
    };
    RequestQueue requestQueue = Volley.newRequestQueue(pContext);
    requestQueue.add(request);
}


//public void displayWinner()
//{
//
//
//    StringRequest request = new StringRequest(Request.Method.POST, CommonFloatingThings.feed2, new Response.Listener<String>() {
//        @Override
//        public void onResponse(String response) {
//
//            JSONObject j = null;
//            try
//            {
//                JSONObject jsonObject = new JSONObject(response);
//                JSONArray result = jsonObject.getJSONArray("result");
//                JSONObject collegeData = result.getJSONObject(0);
//                demail = collegeData.getString("feed");
//
//            } catch (JSONException e)
//            {
//                e.printStackTrace();
//            }
//
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
////                                myPd_ring.dismiss();
//            if (error instanceof NetworkError) {
//                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
//            } else if (error instanceof ServerError) {
//                Toast.makeText(pContext, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
//            } else if (error instanceof AuthFailureError) {
//                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
//            } else if (error instanceof ParseError) {
//                Toast.makeText(pContext, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();
//
//            } else if (error instanceof NoConnectionError) {
//                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
//            } else if (error instanceof TimeoutError) {
//                Toast.makeText(pContext, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
//            }
//            // counter++;
//        }
//
//        {
//
//        }
//    }) {
//
//        @Override
//        protected Map<String, String> getParams() throws AuthFailureError {
//            Map<String, String> parameters = new HashMap<String, String>();
//
//
//
//            parameters.put("email", Config.email);
//
//
//
//
//            return parameters;
//        }
//    };
//    RequestQueue requestQueue = Volley.newRequestQueue(pContext);
//    requestQueue.add(request);
//}


}
