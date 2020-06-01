package com.fdmgroup.fdmazon.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.model.User;

public class RegistrationFormControllerTest {

	private RegistrationFormController testController;

	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;
	@Mock
	private MainController mockMainController;
	@Mock
	private User mockUser;
	@Mock 
	private RequestDispatcher mockDispatcher;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new RegistrationFormController(mockMainController);
		when(mockRequest.getParameter(anyString())).thenReturn("abc");
		doNothing().when(mockMainController).init();
		doNothing().when(mockMainController).close();
		when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockDispatcher);
	}	

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testFs() {
		// Arrange
		String inputStr = "aaaaa";
		// Act
		String outputStr = testController.fs(inputStr);
		// Assert
		assertEquals("Aaaaa", outputStr);		
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_WhenUserFoundInDatabase() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getUser(anyString())).thenReturn(mockUser);
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockRequest, atLeast(11)).getParameter(anyString());
		verify(mockMainController).getUser(anyString());
		verify(mockRequest).getRequestDispatcher(anyString());
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_WhenUserNotFoundInDatabase() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getUser(anyString())).thenThrow(new NullPointerException());
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockRequest, atLeast(11)).getParameter(anyString());
		verify(mockMainController).getUser(anyString());
		verify(mockMainController).saveUser((User) anyObject());
	}

}
