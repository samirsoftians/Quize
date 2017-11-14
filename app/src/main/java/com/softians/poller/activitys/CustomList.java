package com.softians.poller.activitys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.softians.poller.R;

import static com.github.mikephil.charting.charts.Chart.LOG_TAG;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class CustomList extends ArrayAdapter<String> {
    Animation shake,bounce;
    ProgressDialog myPd_ring;
    String mm;
    private String[] ids;
    private String[] names;
    private String[] images;

    private Activity context;

    ImageView butapply;

    RequestQueue requestQueue;

    public FragmentActivity myContext;

    public Fragment fragment;



    Bitmap bitmap1;
    Bitmap bitmap2;










    public CustomList(Activity context, String[] ids, String[] names, String[] images) {
        super(context, R.layout.winner_cardview, ids);
       // myPd_ring= ProgressDialog.show(getContext(), "", "Please wait......", true);

       // Toast.makeText(context, "Please wait...", Toast.LENGTH_SHORT).show();
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.images = images;

        // this.image = designations;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.winner_cardview, null, true);
        TextView textId = (TextView) listViewItem.findViewById(R.id.winnersName);
        ImageView profilePic=(ImageView) listViewItem.findViewById(R.id.profilePic);
        Bitmap bitmap2= BitmapFactory.decodeResource(getContext().getResources(),R.drawable.prifileimage);





    if (images[position].equals("") || images[position].equals("null")) {
        textId.setText(names[position] + " " + "has won");
        profilePic.setImageBitmap(bitmap2);
    } else {
        try {

            byte[] encodeByte = Base64.decode(images[position], Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            textId.setText(names[position] + " " + "has won");
            profilePic.setImageBitmap(bitmap);

            //myPd_ring.dismiss();

        } catch (Exception e) {
            e.getMessage();
            Log.e(LOG_TAG, "[ONACTIVITYRESULT] Could not bind input to the bytearray: " + e.getMessage());
        }
    }


    //  bitmap1= BitmapFactory.decodeResource(context.getResources(),R.drawable.applyedjob);

































        return listViewItem;
    }

}
