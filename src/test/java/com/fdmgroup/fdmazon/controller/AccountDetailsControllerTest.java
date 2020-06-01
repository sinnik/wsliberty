package com.fdmgroup.fdmazon.controller;

import static org.mockito.Mockito.*;

import java.io.IOException;

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

import com.fdmgroup.fdmazon.model.User;

public class AccountDetailsControllerTest {

	private AccountDetailsController testController;
	@Mock
	private MainController mockMainController;
	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;	
	@Mock
	private HttpSession mockSession;
	@Mock
	private User mockUser;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController=new AccountDetailsController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter("stage")).thenReturn("a");
		when(mockSession.getAttribute("sessionId")).thenReturn("abc");
		doNothing().when(mockMainController).init();
		when(mockMainController.getUser("abc")).thenReturn(mockUser);
	}

	@After
	public void tearDown() throws Exception {
		testController=null;
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		// Act
		testController.doGet(mockRequest, mockResponse);
		// Assert
		assertEquals(mockSession,mockRequest.getSession());
		assertEquals("abc", mockSession.getAttribute("sessionId"));
		verify(mockMainController).init();
		verify(mockMainController).close();
		verify(mockSession,atLeastOnce()).getAttribute(anyString());
		verify(mockRequest,atLeast(11)).setAttribute(anyString(), anyObject());
	}

}
