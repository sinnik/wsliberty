package com.fdmgroup.fdmazon.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	private Product product;

	@Before
	public void setUp() throws Exception {
		product = new Product("productName", 1.00, "productCode", "productDescription", "productImg", "productBrand", "category", 1);
	}

	@After
	public void tearDown() throws Exception {
		product = null;
	}

	@Test
	public void test_GetOrderProductList_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		List<OrderProduct> list = product.getOrderProductList();
		// Assert
		assertNotNull(list);
	}

	@Test
	public void test_SetOrderProductList_ReturnList_WhenSetToList() {
		// Arrange
		List<OrderProduct> list = new ArrayList<OrderProduct>();
		// Act
		product.setOrderProductList(list);
		// Assert
		assertEquals(list, product.getOrderProductList());
	}

	@Test
	public void test_GetProductId_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		long id = product.getProductId();
		// Assert
		assertNotNull(id);
	}

	@Test
	public void test_SetProductId_ReturnFive_WhenSetFive() {
		// Arrange
		// Act
		product.setProductId(5L);
		// Assert
		assertEquals(5L, product.getProductId());
	}

	@Test
	public void test_GetProductName_ReturnProductName_WhenCalled() {
		// Arrange
		// Act
		String s = product.getProductName();
		// Assert
		assertEquals("productName", s);
	}

	@Test
	public void test_SetProductName_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		product.setProductName("abc");
		// Assert
		assertEquals("abc", product.getProductName());
	}

	@Test
	public void test_GetProductPrice_ReturnOne_WhenCalled() {
		// Arrange
		// Act
		double s = product.getProductPrice();
		// Assert
		assertEquals(1.00, s, 0.00);
	}

	@Test
	public void test_SetProductPrice_ReturnOneHundred_WhenSetToOneHundred() {
		// Arrange
		// Act
		product.setProductPrice(100.00d);
		// Assert
		assertEquals(100.00d, product.getProductPrice(), 0.00);
	}

	@Test
	public void test_GetProductCode_ReturnProductCode_WhenCalled() {
		// Arrange
		// Act
		String s = product.getProductCode();
		// Assert
		assertEquals("productCode", s);
	}

	@Test
	public void test_SetProductCode_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		product.setProductCode("abc");
		// Assert
		assertEquals("abc", product.getProductCode());
	}

	@Test
	public void test_GetProductDescription_ReturnProductDescription_WhenCalled() {
		// Arrange
		// Act
		String s = product.getProductDescription();
		// Assert
		assertEquals("productDescription", s);
	}

	@Test
	public void test_SetProductDescription_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		product.setProductDescription("abc");
		// Assert
		assertEquals("abc", product.getProductDescription());
	}

	@Test
	public void test_GetProductImg_ReturnProductImg_WhenCalled() {
		// Arrange
		// Act
		String s = product.getProductImg();
		// Assert
		assertEquals("productImg", s);
	}

	@Test
	public void test_SetProductImg_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		product.setProductImg("abc");
		// Assert
		assertEquals("abc", product.getProductImg());
	}

	@Test
	public void test_GetProductBrand_ReturnProductBrand_WhenCalled() {
		// Arrange
		// Act
		String s = product.getProductBrand();
		// Assert
		assertEquals("productBrand", s);
	}

	@Test
	public void test_SetProductBrand_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		product.setProductBrand("abc");
		// Assert
		assertEquals("abc", product.getProductBrand());
	}

	@Test
	public void test_GetCategory_ReturnCategory_WhenCalled() {
		// Arrange
		// Act
		String s = product.getCategory();
		// Assert
		assertEquals("category", s);
	}

	@Test
	public void test_SetCategory_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		product.setCategory("abc");
		// Assert
		assertEquals("abc", product.getCategory());
	}

	@Test
	public void test_GetStock_ReturnOne_WhenCalled() {
		// Arrange
		// Act
		int s = product.getStock();
		// Assert
		assertEquals(1, s);
	}

	@Test
	public void test_SetStock_ReturnFive_WhenSetToFive() {
		// Arrange
		// Act
		product.setStock(5);
		// Assert
		assertEquals(5, product.getStock());
		
	}

	@Test
	public void test_ToString_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		String s = product.toString();
		// Assert
		assertNotNull(s);
	}
}
