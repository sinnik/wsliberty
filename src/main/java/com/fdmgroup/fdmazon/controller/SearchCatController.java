package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.fdmazon.model.Product;

public class SearchCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MainController mc;
	
    public SearchCatController() {
    	this.mc = new MainController();
    }
    
    public SearchCatController(MainController mc) {
    	this.mc = mc;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cat = request.getParameter("cat");
		try {
			this.mc.init();
			List<Product> productList = this.mc.getProductList();
			List<Product> filteredProductList = new ArrayList<Product>();
			for (Product p : productList){
				if(p.getCategory().equals(cat)){
					filteredProductList.add(p);
				}
			}
			request.setAttribute("fProductList", filteredProductList);
			request.setAttribute("msg", "Shop by Category: "+cat);
			request.getRequestDispatcher("/shopby.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
		}
	}
}
