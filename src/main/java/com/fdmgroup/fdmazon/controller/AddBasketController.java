package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.OrderProduct;
import com.fdmgroup.fdmazon.model.Product;

public class AddBasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainController mc;   
	
    public AddBasketController() {
        this.mc = new MainController();
    }

    public AddBasketController(MainController mc) {
        this.mc = mc;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("basket")==null){
			Order order1 = new Order("", "", "", "", "", "", "");
			session.setAttribute("basket", order1);
		}
		Order order = (Order)session.getAttribute("basket");
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		int stock = Integer.valueOf(request.getParameter("stock"));
		long productId = Long.valueOf(request.getParameter("productAdded")); 
		if(quantity>0 && quantity<=stock){
			this.mc.init();
			Product product = new Product();
			try {
				product = this.mc.getProduct((Long)productId);
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setOrder(order);
				orderProduct.setProduct(product);
				orderProduct.setQuantity(quantity);
				order.addOrderProduct(orderProduct);
				session.setAttribute("basket", order);
				response.sendRedirect("basket.jsp");
			} catch (Exception e) {
				response.sendRedirect("errorpage.jsp");
			} finally{
				this.mc.close();
			}
		} else {
			session.setAttribute("addbasketmsg", "Please enter quantity more than zero and less that the available stock.");
			response.sendRedirect("/fdmazon/productLinkC?link="+productId);
		}
	}
}