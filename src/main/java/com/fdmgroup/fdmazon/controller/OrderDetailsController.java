package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;

public class OrderDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainController mc;
	public OrderDetailsController() {
		this.mc = new MainController();
	}

	public OrderDetailsController(MainController mc) {
		this.mc = mc;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("sessionId")!= null){
			String linkOD = request.getParameter("linkOD");
			try {
				this.mc.init();
				Order orderLinked = this.mc.getOrder(Long.valueOf(linkOD));
				request.setAttribute("oLinked", orderLinked);
				request.getRequestDispatcher("orderdetails.jsp").forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("/fdmazon/errorpage.jsp");
			} finally {
				this.mc.close();
			}			
		} else {
			response.sendRedirect("/fdmazon/signin.jsp");			
		}
	}
}
