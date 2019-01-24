package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.RegisterDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("userId"));
        String pwd = (String)request.getParameter("userPwd");
        RegisterDAO reg = new RegisterDAO();
        response.getWriter().print(JSON.toJSONString(reg.register(id,pwd)));
    }
}
