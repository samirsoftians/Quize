package com.softians.poller.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
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

import static com.softians.poller.activitys.Samir_Login.Email;
import static com.softians.poller.activitys.Samir_Login.mypreference;

public class fragment_user_stats extends Fragment {
    private com.github.lzyzsd.circleprogress.DonutProgress pDonutProgress;
    private View pFirstView;
    private TextView pLastScore;
    private TextView pValueForTotalTests;
    private View pSecondView;
    private TextView pTestsTaken;
    public static String nots;
    public static int percent = 65;
    ProgressDialog myPd_ring;

    int totalscore=55;

    public static SharedPreferences sharedpreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        myPd_ring= ProgressDialog.show(getContext(), "", "Please wait......", true);

        View view = inflater.inflate(R.layout.fragment_fragment_user_stats,
                container, false);
        {

            sharedpreferences = getContext().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
            Config.email=sharedpreferences.getString(Email, "");

           // Toast.makeText(getContext(), Config.email, Toast.LENGTH_SHORT).show();

            pDonutProgress = (com.github.lzyzsd.circleprogress.DonutProgress) view.findViewById(R.id.donutProgress);
        //pLastScore = (TextView) view.findViewById(R.id.LastScore);
        pValueForTotalTests = (TextView) view.findViewById(R.id.ValueForTotalTests);


        //****************************************Volley to get data fill in the Edittext**********************//?id="+id+
//String email=sharedpreferences.getString(Email, "");
        StringRequest stringRequest841 = new StringRequest(CommonFloatingThings.score+Config.email, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myPd_ring.dismiss();

              //  Toast.makeText(getContext(),response,Toast.LENGTH_LONG ).show();
                //    myPd_ring.dismiss();


                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof NetworkError) {
                            //neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(getContext(),"The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            // neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getContext(), "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                        } else if (error instanceof NoConnectionError) {
                            //neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof TimeoutError) {
                            //neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
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

        RequestQueue requestQueue841 = Volley.newRequestQueue(getContext());
        requestQueue841.add(stringRequest841);
    }


    //************************************End of volley here*************************************************






//999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
        //****************************************************************************************************

        //****************************************Volley to get data fill in the Edittext**********************//?id="+id+
//String email=sharedpreferences.getString(Email, "");
        StringRequest stringRequest841 = new StringRequest(CommonFloatingThings.marks+Config.email, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myPd_ring.dismiss();

            //    Toast.makeText(getContext(),response,Toast.LENGTH_LONG ).show();
                //    myPd_ring.dismiss();


                showJSON2(response);
            }
        },




                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof NetworkError) {
                            //neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(getContext(),"The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            // neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getContext(), "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                        } else if (error instanceof NoConnectionError) {
                            //neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof TimeoutError) {
                            //neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
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

        RequestQueue requestQueue841 = Volley.newRequestQueue(getContext());
        requestQueue841.add(stringRequest841);



    //************************************End of volley here*************************************************

        //************************************************************************************















    //pTestsTaken = (TextView) view.findViewById(R.id.TestsTaken);
//        try {
//            getContents(1);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //Log.d("***bf setting",String.valueOf(percent));
//        pDonutProgress.setProgress((totalscore));*************************************
       // pValueForTotalTests.setText(sharedpreferences.getString(lastmodule, ""));// pValueForTotalTests.setText(nots);
        return view;
    }


//    private void getContents(final int id) throws ExecutionException, InterruptedException {
//        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
//            @Override
//            protected Void doInBackground(Integer... params) {
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder().url("http://samirsoftians.000webhostapp.com/poller2/stats.php?id="+id).build();
//
//                try {
//                    Response response = client.newCall(request).execute();
//                    JSONArray jsonArray = new JSONArray(response.body().string());
//                    JSONObject jobs;
//                    jobs = jsonArray.getJSONObject(0);
//                    percent=jobs.getInt("percent");
//                    nots=jobs.getString("nots");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                catch (JSONException je)
//                {
//                    System.out.println("EOF");
//                }
//                return null;
//            }
//        };
//        task.execute().get();
//
//        //pTestsTaken.setText(nots);
//    }



    private void showJSON(String response) {

            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray result = jsonObject.getJSONArray("result");
                JSONObject collegeData = result.getJSONObject(0);
                String tests = collegeData.getString("tests");

                pValueForTotalTests.setText(tests);

            } catch (JSONException e) {
                e.printStackTrace();
            }


//===================================================================
        }


    private void showJSON2(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            JSONObject collegeData = result.getJSONObject(0);
            String tests = collegeData.getString("marks");

            totalscore= Integer.parseInt(tests);

            pDonutProgress.setProgress((totalscore));

        } catch (JSONException e) {
            e.printStackTrace();
        }


//===================================================================
    }


}


