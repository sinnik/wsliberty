package com.fdmgroup.fdmazon.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.model.User;

public class EditAccountControllerTest extends Mockito{
	
	private EditAccountController testController;
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
		testController = new EditAccountController(mockMainController);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getParameter(anyString())).thenReturn("abc");
		doNothing().when(mockMainController).init();
		when(mockSession.getAttribute(anyString())).thenReturn("abc");
		when(mockMainController.getUser(anyString())).thenReturn(mockUser);
		when(mockUser.getPassword()).thenReturn("abc");
		doNothing().when(mockSession).setAttribute(anyString(), anyString());
		doNothing().when(mockMainController).close();
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testFs() {
		// Arrange
		String inputString = "aaaaa";
		// Act
		String outputString = testController.fs(inputString);
		// Assert
		assertEquals("Aaaaa", outputString);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_SettersExecuted_WhenPasswordOK() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getUser(anyString())).thenReturn(mockUser);
		when(mockUser.getPassword()).thenReturn("abc");
		// Act
		testController.doPost(mockRequest,mockResponse);
		// Assert
		verify(mockMainController).init();
		verify(mockRequest,atLeastOnce()).getParameter(anyString());
		verify(mockUser).setFirstName("Abc");
		verify(mockUser).setLastName("Abc");
		verify(mockUser).setHouseNo("Abc");
		verify(mockUser).setStreet("Abc");
		verify(mockUser).setTown("Abc");
		verify(mockUser).setPostcode("ABC");
		verify(mockUser).setCountry("ABC");
		verify(mockUser).setPhone("abc");
		verify(mockMainController).close();
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_WhenPasswordOK() throws ServletException, IOException {
		// Arrange
		when(mockMainController.getUser(anyString())).thenReturn(mockUser);
		when(mockUser.getPassword()).thenReturn("111");
		// Act
		testController.doPost(mockRequest,mockResponse);
		// Assert
		verify(mockSession).setAttribute("editMsg", "Update failed. Invalid password.");
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse_CatchException() throws ServletException, IOException{
		// Arrange
		when(mockMainController.getUser(anyString())).thenThrow(new NullPointerException());
		// Act
		testController.doPost(mockRequest,mockResponse);
		// Assert
		verify(mockResponse).sendRedirect("/fdmazon/errorpage.jsp");
		verify(mockMainController).close();
	}

}
