package com.fdmgroup.fdmazon.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.User;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckoutControllerTest {

	private CheckoutController testController;
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
		testController=new CheckoutController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SessionIdIsNull() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("sessionId")).thenReturn(null);
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		assertNull(mockSession.getAttribute("sessionId"));
		verify(mockSession, atLeastOnce()).getAttribute("sessionId");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SessionIdIsNotNull() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("sessionId")).thenReturn("abc");
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		assertNotNull(mockSession.getAttribute("sessionId"));
		verify(mockSession, atLeastOnce()).getAttribute("sessionId");
	}
}
