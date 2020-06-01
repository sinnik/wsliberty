package com.fdmgroup.fdmazon.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mock;

import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.User;

public class OrderHistoryControllerTest {
	
	private OrderHistoryController testController;
	@Mock 
	private HttpServletRequest mockRequest;
	@Mock 
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;
	@Mock
	private MainController mockMainController;
	@Mock
	private List<Order> mockOrderList;
	@Mock
	private Order mockOrder;
	@Mock
	private User mockUser;
	@Mock
	private RequestDispatcher mockRequestDispatcher;
		
//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		testController = new OrderHistoryController(mockMainController);
//		when(mockRequest.getSession()).thenReturn(mockSession);
//		doNothing().when(mockMainController).init();
//		when(mockMainController.getOrderList()).thenReturn(mockOrderList);
//		doNothing().when(mockMainController).close();
//		when(mockOrder.getUser().getUserId()).thenReturn(1L);
//		when(mockSession.getAttribute("ssID")).thenReturn("1");
//		when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
//		
//		mockOrder = new Order("a","a","a","a","a","a","a");
//		
//		when(mockUser.getUserId()).thenReturn(1L);
//		mockOrder.setUser(mockUser);
//		mockOrderList.add(mockOrder);
//		when(mockMainController.getOrderList()).thenReturn(mockOrderList);
//		doNothing().when(mockRequest).setAttribute(anyString(), anyString());
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		testController = null;
//	}
//	
//	@Test
//	public void testDoGetHttpServletRequestHttpServletResponse_RequestSetAttributeExecuted() throws ServletException, IOException {
//		// Arrange
//		// Act
//		testController.doGet(mockRequest, mockResponse);
//		// Assert
//		verify(mockRequest).getRequestDispatcher(anyString());
//		
//		
//	}

}
