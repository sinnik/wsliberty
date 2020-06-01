package com.fdmgroup.fdmazon.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

public class Checkout1ControllerTest {

	private Checkout1Controller testController;
	
	@Mock
	private MainController mockMainController;
	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;	
	@Mock
	private HttpSession mockSession;
	@Mock
	private User mockUser;
	@Mock
	private Order mockOrder;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController=new Checkout1Controller(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("recipient")).thenReturn("abc ");
		when(mockRequest.getParameter("shipHouseNo")).thenReturn("abc ");
		when(mockRequest.getParameter("shipStreet")).thenReturn("abc ");
		when(mockRequest.getParameter("shipTown")).thenReturn("abc ");
		when(mockRequest.getParameter("shipPostcode")).thenReturn("abc ");
		when(mockRequest.getParameter("shipCountry")).thenReturn("abc ");
		when(mockSession.getAttribute("basket")).thenReturn(mockOrder);
		when(mockSession.getAttribute("sessionId")).thenReturn("email");
		doNothing().when(mockMainController).init();
		when(mockMainController.getUser("email")).thenReturn(mockUser);
		when(mockUser.getBalance()).thenReturn(100.00d);
		doNothing().when(mockMainController).close();
	}

	@After
	public void tearDown() throws Exception {
		testController=null;
	}

	@Test
	public void testFs() {
		// Arrange
		String inputString = "aaaaa";
		// Act
		String outputString = testController.fs(inputString);
		// Assert
		assertEquals("Aaaaa", outputString);	
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockRequest, times(6)).getParameter(anyString());
		assertEquals("abc ",mockRequest.getParameter("recipient"));	
		assertEquals("abc ",mockRequest.getParameter("shipHouseNo"));
		assertEquals("abc ",mockRequest.getParameter("shipStreet"));
		assertEquals("abc ",mockRequest.getParameter("shipTown"));
		assertEquals("abc ",mockRequest.getParameter("shipPostcode"));
		assertEquals("abc ",mockRequest.getParameter("shipCountry"));
		verify(mockRequest,times(1)).getSession();
		verify(mockSession,times(2)).getAttribute(anyString());
		verify(mockSession,times(1)).setAttribute(anyString(), anyString());
		verify(mockRequest,times(1)).setAttribute(anyString(), anyString());		
	}

}
