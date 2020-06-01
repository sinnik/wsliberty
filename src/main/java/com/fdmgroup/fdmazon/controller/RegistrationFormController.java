package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.fdmazon.model.User;

public class RegistrationFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MainController mc;
	
    public RegistrationFormController() {
    	this.mc = new MainController();
    }

    public RegistrationFormController(MainController mainController){
    	this.mc = mainController;
    }
    
	public String fs(String string){
		String formattedString = "";
		if (string != "" && string !=null){
			formattedString = Character.toUpperCase(string.charAt(0)) + string.substring(1);
		}
		return formattedString; 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userTitle = request.getParameter("userTitle");
		String firstName = fs(request.getParameter("firstName").trim());
		String lastName = fs(request.getParameter("lastName").trim());
		String email = (request.getParameter("email").trim()).toLowerCase();
		String password = request.getParameter("password");
		String houseNo = request.getParameter("houseNo").trim();
		String street = fs(request.getParameter("street").trim());
		String town = fs(request.getParameter("town").trim());
		String postcode = (request.getParameter("postcode").trim()).toUpperCase();
		String country = (request.getParameter("country").trim()).toUpperCase();
		String phone = request.getParameter("phone").trim();
		User newUser = new User(userTitle,firstName,lastName,email,password,houseNo,street,town,postcode,country,phone);
		
		try {
			this.mc.init();
			this.mc.getUser(email);
			request.setAttribute("regMsg", "Registration failed. Email has been used. Please try again.");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		} catch (Exception e) {
			this.mc.saveUser(newUser);
			response.sendRedirect("/fdmazon/registrationok.jsp");
		} finally {
			this.mc.close();
		}		
	}
}
