package com.softians.poller.activitys;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.softians.poller.R;

import java.util.ArrayList;
import java.util.List;

import static com.github.mikephil.charting.charts.Chart.LOG_TAG;

/**
 * Created by Lenovo on 11/14/2017.
 */

public class CustomAdapterTopics2 extends RecyclerView.Adapter<CustomAdapterTopics2.ViewHolder2> {


    private Context pContext;
    private List<ImageList> topicLists;
    private final List<ViewHolder2> viewHolderlist2;
    private Handler pHandler = new Handler();

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
        holder.setData(topicLists.get(position));
    }

    @Override
    public int getItemCount() {
        return topicLists.size();
    }












    public class ViewHolder2 extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView winnerName;
        ImageView profilePic;
        ImageList mTopicList;
        CardView winners_cardview;

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




}
