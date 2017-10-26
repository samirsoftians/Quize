package com.softians.poller.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
import com.softians.poller.activitys.CustomList;
import com.softians.poller.activitys.ParseWinner;

import static com.softians.poller.model.CommonFloatingThings.winners;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_winners extends Fragment {

    RequestQueue requestQueue;

    ListView listView;
    ProgressDialog myPd_ring;



//    RecyclerView winnersRecyclerView;
//    LinearLayoutManager linearLayoutManager;
//    WinnerAdapter winnersAdapter;
//    List<WinnerDataModel> winnersList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.display,
                container, false);

        listView= (ListView) view.findViewById(R.id.listView);

        requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(getContext());
        myPd_ring= ProgressDialog.show(getContext(), "", "Please wait......", true);









        //*************Volley starts*************


        StringRequest stringRequest8415 = new StringRequest(winners, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myPd_ring.dismiss();

               //Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
//                Toast.makeText(getContext(), Variables.client_email, Toast.LENGTH_LONG).show();

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

                            Toast.makeText(getContext(), "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            //neterror(v);
                             Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getContext(), "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                        } else if (error instanceof NoConnectionError) {
                           // neterror(v);
                            Toast.makeText(getContext(), "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                        } else if (error instanceof TimeoutError) {
                           // neterror(v);
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

        RequestQueue requestQueue8415 = Volley.newRequestQueue(getContext());
        requestQueue8415.add(stringRequest8415);
//


        //****************Volley ends****************





























        // Inflate the layout for this fragment

//        View view = inflater.inflate(R.layout.fragment_fragment_winners,
//                container, false);

//
//        winnersRecyclerView = (RecyclerView)view.findViewById(R.id.winners_recycler_winner);
//        winnersRecyclerView.setHasFixedSize(true);
//        winnersList = new ArrayList<>();
//        load_winners_from_server(0);
//        linearLayoutManager = new LinearLayoutManager(getActivity());
//        winnersRecyclerView.setLayoutManager(linearLayoutManager);
//        winnersAdapter = new WinnerAdapter(this.getContext(),winnersList);
//        winnersRecyclerView.setAdapter(winnersAdapter);
//        /*recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                if(linearLayoutManager.findLastCompletelyVisibleItemPosition()==topicLists.size()-1);
//            }
//        });*/
//        winnersRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
//        {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                if(linearLayoutManager.findLastCompletelyVisibleItemPosition()==winnersList.size()-1)
//                {
//                    load_winners_from_server(winnersList.get(winnersList.size()-1).getId());
//                }
//            }
//        });
      return view;
   }
//
//    private void load_winners_from_server(final int id) {
//        AsyncTask<Integer,Void,Void> winnertask= new AsyncTask<Integer, Void, Void>() {
//            @Override
//            protected Void doInBackground(Integer... params) {
//                OkHttpClient client = new OkHttpClient();
//                //Request request =new Request.Builder().url(String.format("%s%s%d", CommonFloatingThings.links,"json_provider_for_recycler.php?id=",id)).build();
//                Request request =new Request.Builder().url(CommonFloatingThings.winners_feed+id).build();
//                try {
//                    Response response = client.newCall(request).execute();
//                    JSONArray jArray = new JSONArray(response.body().string());
//                    for(int i=0;i<jArray.length();i++)
//                    {
//
//                        JSONObject jsonObject = jArray.getJSONObject(i);
//                        String longtostrDate = String.valueOf(jsonObject.getLong("pdate"));
//                        WinnerDataModel winner = new WinnerDataModel(jsonObject.getInt("id"),jsonObject.getString("names"),jsonObject.getString("picture"),longtostrDate);
//                        winnersList.add(winner);
//
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                catch (JSONException je)
//                {
//                    System.out.print("End of content");
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                winnersAdapter.notifyDataSetChanged();
//            }
//        };
//        winnertask.execute(id);
    //**********************************************************************************************************

    private void showJSON(String json){
        ParseWinner pj = new ParseWinner(json);
        pj.parseJSON();

        // Toast.makeText(getContext(),ParseJSON.su, Toast.LENGTH_SHORT).show();
       CustomList c1 = new CustomList(getActivity(), ParseWinner.ids, ParseWinner.names,ParseWinner.images );
       listView.setAdapter(c1);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
////                if(Variables.client_email.isEmpty()) {
//                    Login applyedJob = new Login();
//                    FragmentTransaction fragmentTransaction =getActivity().getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.frame, applyedJob);
//                    fragmentTransaction.commit();
//               // }
//
//
////I ADDED ON CLICK IMPLEMENTATION HERE, BUT THIS IS NOT WORKING
//                //Toast.makeText(getApplicationContext(), "CLICKED", Toast.LENGTH_SHORT).show();
//            }
//        });




    }


}
