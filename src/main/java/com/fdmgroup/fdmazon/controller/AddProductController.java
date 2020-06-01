package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Product;

public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainController mc;   
    public AddProductController() {
    	this.mc = new MainController();
    }

    public AddProductController(MainController mc) {
    	this.mc = mc;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String productName = request.getParameter("productName");
		double productPrice = Double.valueOf(request.getParameter("productPrice"));
		String productCode = request.getParameter("productCode");
		String productDescription = request.getParameter("productDescription");
		String productImg = request.getParameter("productImg");
		String productBrand = request.getParameter("productBrand");
		String category = request.getParameter("productCategory");
		int stock = Integer.valueOf(request.getParameter("productStock"));
		Product newProduct = new Product(productName, productPrice, productCode, productDescription, productImg, productBrand, category, stock);
		if(session.getAttribute("sessionId").equals("admin@fdm")){
			try {
				this.mc.init();
				this.mc.saveProduct(newProduct);
				response.sendRedirect("/fdmazon/home.jsp");
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
