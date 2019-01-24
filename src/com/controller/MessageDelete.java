package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.DeleteDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



    public class MessageDelete extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }

        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String title = (String)request.getParameter("title");
            DeleteDAO MessagesDelete =new DeleteDAO();
            response.getWriter().print(JSON.toJSONString(MessagesDelete.messageDelete(title)));

        }
    }


