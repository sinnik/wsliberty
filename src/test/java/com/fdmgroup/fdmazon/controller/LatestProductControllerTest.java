package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
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

public class LatestProductControllerTest {
	private LatestProductController testController;
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
		testController = new LatestProductController(mockMainController);
		mockProductList.add(mockProduct);
		doNothing().when(mockMainController).init();
		when(mockResponse.getWriter()).thenReturn(mockWriter);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
		doNothing().when(mockMainController).close();
	}
	
	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_WhenProductListSizeMoreThanpNo() throws ServletException, IOException {
		// Arrange
		when(mockProductList.size()).thenReturn(20);
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest).getRequestDispatcher("/homeheader.jsp");
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_WhenProductListSizeLessThanpNo() throws ServletException, IOException {
		// Arrange
		when(mockProductList.size()).thenReturn(5);
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest).getRequestDispatcher("/homeheader.jsp");
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse_WhenWelcomeFlagNotNull() throws ServletException, IOException {
		// Arrange
		when(mockSession.getAttribute("welcomeFlag")).thenReturn("abc");
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockSession).setAttribute("welcomeFlag",null);
	}
}
