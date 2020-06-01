package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.Product;

public class LatestProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MainController mc;
	
	public LatestProductController() {
		this.mc = new MainController();
	}

	public LatestProductController(MainController mc){
		this.mc = mc;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		this.mc.init();
		List<Product> productList = new ArrayList<Product>();
		productList = this.mc.getProductList();
		List<Product> latestList = new ArrayList<Product>();
		
		int productToShow = 10; // number of latest products to show
		
		int productListSize = productList.size();
		if (productListSize < productToShow) {
			productToShow = productListSize;
		}
		for(int k=0;k<productToShow;k++){
			latestList.add(productList.get(productListSize-1-k));
		}
		this.mc.close();
		PrintWriter out = response.getWriter();
		
		// building homepage
		request.getRequestDispatcher("/homeheader.jsp").include(request, response);
		out.print("<div id=\"content\">");
		if( session.getAttribute("welcomeFlag")!=null){
			out.print("<div id=\"content1\"><h1>Welcome back, "+session.getAttribute("uFirstName")+".</h1></div>");
			session.setAttribute("welcomeFlag", null);
		} else {
			out.print("<div class=\"notdisplay\" id=\"content1\"></div>");
		}
		out.print("<div class=\"notdisplay\" id=\"content2\"></div>");
		out.print("<div id=\"content3\" style=\"width: auto;\">");
		out.print("<h1>Latest Products</h1>");
		int i = 0;
		for (Product e : latestList){
			if(i<productToShow){
				out.print("<div class=\"listproduct\"><a href=\"/fdmazon/productLinkC?link="+e.getProductId()+"\">");
				out.print("<img src=\""+e.getProductImg()+"\"></img></a>");
				out.print("<br><a href=\"/fdmazon/productLinkC?link="+e.getProductId()+"\">");
				out.print(e.getProductName()+"</a>");
				out.print("<br>&pound "+df.format(e.getProductPrice())+"</div>");
				i++;
			} 
		}
		request.getRequestDispatcher("/homefooter.jsp").include(request, response);
	}
}
