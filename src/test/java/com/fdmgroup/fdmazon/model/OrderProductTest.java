package com.fdmgroup.fdmazon.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderProductTest {

	private OrderProduct orderProduct;
	
	@Before
	public void setUp() throws Exception {
	orderProduct = new OrderProduct();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_OrderProductConstructor_ReturnNotNull_WhenInstantiatedButNotInitialised() {
		// Arrange
		// Act
		// Assert
		assertNotNull(orderProduct);
	}
	
	@Test
	public void test_OrderProductConstructor_ReturnNotNull_WhenInstatiatedAndInitialised() {
		// Arrange
		// Act
		OrderProduct orderP = new OrderProduct(1);
		// Assert
		assertNotNull(orderProduct);
	}
	
	@Test
	public void test_SetOrderAndGetOrderMethods_ReturnOrderWhenOrderProductIsSetWithOrder() {
		// Arrange
		Order order = new Order();
		// Act
		orderProduct.setOrder(order);
		// Assert
		assertEquals(order, orderProduct.getOrder());
	}

	@Test
	public void test_SetProductAndGetProductMethods_ReturnOrderWhenOrderProductIsSetWithOrder() {
		// Arrange
		Product product = new Product();
		// Act
		orderProduct.setProduct(product);
		// Assert
		assertEquals(product,orderProduct.getProduct());
	}

	@Test
	public void test_SetAndGetQuantityMethod_ReturnOne_WhenSetToOne() {
		// Arrange
		// Act
		orderProduct.setQuantity(1);
		// Assert
		assertEquals(1, orderProduct.getQuantity());
	}

	@Test
	public void test_ToString_PrintOrder() {
		// Arrange
		// Act
		// Assert
		assertNotNull(orderProduct.toString());
	}
	
}
