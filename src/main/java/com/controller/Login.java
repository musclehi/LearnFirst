package com.controller;

import com.entity.User;
import com.service.UserService;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(
    urlPatterns={"/userLoginAction"}
)
public class Login extends HttpServlet {

    
    @Override
    public void init() throws ServletException {

    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
		User user = new User();
		user.setUserName(username);
		user.setPassWord(password);
		System.out.println(username);
		int result = new UserService().findUser(user);
		if(result==1) {
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			session.setAttribute("page",1);
			session.setMaxInactiveInterval(1800);
			response.sendRedirect("/gamelist.jsp");
		}
		else {
			System.out.println("here");
			request.setAttribute("result","201");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}
}
