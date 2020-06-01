package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.OrderProduct;

public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainController mc;
    public BasketController() {
    	this.mc = new MainController();
    }

    public BasketController(MainController mc) {
    	this.mc = mc;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("basket");
		Order updateOrder = new Order("","","","","","","");
		OrderProduct opUpdate = new OrderProduct();
		int newQuantity;
		for (OrderProduct op : order.getOrderProductList()){
			if(request.getParameter(String.valueOf(op.getProduct().getProductId()))==""){
				opUpdate.setOrder(updateOrder);
				opUpdate.setProduct(op.getProduct());
				opUpdate.setQuantity(op.getQuantity());
				updateOrder.addOrderProduct(opUpdate);
			} else {
				newQuantity = Integer.valueOf(request.getParameter(String.valueOf(op.getProduct().getProductId())));
				if(newQuantity > 0 && newQuantity <= op.getProduct().getStock()){
					opUpdate.setOrder(updateOrder);
					opUpdate.setProduct(op.getProduct());
					opUpdate.setQuantity(newQuantity);
					updateOrder.addOrderProduct(opUpdate);				
				} else if (newQuantity > op.getProduct().getStock()) {
					opUpdate.setOrder(updateOrder);
					opUpdate.setProduct(op.getProduct());
					opUpdate.setQuantity(op.getProduct().getStock());
					updateOrder.addOrderProduct(opUpdate);
				}
			}
		}
		session.setAttribute("basket", updateOrder);
		response.sendRedirect("basket.jsp");
	}
}
