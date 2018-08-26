package com.example.ashi.irrigatedmanager.util;

import com.example.ashi.irrigatedmanager.gson.TotalCount;
import com.example.ashi.irrigatedmanager.gson.User;
import com.example.ashi.irrigatedmanager.level2_4.Rain;
import com.example.ashi.irrigatedmanager.level5.Appval;
import com.example.ashi.irrigatedmanager.level5.AppvalHistory;
import com.example.ashi.irrigatedmanager.level5.MyProcess;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ashi on 7/11/2018.
 */

public class Utility {

    public static User handleApi01LoginResponse(String response) {
        try {
            return new Gson().fromJson(response, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Rain> handleApi05RainMonitorListResponse(String response) {
        try {
            return new Gson().fromJson(response, new TypeToken<List<Rain>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Appval> handleApi12TodoActListResponse(String response) {
        try {
            return new Gson().fromJson(response, new TypeToken<List<Appval>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AppvalHistory handleApi13HisoryActListResponse(String response) {
        try {
            return new Gson().fromJson(response, AppvalHistory.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MyProcess handleApi14getMyProcessResponse(String response) {
        try {
            return new Gson().fromJson(response, MyProcess.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TotalCount handleApi29TotalCountResponse(String response) {
        try {
            return new Gson().fromJson(response, TotalCount.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
