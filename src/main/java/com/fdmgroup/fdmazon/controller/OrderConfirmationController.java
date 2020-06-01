package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.User;

public class OrderConfirmationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainController mc;
    public OrderConfirmationController() {
    	this.mc = new MainController();
    }
    public OrderConfirmationController(MainController mc){
    	this.mc = mc;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order basket = (Order)session.getAttribute("basket");
//		Product p;
//		Order order = new Order(basket.getRecipient(), basket.getShipHouseNo(), basket.getShipStreet(), basket.getShipTown(), basket.getShipPostcode(), basket.getShipCountry(), basket.getTrackingCode());
//		OrderProduct op1 = new OrderProduct();
		// trial 1 --------------
		try {
			this.mc.init();
			User user = this.mc.getUser((String)session.getAttribute("sessionId"));
			basket.setUser(user);
			user.addOrder(basket);
			this.mc.saveOrder(basket);
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
			session.setAttribute("basket", new Order("","","","","","",""));
		}
		
		// trial 2 -------------
//		try {
//			this.mc.init();
//			User user = this.mc.getUser((String)session.getAttribute("sessionId"));
//			order.setUser(user);
//			user.addOrder(order);
//			this.mc.saveUser(user);
//			int item = basket.getOrderProductList().size();
//			for (int i=0; i<item;i++){
//				OrderProduct op = basket.getOrderProductList().get(i);
//				op.setOrder(order);
//				order.addOrderProduct(op);
//				op.getProduct().setStock(op.getProduct().getStock()-op.getQuantity());
//				this.mc.saveOrderProduct(op);
//			}
//			this.mc.saveOrder(order);
//			response.sendRedirect("/fdmazon/index.jsp");
//		} catch (Exception e) {
//			response.sendRedirect("/fdmazon/errorpage.jsp");
//		} finally {
//			this.mc.close();
//			session.setAttribute("basket", new Order("","","","","","",""));
//		}	
//		
		// trial 3 ----------------
//		try {	
//			for (OrderProduct op : basket.getOrderProductList()){
//				order.addOrderProduct(op);
//				op.setOrder(order);
//				this.mc.saveOrderProduct(op);
//			}
//			response.sendRedirect("/fdmazon/index.jsp");
//		} catch (Exception e) {
//			response.sendRedirect("/fdmazon/errorpage.jsp");
//		} finally {
//			this.mc.close();
//		}		
	}
}
