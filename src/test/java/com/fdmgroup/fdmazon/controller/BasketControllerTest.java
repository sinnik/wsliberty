package com.fdmgroup.fdmazon.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

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
import com.fdmgroup.fdmazon.model.OrderProduct;
import com.fdmgroup.fdmazon.model.Product;

public class BasketControllerTest {
	private BasketController testController;
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
	private OrderProduct mockOrderProduct;
	@Mock
	private List<OrderProduct> mockOrderProductList;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testController = new BasketController(mockMainController);
		mockOrderProduct = new OrderProduct();
		mockOrderProduct.setOrder(mockOrder);
		mockOrderProduct.setProduct(mockProduct);
		mockOrderProduct.setQuantity(1);
		mockOrder.addOrderProduct(mockOrderProduct);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSession.getAttribute("basket")).thenReturn(mockOrder);
		doNothing().when(mockSession).setAttribute(anyString(), anyString());
		when(mockOrder.getOrderProductList()).thenReturn(mockOrderProductList);
	}

	@After
	public void tearDown() throws Exception {
		testController = null;
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// Arrange
		when(mockRequest.getParameter(anyString())).thenReturn("");
		// Act
//		testController.doPost(mockRequest, mockResponse);
		// Assert
//		assertEquals(mockSession,mockRequest.getSession());
//		assertEquals(mockOrder, mockSession.getAttribute("basket"));
//		verify(mockMainController).init();
//		verify(mockMainController).close();
//		verify(mockSession,atLeastOnce()).getAttribute(anyString());
	}
}
