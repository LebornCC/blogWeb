package com.dao;

import com.alibaba.fastjson.JSONObject;
import com.tools.DbUtil;

import java.sql.ResultSet;

import static com.tools.JsonUtil.json;

public class RegisterDAO {
    DbUtil rdb = new DbUtil();
    public JSONObject register(int id , String pwd) {
        JSONObject jso = new JSONObject();
        String sql = "insert into people (userId,userPwd) value(" + id + "," + pwd + "')";
        ResultSet res = rdb.excuteQuery(sql);
        json(jso, res);
        return jso;
    }
}