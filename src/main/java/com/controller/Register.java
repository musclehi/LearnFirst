package com.controller;

import com.entity.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns={"/userRegisterAction"}
)
public class Register extends HttpServlet {

    
    @Override
    public void init() throws ServletException {

    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String page;
		User user = new User();
		user.setUserName(username);
		user.setPassWord(password);
		int result = new UserService().addUser(user);
		if(result==1) {
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			session.setAttribute("page",1);
			session.setMaxInactiveInterval(1800);
			response.sendRedirect("/gamelist.jsp");
		}
		else {
			request.setAttribute("result",result);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
}
