package com.example.ashi.irrigatedmanager.util;

import com.example.ashi.irrigatedmanager.gson.Abnormal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ashi on 8/27/2018.
 */

public class Global {

    public static String userId = "1";

    public static boolean isExceptionFound = false;
    public static String exceptionMsg = "";

    public static String projectInfoType = "channelHead";
    public static String projectId = "331d737641434a0bb476265b38d9db1c";
    public static String projectInfoSubtype = "1";
    public static HashMap<String,String> projectDetails = new HashMap<>();

    // patrol
    public static String patrolType = "channel";
    public static String patrolId = "62c59e22820b41e094fa17788df11b66";
    public static HashMap<String,String> patrolDetails = new HashMap<>();

    public static List<Abnormal> abnormalList = new ArrayList<>();

    public static String rain_name = "柳林总雨量";

    public static int irrigation_turn = 1;

    // appval
    public static boolean lastPageIsTodo = false;
    public static String businessKey = "pro_patrol_result_deal:98eaf7ee37354b48b875caf30bbad7a9";
    public static String processInstanceId = "93acd047627d45edad2102a7cf00cc0e";
}
