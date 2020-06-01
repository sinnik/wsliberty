package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

public class SearchCatControllerTest {
	private SearchCatController testController;
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
	@Mock
	private List<Product>mockProductList;
	@Mock
	private PrintWriter mockWriter;
	@Mock
	private RequestDispatcher mockRequestDispatcher; 
	@Mock
	private Iterable<Product> mockItProduct;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new SearchCatController(mockMainController);
		doNothing().when(mockMainController).init();
		when(mockResponse.getWriter()).thenReturn(mockWriter);
		doNothing().when(mockMainController).close();
		when(mockRequest.getAttribute("welcomeMsg")).thenReturn("abc");
		when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_GetProductListWorks() throws ServletException, IOException {
		// Arrange
		
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockMainController).getProductList();
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_SetAttributeWorks() throws ServletException, IOException {
		// Arrange
		
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest, times(2)).setAttribute(anyString(), anyString());
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_GetRequestDispatcherCalled() throws ServletException, IOException {
		// Arrange
		
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest).getRequestDispatcher("/shopby.jsp");	
	}
}
