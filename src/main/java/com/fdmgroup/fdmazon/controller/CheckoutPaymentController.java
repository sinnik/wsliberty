package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.User;

public class CheckoutPaymentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private MainController mc;
    
	public CheckoutPaymentController() {
		this.mc = new MainController();
    }
	
	public CheckoutPaymentController(MainController mc) {
		this.mc = mc;
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("basket");
		double total = (Double)session.getAttribute("basketTotal");
		try {
			this.mc.init();
			User user = this.mc.getUser((String)session.getAttribute("sessionId"));
			if (user.getBalance()>=(Double)session.getAttribute("basketTotal")){
				response.sendRedirect("/fdmazon/orderconfirmation.jsp");
			} else {
				request.setAttribute("balance",	user.getBalance());
				request.setAttribute("msg", "Insufficient fund. Please choose another payment method.");
				request.getRequestDispatcher("/checkout2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
		}
	}

}
