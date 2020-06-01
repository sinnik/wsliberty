package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

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

import com.fdmgroup.fdmazon.model.Product;


public class ProductLinkControllerTest {
	
	private ProductLinkController testController;
	@Mock
	private MainController mockMainController;
	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;	
	@Mock
	private HttpSession mockSession;
	@Mock
	private Product	mockProduct;
	@Mock
	private RequestDispatcher mockRequestDispatcher;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController=new ProductLinkController(mockMainController);
		when(mockRequest.getParameter("link")).thenReturn("1");
		doNothing().when(mockRequest).setAttribute(anyString(), anyString());
		doNothing().when(mockMainController).init();
		when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void test_DoGetHttpServletRequestHttpServletResponse_RequestSetAttributeExecutedTenTimes() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getProduct(anyLong())).thenReturn(mockProduct);
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest,times(10)).setAttribute(anyString(), any());
	}

	@Test
	public void test_DoGetHttpServletRequestHttpServletResponse_RequestDispatcherExecuted() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getProduct(anyLong())).thenReturn(mockProduct);
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockRequest).getRequestDispatcher("/product.jsp");
	}
	
	@Test
	public void test_DoGetHttpServletRequestHttpServletResponse_ProductLinkedIsNull() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getProduct(anyLong())).thenReturn(null);
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("/fdmazon/errorpage.jsp");
	}
	
	@Test
	public void test_DoGetHttpServletRequestHttpServletResponse_CatchException() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getProduct(anyLong())).thenThrow(new NullPointerException());
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("/fdmazon/errorpage.jsp");
	}
}
