package com.dao;

import com.bean.Messages;
import com.tools.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageShowDAO {
        private DbUtil db = new DbUtil();
        private List<Messages> list=new ArrayList<>();
        public List<Messages> MessageShow(int id){
            String sql = "select userId,title,messageTime,message from Message where userId = " + id;
            ResultSet res = db.excuteQuery(sql);
            Messages mes = null;
            try {
                DbUtil.getConn();
                while (res.next()) {
                    mes = new Messages();
                    mes.setId(id);
                    mes.setTitle(res.getString("title"));
                    mes.setTime(res.getString("messageTime"));
                    mes.setMessage(res.getString("message"));
                    list.add(mes);
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
}


