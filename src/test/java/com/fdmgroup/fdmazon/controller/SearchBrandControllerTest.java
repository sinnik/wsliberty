package com.fdmgroup.fdmazon.controller;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.model.Product;

public class SearchBrandControllerTest {

	private SearchBrandController testController;
	@Mock
	private MainController mockMainController;
	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;	
	@Mock
	private HttpSession mockSession;
	@Mock
	private Product mockProduct;
	@Mock
	private List<Product> mockProductList;

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new SearchBrandController(mockMainController);
		//mockProductList.add(mockProduct);
		doNothing().when(mockMainController).init();
		when(mockMainController.getProductList()).thenReturn(mockProductList);
		when(mockRequest.getParameter("brand")).thenReturn("abc");
	//	doNothing().when(mockRequest).setAttribute(anyString(), anyString());
		when(mockProduct.getProductBrand()).thenReturn("abc");
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockMainController).getProductList();
		verify(mockRequest).getParameter("brand");
	}

}
