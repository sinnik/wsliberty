package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;

public class OrderHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainController mc;
	
    public OrderHistoryController() {
    	this.mc = new MainController();
    }
    
    public OrderHistoryController(MainController mc){
    	this.mc = mc;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		this.mc.init();
		List<Order> allOrders = this.mc.getOrderList();
		this.mc.close();
		List<Order> ordersFound = new ArrayList<Order>();
		for (Order o : allOrders){
			if (o.getUser().getUserId()==(Long)session.getAttribute("ssID")){
				ordersFound.add(o);
			}
		}
		request.setAttribute("orderList", ordersFound);
		request.getRequestDispatcher("/orderhistory.jsp").forward(request, response);
	}
}
