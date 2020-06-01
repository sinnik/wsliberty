package com.fdmgroup.fdmazon.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
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

public class AddBasketControllerTest {
	
	private AddBasketController testController;
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
		testController = new AddBasketController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		doNothing().when(mockSession).setAttribute(anyString(), anyString());
		when(mockRequest.getParameter("quantity")).thenReturn("1");
		when(mockRequest.getParameter("stock")).thenReturn("10");
		when(mockRequest.getParameter("productAdded")).thenReturn("1");		
		doNothing().when(mockMainController).init();
		when(mockMainController.getProduct(1L)).thenReturn(mockProduct);
		doNothing().when(mockMainController).close();
	}
	
	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("basket")).thenReturn(mockOrder);
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		assertEquals(mockSession,mockRequest.getSession());
		assertEquals(mockOrder, mockSession.getAttribute("basket"));
		verify(mockMainController).init();
		verify(mockMainController).close();
		verify(mockMainController).getProduct(anyLong());
		verify(mockSession,atLeastOnce()).getAttribute(anyString());
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_WhenBasketIsNull() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("basket")).thenReturn(null);
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		assertEquals(mockSession,mockRequest.getSession());
		assertNull(mockSession.getAttribute("basket"));
		verify(mockMainController).init();
		verify(mockMainController).close();
		verify(mockMainController).getProduct(anyLong());
		verify(mockSession,atLeastOnce()).getAttribute(anyString());
	}
}
