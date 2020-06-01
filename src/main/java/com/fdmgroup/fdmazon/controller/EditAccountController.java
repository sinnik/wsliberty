package com.fdmgroup.fdmazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.fdmazon.model.User;

public class EditAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainController mc;
	
	public EditAccountController() {
		this.mc = new MainController();
	}

	public EditAccountController(MainController mc) {
		this.mc = mc;
	}

	public String fs(String string) {
		String formattedString = "";
		if (string != "" && string != null) {
			formattedString = Character.toUpperCase(string.charAt(0)) + string.substring(1);
		}
		return formattedString;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newFirstName = request.getParameter("newFirstName");
		String newLastName = request.getParameter("newLastName");
		String oldPassword = request.getParameter("oldPassword");
		String newHouseNo = request.getParameter("newHouseNo");
		String newStreet = request.getParameter("newStreet");
		String newTown = request.getParameter("newTown");
		String newPostcode = request.getParameter("newPostcode");
		String newCountry = request.getParameter("newCountry");
		String newPhone = request.getParameter("newPhone");
		try {
			this.mc.init();
			User userFound = this.mc.getUser((String)session.getAttribute("sessionId"));
			if (oldPassword.equals((String) userFound.getPassword())) {
				if (newFirstName != null) {
					if (newFirstName.trim() != "") {
						userFound.setFirstName(fs(newFirstName).trim());
					}
				}
				if (newLastName != null) {
					if (newLastName.trim() != "") {
						userFound.setLastName(fs(newLastName).trim());
					}
				}
				if (newHouseNo != null) {
					if (newHouseNo.trim() != "") {
						userFound.setHouseNo(fs(newHouseNo).trim());
					}
				}
				if (newStreet != null) {
					if (newStreet.trim() != "") {
						userFound.setStreet(fs(newStreet).trim());
					}
				}
				if (newTown != null) {
					if (newTown.trim() != "") {
						userFound.setTown(fs(newTown).trim());
					}
				}
				if (newPostcode != null) {
					if (newPostcode.trim() != "") {
						userFound.setPostcode(newPostcode.trim().toUpperCase());
					}
				}
				if (newCountry != null) {
					if (newCountry.trim() != "") {
						userFound.setCountry(newCountry.trim().toUpperCase());
					}
				}
				if (newPhone != null) {
					if (newPhone.trim() != "") {
						userFound.setPhone(newPhone.trim());
					}
				}
				this.mc.updateUser(userFound);
				session.setAttribute("editMsg", "Update successful.");
			} else {
				session.setAttribute("editMsg", "Update failed. Invalid password.");
			}
			response.sendRedirect("/fdmazon/accountDetailsC?stage=a");
		} catch (Exception e) {
			response.sendRedirect("/fdmazon/errorpage.jsp");
		} finally {
			this.mc.close();
		}
	}
}