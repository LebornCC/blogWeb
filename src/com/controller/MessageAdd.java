package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.AddDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MessageAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = (String)request.getParameter("title");
        String message = (String)request.getParameter("message");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String messageTime=dateFormat.format(new Date());
        //id 用session获取id
        HttpSession session = request.getSession(false);
        int loginId = (int)session.getAttribute("loginId");
        AddDAO MessagesAdd =new AddDAO();
        response.getWriter().print(JSON.toJSONString(MessagesAdd.messageAdd(loginId,title,messageTime,message)));
    }
}
