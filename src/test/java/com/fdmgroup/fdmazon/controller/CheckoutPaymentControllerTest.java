package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
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
import com.fdmgroup.fdmazon.model.User;

public class CheckoutPaymentControllerTest {

	private CheckoutPaymentController testController;
	@Mock 
	private HttpServletRequest mockRequest;
	@Mock 
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;
	@Mock
	private MainController mockMainController;
	@Mock
	private User mockUser;
	@Mock
	private Order mockOrder;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new CheckoutPaymentController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("basket")).thenReturn(mockOrder);
		when(mockSession.getAttribute("basketTotal")).thenReturn(100.00d);
		when(mockMainController.getUser(anyString())).thenReturn(mockUser);
		
		when(mockSession.getAttribute(anyString())).thenReturn("abc");
		
		
		when(mockRequest.getParameter(anyString())).thenReturn("abc");
		doNothing().when(mockMainController).init();
		when(mockUser.getPassword()).thenReturn("abc");
		doNothing().when(mockSession).setAttribute(anyString(), anyString());
		doNothing().when(mockMainController).close();
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_WhenBalanceMoreThanBasket() throws ServletException, IOException {
		// Arrange
		when(mockUser.getBalance()).thenReturn(200.00d);
		// Act
//		testController.doPost(mockRequest, mockResponse);
		// Assert
		

	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_WhenBalanceLessThanBasket() throws ServletException, IOException {
		// Arrange
		when(mockUser.getBalance()).thenReturn(10.00d);
		// Act
//		testController.doPost(mockRequest, mockResponse);
		// Assert
		

	}


}
