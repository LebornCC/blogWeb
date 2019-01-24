package com.dao;

import com.alibaba.fastjson.JSONObject;
import com.tools.DbUtil;

import java.sql.ResultSet;

import static com.tools.JsonUtil.json;

public class DeleteDAO {

    DbUtil rdb = new DbUtil();

    public JSONObject messageDelete(String title) {
        JSONObject jso = new JSONObject();
        String sql = "delete from Message where title="+title;
        ResultSet res1 = rdb.excuteQuery(sql);
        json(jso, res1);
        return jso;
    }
}