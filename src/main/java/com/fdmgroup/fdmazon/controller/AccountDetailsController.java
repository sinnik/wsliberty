package com.fdmgroup.fdmazon.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.User;

public class AccountDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MainController mc;
	
    public AccountDetailsController() {
    	this.mc = new MainController();
    }
    
    public AccountDetailsController(MainController mc) {
    	this.mc = mc;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String stage = request.getParameter("stage");
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		if(session.getAttribute("sessionId")!=null){
			try {
				this.mc.init();
				User userFound = this.mc.getUser((String)session.getAttribute("sessionId"));
				request.setAttribute("uTitle", userFound.getUserTitle());
				request.setAttribute("uFirstName", userFound.getFirstName());
				request.setAttribute("uLastName", userFound.getLastName());
				request.setAttribute("uHouseNo", userFound.getHouseNo());
				request.setAttribute("uStreet", userFound.getStreet());
				request.setAttribute("uTown", userFound.getTown());
				request.setAttribute("uPostcode", userFound.getPostcode());
				request.setAttribute("uCountry", userFound.getCountry());
				request.setAttribute("uPhone", userFound.getPhone());
				request.setAttribute("uRegisteredDate", userFound.getRegisteredDate());
				request.setAttribute("uBalance", df.format(userFound.getBalance()));
				if(stage.equals("a")){
					request.getRequestDispatcher("accountdetails.jsp").forward(request, response);
				} else if (stage.equals("b")){
					request.getRequestDispatcher("editaccountdetails.jsp").forward(request, response);
				}
			} catch (Exception e) {
				response.sendRedirect("errorpage.jsp");
			} finally {
				this.mc.close();
			}
		} else {
			response.sendRedirect("/fdmazon/signin.jsp");
		} 
	}
}