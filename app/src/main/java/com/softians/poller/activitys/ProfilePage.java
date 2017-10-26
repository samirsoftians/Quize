package com.softians.poller.activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.softians.poller.R;

import com.softians.poller.app.Config;
import com.softians.poller.model.CommonFloatingThings;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static com.softians.poller.R.id.userNameTV;
import static com.softians.poller.activitys.Samir_Login.Email;
import static com.softians.poller.activitys.Samir_Login.mypreference;

public class ProfilePage extends AppCompatActivity {
    Bitmap defaultimage;
    private int PICK_IMAGE_REQUEST = 1;
    private Uri filePath2;
    public static SharedPreferences sharedpreferences;

    private android.support.constraint.ConstraintLayout pConstraintLayout2;
    private de.hdodenhof.circleimageview.CircleImageView pCircleImageView;
    private TextView pUserNameTV;
    private android.support.constraint.ConstraintLayout pConstraintLayout3;
    private TextView pStatsTV;
    private TextView pLogoutTV;
    private Bitmap bitmap;
    public static final String UPLOAD_KEY = "image";


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        defaultimage= BitmapFactory.decodeResource(this.getResources(),R.drawable.prifileimage);

        sharedpreferences = getApplication().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        Config.email=sharedpreferences.getString(Email, "");


        //Toast.makeText(this, Config.email, Toast.LENGTH_SHORT).show();
        bindViews();



        if(sharedpreferences.contains(Email))
        {
            getImage();

        }

        pUserNameTV.setText(Config.email);

        pCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onactivity=1;
                showFileChooser();
            }
        });

        Config.navi=0;

        pStatsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(ProfilePage.this,Tablay.class);
                ints.putExtra("position",0);
                startActivity(ints);
            }
        });
        pLogoutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.email=null;//*****************here i did change the value to null email in the config.email

                SharedPreferences preferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Intent ints = new Intent(ProfilePage.this,Samir_Login.class);
                ints.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(ints);
            }
        });
    }

    private void bindViews() {

        pConstraintLayout2 = (android.support.constraint.ConstraintLayout) findViewById(R.id.constraintLayout2);
       pCircleImageView = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.circleImageView);
        pUserNameTV = (TextView) findViewById(userNameTV);
        pConstraintLayout3 = (android.support.constraint.ConstraintLayout) findViewById(R.id.constraintLayout3);
        pStatsTV = (TextView) findViewById(R.id.statsTV);
        pLogoutTV = (TextView) findViewById(R.id.logoutTV);
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
                Config.navi=1;


                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);
//                Intent intent = new Intent(ProfilePage.this,Samir_Login.class);
//
//                startActivity(intent);
//                finish();



            }
        });
        AlertDialog alert = ad1.create();
        alert.show();

    }

    public void showFileChooser()
    {




            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);


    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);



            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

                filePath2 = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath2);//did put getcontext
                    pCircleImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            uploadImage();





    }

    //******************************************************************************************************
    private void getImage() {
        //  String id = editTextId.getText().toString().trim();
        class GetImage extends AsyncTask<String, Void, Bitmap> {
            //ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();


                //loading = ProgressDialog.show(MainActivity.this, "Retriving image...", null, true, true);
            }

            @Override
            protected void onPostExecute(Bitmap b) {
                super.onPostExecute(b);
                // loading.dismiss();

                if(b!= null)
                {
                    pCircleImageView.setImageBitmap(b);
                }
                else
                {
                    pCircleImageView.setImageBitmap(defaultimage);

                }


            }

            @Override
            protected Bitmap doInBackground(String... params) {
                String id = params[0];
                String add = CommonFloatingThings.USER_IMAGE+Config.email;
                URL url = null;
                Bitmap image = null;
                try {
                    url = new URL(add);
                    image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return image;
            }
        }

        GetImage gi = new GetImage();
        gi.execute(Config.email);
    }


    public void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String> {

            ProgressDialog loading;
            com.softians.poller.activitys.RequestHandler rh = new com.softians.poller.activitys.RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ProfilePage.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                if(s.isEmpty())
                {
                    Toast.makeText(ProfilePage.this,"Could not upload picture",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ProfilePage.this,"Image uploaded",Toast.LENGTH_LONG).show();

                }

//                Intent intent=new Intent(Details.this,Display.class);
//                startActivity(intent);
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

                HashMap<String,String> data = new HashMap<>();
                data.put(UPLOAD_KEY, uploadImage);
                data.put("email", Config.email);

                String result = rh.sendPostRequest(CommonFloatingThings.USER_PHOTO,data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }

    //**********************************Code to upload image to the server**********************
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

}
