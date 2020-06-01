package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.fdmazon.model.Product;

public class ProductLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MainController mc;
	
    public ProductLinkController() {
    	this.mc = new MainController();
    }
    
    public ProductLinkController(MainController mc) {
    	this.mc = mc;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("link");
		request.setAttribute("link", link);
		Product productLinked = new Product();
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		try {
			this.mc.init();
			productLinked = this.mc.getProduct(Long.valueOf(link));
			if (productLinked != null){
				request.setAttribute("pId", productLinked.getProductId());
				request.setAttribute("pName", productLinked.getProductName());
				request.setAttribute("pPrice", df.format(productLinked.getProductPrice()));
				request.setAttribute("pDesc", productLinked.getProductDescription());
				request.setAttribute("pCode", productLinked.getProductCode());
				request.setAttribute("pImg", productLinked.getProductImg());
				request.setAttribute("pCat", productLinked.getCategory());
				request.setAttribute("pBrand", productLinked.getProductBrand());
				request.setAttribute("pStock", productLinked.getStock());
				request.getRequestDispatcher("/product.jsp").forward(request, response);
			} else {
				response.sendRedirect("/fdmazon/errorpage.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
		}
	}
}