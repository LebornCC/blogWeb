package com.dao;

import com.alibaba.fastjson.JSONObject;
import com.tools.DbUtil;

import java.sql.ResultSet;

public class LoginDAOImp{
	DbUtil db = new DbUtil();

	public JSONObject checkUserExist(int id, String pwd) {
		JSONObject jso = new JSONObject();

		String sql = "select userId,userPwd from people where userId = " + id;
		ResultSet res = db.excuteQuery(sql);
		try {
			if (res != null){
				while (res.next()){
					if (pwd.equals(res.getString("userPwd"))){
						jso.put("code", 1);
					} else {
						jso.put("code", 0);
					}
				}
			} else {
				jso.put("code", 0);
				//传递给前端的json问空，可能有问题，但不影响判断，需更改
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return jso;
	}
}
