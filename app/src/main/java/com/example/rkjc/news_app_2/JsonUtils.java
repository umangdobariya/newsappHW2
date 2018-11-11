package com.example.rkjc.news_app_2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {
    public static ArrayList<NewsItem> parseNews(String JSONString){
        ArrayList<NewsItem> itemArrayList=new ArrayList<>();

        try {
            JSONObject jobject=new JSONObject(JSONString);
            JSONArray jArray=jobject.getJSONArray("articles");
            for (int i=0;i<jArray.length();i++){
                JSONObject abcdefghijklmnopqrstuvwxyz=jArray.getJSONObject(i);
                itemArrayList.add(new NewsItem(abcdefghijklmnopqrstuvwxyz.getString("title"),
                        abcdefghijklmnopqrstuvwxyz.getString("description"),
                        abcdefghijklmnopqrstuvwxyz.getString("publishedAt"),
                        abcdefghijklmnopqrstuvwxyz.getString("url")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemArrayList;
    }

}


