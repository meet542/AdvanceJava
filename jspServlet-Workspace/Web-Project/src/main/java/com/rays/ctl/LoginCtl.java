package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")//wildcard-mapping

public class LoginCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String op = request.getParameter("operation");
		
		if(op != null) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp"); 
		// here RequestDispatcher is interface we use getRequestDispatcher() method of HttpServletRequest class which return object of RequestDispatcher
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String loginId = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		try {
			bean = model.authenticate(loginId, password);
			if(bean != null) {
				System.out.println("login successfull.");
				request.setAttribute("succMsg", "login successfull.");
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
//				request.setAttribute("login", true);
				return;
			}else {
				System.out.println("invalid credentials.");
				request.setAttribute("errMsg", "invalid login id or password!!");
//				request.setAttribute("login", false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp"); 
		rd.forward(request, response);
	}
}
