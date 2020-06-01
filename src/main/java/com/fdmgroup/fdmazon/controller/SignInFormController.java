package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.User;

public class SignInFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MainController mc;

	public SignInFormController() {
		this.mc = new MainController();
	}

	public SignInFormController(MainController mc) {
		this.mc = mc;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginEmail = request.getParameter("loginEmail").toLowerCase();
		String loginPassword = request.getParameter("loginPassword");
		this.mc.init();
		User userFound = (User)this.mc.getUser(loginEmail);
		this.mc.close();
		if (userFound.getPassword().equals(loginPassword)) {
			session.setAttribute("sessionId", userFound.getEmail());
			session.setAttribute("ssID", userFound.getUserId());
			session.setAttribute("uFirstName", userFound.getFirstName());
			session.setAttribute("admin", "admin@fdm");
			session.setAttribute("welcomeFlag", "1");
			response.sendRedirect("/fdmazon/home.jsp");
		} else {
			response.sendRedirect("/fdmazon/signinfail.jsp");
		}
	}
}
