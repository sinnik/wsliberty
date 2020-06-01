package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RemoveProductControllerTest {
	
	private RemoveProductController testController;
	@Mock
	private MainController mockMainController;
	@Mock 
	private HttpServletRequest mockRequest;
	@Mock 
	private HttpServletResponse mockResponse;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new RemoveProductController(mockMainController);
		when(mockRequest.getParameter("productId")).thenReturn("1");
		doNothing().when(mockMainController).init();
		doNothing().when(mockMainController).close();
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockMainController).deleteProduct(anyLong());
	}

}
