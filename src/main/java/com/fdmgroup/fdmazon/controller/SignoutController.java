package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		if(request.getSession().getAttribute("sessionId")==null){
			response.sendRedirect("/fdmazon/signout.jsp");
		}
	}
}
