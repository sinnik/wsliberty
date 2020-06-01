package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.fdmazon.model.Product;

public class SearchBrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MainController mc;
    
    public SearchBrandController() {
    	this.mc = new MainController();
    }
    
    public SearchBrandController(MainController mc) {
    	this.mc = mc;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.mc.init();
			List<Product> productList = this.mc.getProductList();
			String brand = request.getParameter("brand");
			List<Product> filteredProductList = new ArrayList<Product>();
			for (Product p : productList){
				if(p.getProductBrand().equals(brand)){
					filteredProductList.add(p);
				}
			}
			request.setAttribute("fProductList", filteredProductList);
			request.setAttribute("msg", "Shop by Brand: "+brand);
			request.getRequestDispatcher("/shopby.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
		}
	}

}
