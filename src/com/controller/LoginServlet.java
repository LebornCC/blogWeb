package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.LoginDAOImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("userId"));
		String pwd = (String)request.getParameter("userPwd");
		HttpSession session = request.getSession();
		session.setAttribute("loginId", id);
		LoginDAOImp check = new LoginDAOImp();
		response.getWriter().print(JSON.toJSONString(check.checkUserExist(id,pwd)));
	}
}