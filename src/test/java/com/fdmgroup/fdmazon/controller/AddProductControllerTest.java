package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.Product;

public class AddProductControllerTest {
	
	private AddProductController testController;
	@Mock 
	private HttpServletRequest mockRequest;
	@Mock 
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;
	@Mock
	private MainController mockMainController;
	@Mock
	private Order mockOrder;
	@Mock
	private Product mockProduct;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new AddProductController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		doNothing().when(mockSession).setAttribute(anyString(), anyString());
		when(mockRequest.getParameter("productName")).thenReturn("abc");
		when(mockRequest.getParameter("productPrice")).thenReturn("1");
		when(mockRequest.getParameter("productDescription")).thenReturn("abc");
		when(mockRequest.getParameter("productImg")).thenReturn("abc");
		when(mockRequest.getParameter("productBrand")).thenReturn("abc");
		when(mockRequest.getParameter("productCategory")).thenReturn("abc");
		when(mockRequest.getParameter("productStock")).thenReturn("1");
		doNothing().when(mockMainController).init();
		doNothing().when(mockMainController).close();
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SessionIdIsAdmin_RedirectToHome() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("sessionId")).thenReturn("admin@fdm");
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("/fdmazon/home.jsp");
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SessionIdIsNotAdmin_RedirectToSignIn() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("sessionId")).thenReturn("abc");
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("/fdmazon/signin.jsp");
	}

}
