package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyLong;
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

public class OrderDetailsControllerTest {
	private OrderDetailsController testController;
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
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new OrderDetailsController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("linkOD")).thenReturn("1");
		doNothing().when(mockMainController).init();
		when(mockMainController.getOrder(anyLong())).thenReturn(mockOrder);
		doNothing().when(mockRequest).setAttribute(anyString(), anyString());
		doNothing().when(mockMainController).close();
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_WhenSessionIdIsNotNull() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("sessionId")).thenReturn("abc");
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest).getSession();
		verify(mockRequest).getParameter("linkOD");
		verify(mockMainController).getOrder(anyLong());
		verify(mockRequest).setAttribute(anyString(), anyString());
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_WhenSessionIdIsNull() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("sessionId")).thenReturn(null);
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect(anyString());
	}
}
