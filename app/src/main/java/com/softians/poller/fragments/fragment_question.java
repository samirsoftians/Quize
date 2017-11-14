package com.softians.poller.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.softians.poller.R;
import com.softians.poller.activitys.ParseJSON_Module;
import com.softians.poller.adapter.CustomAdapterTopics;
import com.softians.poller.model.CommonFloatingThings;
import com.softians.poller.model.TopicList;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.softians.poller.activitys.Samir_Login.Email;
import static com.softians.poller.activitys.Samir_Login.mypreference;


public class fragment_question extends Fragment implements View.OnClickListener {
     ProgressDialog myPd_ring;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CustomAdapterTopics customAdapter;
    List<TopicList> topicLists;
    RequestQueue requestQueue3;
    public static SharedPreferences sharedpreferences;

  int ID=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_question_topics,
                container, false);

        sharedpreferences = getContext().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        myPd_ring= ProgressDialog.show(getContext(), "", "Please wait......", true);
        myPd_ring.setCancelable(true);


        requestQueue3 = com.android.volley.toolbox.Volley.newRequestQueue(getContext());


        //myPd_ring2.dismiss();

//        myPd_ring.setCancelable(true);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                try
//                {
//                    Thread.sleep(10000);
//                }catch(Exception e){
//
//                }
//
//            }
//        }).start();



        recyclerView = (RecyclerView)view.findViewById(R.id.topics_recycler_view);
        recyclerView.setHasFixedSize(true);
        topicLists = new ArrayList<>();
    //    load_topic_from_server(0);
        load();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        customAdapter = new CustomAdapterTopics(this.getContext(),topicLists);
        recyclerView.setAdapter(customAdapter);

      //  myPd_ring.dismiss();

        /*recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(linearLayoutManager.findLastCompletelyVisibleItemPosition()==topicLists.size()-1);
            }
        });*/
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(linearLayoutManager.findLastCompletelyVisibleItemPosition()==topicLists.size()-1)
                {
//                    load_topic_from_server(topicLists.get(topicLists.size()-1).getId());

                   // load(topicLists.get(topicLists.size()-1).getId());


                  //  ID=topicLists.get(topicLists.size()-1).getId();
                    //load();

                }
            }
        });
        return view;
    }

    private void load_topic_from_server(final int id) {
        AsyncTask<Integer,Void,Void> task= new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... params) {
                OkHttpClient client = new OkHttpClient();
                //Request request =new Request.Builder().url(String.format("%s%s%d", CommonFloatingThings.links,"json_provider_for_recycler.php?id=",id)).build();
                Request request =new Request.Builder().url(CommonFloatingThings.json_provider_for_recycler+id).build();
                try {
                    myPd_ring.dismiss();

                    Response response = client.newCall(request).execute();
                    JSONArray jArray = new JSONArray(response.body().string());



//                    for(int i=0;i<jArray.length();i++)
//                    {
//
//                        JSONObject jsonObject = jArray.getJSONObject(i);
//                        com.softians.poller.app.Config.startTime=jsonObject.getString("start_tr");
//                        com.softians.poller.app.Config.endTime=jsonObject.getString("end_tr");
//                        String longtostr = String.valueOf(jsonObject.getLong("end_tr"));
//                        TopicList topic = new TopicList(jsonObject.getInt("id"),longtostr,jsonObject.getString("topics"));
//                        topicLists.add(topic);
//
//                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException je)
                {
                    System.out.print("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                customAdapter.notifyDataSetChanged();
            }
        };
        task.execute(id);
    }


    @Override
    public void onClick(View v) {

    }




    public void load()

    {

        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, CommonFloatingThings.json_provider_for_recycler, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                myPd_ring.dismiss();

                //Toast.makeText(ShowQuestion.this, "Answer Submitted", Toast.LENGTH_LONG).show();
                //Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();

              // Toast.makeText(getContext(), "Please wait....", Toast.LENGTH_LONG).show();

                showJSON(response);





            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                if (error instanceof NetworkError) {
                    Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(getContext(), "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(getContext(), "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
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
                parameters.put("id", String.valueOf(ID));
                parameters.put("email", sharedpreferences.getString(Email,""));

                //   parameters.put("average", average);


                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);

    }




    private void showJSON(String json){
        ParseJSON_Module pj = new ParseJSON_Module(json);
        pj.parseJSON();



        for(int i=0;i<ParseJSON_Module.length;i++)
        {

            TopicList topic = new TopicList(ParseJSON_Module.ids[i],ParseJSON_Module.end_tr[i],ParseJSON_Module.topics[i]);
            topicLists.add(topic);
            customAdapter.notifyDataSetChanged();

        }







//        CustomList c1 = new CustomList(getActivity(), ParseJSON.ids, ParseJSON.locations, ParseJSON.qualifications,ParseJSON.experiences,ParseJSON.subjects,ParseJSON.useremail);
//        listView.setAdapter(c1);







    }


}
