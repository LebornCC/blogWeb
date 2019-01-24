package com.controller;

import com.bean.Messages;
import com.dao.MessageShowDAO;
import com.service.ILoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MessageList extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ILoginService loginService;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        int id = (int)session.getAttribute("loginId");

        if(id!=0){
            //文章展示
            MessageShowDAO show =new MessageShowDAO();
            List<Messages> list;
            list = show.MessageShow(id);
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("text/html;charset=utf-8");
            String json = list.toString();
            response.getWriter().print(json);
        }else {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("text/html;charset=utf-8");
            String json = "{\"code\":0}";
            response.getWriter().print(json);
        }
    }
}