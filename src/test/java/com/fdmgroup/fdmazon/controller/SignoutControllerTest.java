package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyString;
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

public class SignoutControllerTest {
	private SignoutController sc;
	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		sc = new SignoutController();
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute(anyString())).thenReturn(null);
	}

	@After
	public void tearDown() throws Exception {
		sc=null;
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		// Act
		sc.doGet(mockRequest, mockResponse);
		// Assert
		verify(mockSession).getAttribute(anyString());
	}
}
