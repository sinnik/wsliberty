package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainController mc;
	
    public RemoveProductController() {
    	this.mc = new MainController();
    }

    public RemoveProductController(MainController mc) {
    	this.mc = mc;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long productId = Long.valueOf(request.getParameter("productId"));
		this.mc.init();
		this.mc.deleteProduct(productId);
		this.mc.close();
		response.sendRedirect("/fdmazon/home.jsp");		
	}

}
