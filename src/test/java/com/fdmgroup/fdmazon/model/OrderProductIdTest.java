package com.fdmgroup.fdmazon.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderProductIdTest {

	private OrderProductId orderProductId;
	
	@Before
	public void setUp() throws Exception {
		orderProductId = new OrderProductId();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_SetOrderIdTo1L_Return1L_WhenGetOrderIdCalled() {
		// Arrange
		// Act
		orderProductId.setOrderId(1L);
		// Assert
		assertEquals(1L, orderProductId.getOrderId());
	}

	@Test
	public void test_SetProductIdTo1L_Return1L_WhenGetProductIdCalled() {
		// Arrange
		// Act
		orderProductId.setProductId(1L);
		// Assert
		assertEquals(1L,orderProductId.getProductId());
	}

	@Test
	public void testToString() {
		// Arrange
		// Act
		// Assert
		assertNotNull(orderProductId.toString());
	}
	
	@Test
	public void testHashCode() {
		// Arrange
		// Act
		// Assert
	}

	@Test
	public void testEqualsObject() {
		// Arrange
		// Act
		// Assert
	}
}
