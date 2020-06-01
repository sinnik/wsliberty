package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.User;

public class Checkout1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainController mc;
	public Checkout1Controller() {
		this.mc = new MainController();
	}
	
	public Checkout1Controller(MainController mc){
		this.mc = mc;
	}

	public String fs(String string) {
		String formattedString = "";
		if (string != "" && string != null) {
			formattedString = Character.toUpperCase(string.charAt(0)) + string.substring(1);
		}
		return formattedString;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		HttpSession session = request.getSession();
		String recipient = fs(request.getParameter("recipient").trim());
		String shipHouseNo = request.getParameter("shipHouseNo").trim();
		String shipStreet = fs(request.getParameter("shipStreet").trim());
		String shipTown = fs(request.getParameter("shipTown").trim());
		String shipPostcode = (request.getParameter("shipPostcode").trim()).toUpperCase();
		String shipCountry = (request.getParameter("shipCountry").trim()).toUpperCase();

		Order order = (Order)session.getAttribute("basket");
		order.setRecipient(recipient);
		order.setShipHouseNo(shipHouseNo);
		order.setShipStreet(shipStreet);
		order.setShipTown(shipTown);
		order.setShipPostcode(shipPostcode);
		order.setShipCountry(shipCountry);
		session.setAttribute("basket", order);
		try {
			this.mc.init();
			User user = this.mc.getUser((String)session.getAttribute("sessionId"));
			double balance = user.getBalance();
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("/checkout2.jsp").forward(request, response);	
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
		}
	}
}
