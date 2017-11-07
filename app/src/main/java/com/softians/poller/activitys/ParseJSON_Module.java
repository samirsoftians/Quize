package com.softians.poller.activitys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 11/7/2017.
 */

public class ParseJSON_Module {

    public static String[] ids;
    public static String[] topics;
    public static String[] end_tr;
    public static String[] start_tr;

    public static int length;



    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_TOPICS = "topics";
    public static final String KEY_END_TIME = "end_tr";
    public static final String KEY_START_TIME= "start_tr";




    private JSONArray users = null;

    private String json;

    public ParseJSON_Module(String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);



length=users.length();
            ids = new String[users.length()];
            topics = new String[users.length()];
            end_tr = new String[users.length()];
            start_tr = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);



                ids[i] = jo.getString(KEY_ID);
                topics[i] = jo.getString(KEY_TOPICS);
                end_tr[i] = jo.getString(KEY_END_TIME);
                start_tr[i] = jo.getString(KEY_START_TIME);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
