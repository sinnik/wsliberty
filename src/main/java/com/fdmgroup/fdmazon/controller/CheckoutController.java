package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainController mc;
    
    public CheckoutController() {
    	this.mc = new MainController();
    }
    
    public CheckoutController(MainController mc) {
    	this.mc = mc;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionId")== null){
			response.sendRedirect("/fdmazon/signin.jsp");
		} else {
			response.sendRedirect("/fdmazon/checkout1.jsp");
		}
		
	}

}
