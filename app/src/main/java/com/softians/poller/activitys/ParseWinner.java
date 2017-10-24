package com.softians.poller.activitys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class ParseWinner {

    public static String[] ids;
    public static String[] names;
    public static String[] images;
    public static String[] ratings;

    public static String[] questions;

    public static String[] answers;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String image = "image";



    private JSONArray users = null;

    private String json;

    public ParseWinner(String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            names = new String[users.length()];
            images = new String[users.length()];


            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
//                ids[i] = jo.getString(KEY_ID);
//                names[i] = jo.getString(KEY_NAME);
//                emails[i] = jo.getString(KEY_EMAIL);
//                ratings[i] = jo.getString(KEY_RATING);


                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                images[i] = jo.getString(image);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
