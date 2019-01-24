package com.dao;

import com.alibaba.fastjson.JSONObject;
import com.tools.DbUtil;

import java.sql.ResultSet;

import static com.tools.JsonUtil.json;

public class AddDAO {
    DbUtil rdb = new DbUtil();


    public JSONObject messageAdd(int id, String title,String messageTime,String message) {
        JSONObject jso = new JSONObject();
        String sql = "insert into Message (userId,title,messageTime,message) value (" + id + ",'" + title + "','" + messageTime+"','"+message + "')";
        ResultSet res = rdb.excuteQuery(sql);
        json(jso, res);
        return jso;
    }
}
