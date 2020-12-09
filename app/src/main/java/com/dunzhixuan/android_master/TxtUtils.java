package com.dunzhixuan.android_master;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TxtUtils {

  public static void a(Context context) {
    String result = getJson(context, "gettabcard.txt");
    new Gson();


//	  Log.d("AAA", result);
//    try {
//      JSONArray json = new JSONArray(result);
//      for (int i = 0; i < json.length(); i++) {
//        JSONObject jb = json.getJSONObject(i);
//        Log.d("AAA", jb.getString("name"));
//        Log.d("AAA", String.valueOf(json.length()));
//      }
//    } catch (JSONException e) {
//      e.printStackTrace();
//    }
  }

  public static String getJson(Context context, String fileName) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      AssetManager assetManager = context.getAssets();
      BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
      String line;
      while ((line = bf.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stringBuilder.toString();
  }
}
