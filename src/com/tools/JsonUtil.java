package com.tools;

import com.alibaba.fastjson.JSONObject;

import java.sql.ResultSet;

public class JsonUtil {
    public static void json(JSONObject jso, ResultSet res) {
        try {
            if(res!=null){
                jso.put("code", 1);
            } else{
                jso.put("code", 0);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
