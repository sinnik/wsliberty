package com.fdmgroup.fdmazon.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
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

import com.fdmgroup.fdmazon.model.User;

public class SignInFormControllerTest {

	private SignInFormController testController;

	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;
	@Mock
	private MainController mockMainController;
	@Mock
	private User mockUser;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new SignInFormController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("loginEmail")).thenReturn("abc");
		when(mockRequest.getParameter(anyString())).thenReturn("abc");
		doNothing().when(mockMainController).init();
		when(mockMainController.getUser(anyString())).thenReturn(mockUser);
		doNothing().when(mockMainController).close();
		when(mockUser.getPassword()).thenReturn("abc");		
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SessionIsCreated() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockRequest).getSession();
		verify(mockRequest, atLeastOnce()).getParameter(anyString());
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_GetParameterWorks() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockRequest, atLeastOnce()).getParameter(anyString());
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_MainControllerGetUserMethod_ReturnUserObject() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		assertEquals(mockUser, mockMainController.getUser(anyString()));
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_MainControllerInitMethodCalled() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockMainController).init();
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_MainControllerCloseMethodCalled() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockMainController).close();
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SessionSetAttributeCalled4Times() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockSession,times(5)).setAttribute(anyString(), anyString());
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_UserPasswordInvalid() throws ServletException, IOException {
		// Arrange
		when(mockUser.getPassword()).thenReturn("xyz");		
		// Act
		testController.doPost(mockRequest, mockResponse);
		// Assert
		verify(mockResponse).sendRedirect(anyString());
	}
}
