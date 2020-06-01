package com.fdmgroup.fdmazon.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	private Order order;

	@Before
	public void setUp() throws Exception {
		order = new Order("recipient", "shipHouseNo", "shipStreet", "shipTown", "shipPostcode", "shipCountry", "trackingCode");
	}

	@After
	public void tearDown() throws Exception {
		order = null;
	}

	@Test
	public void test_FieldConstructor_OrderObjectIsInitialised_ReturnNotNull() {
		// Arrange
		// Act
		// Assert
		assertNotNull(order);
	}

	@Test
	public void test_ToString_PrintOrder() {
		// Arrange
		// Act
		String aString = order.toString();
		// Assert
		assertNotNull(aString);
	}

	@Test
	public void test_GetOrderProductList_ReturnList_WhenCalled() {
		// Arrange
		List<OrderProduct>list = new ArrayList<OrderProduct>();
		order.setOrderProductList(list);
		// Act
		List<OrderProduct> outList = order.getOrderProductList();
		// Assert
		assertEquals(list,outList);
	}

	@Test
	public void test_SetOrderProductList_ReturnList_WhenSetToList() {
		// Arrange
		List<OrderProduct>list = new ArrayList<OrderProduct>();
		// Act
		order.setOrderProductList(list);
		// Assert
		assertEquals(list,order.getOrderProductList());
	}

	@Test
	public void test_AddOrderProduct_ReturnListSizeOne_WhenAddedAnOrderProduct() {
		// Arrange
		OrderProduct orderProduct = new OrderProduct();
		// Act
		order.addOrderProduct(orderProduct);
		// Assert
		assertEquals(1,order.getOrderProductList().size());
	}

	@Test
	public void test_RandomCharGenerator_ReturnStringLengthOfTen_WhenTenCharGenerated() {
		// Arrange
		// Act
		String str = order.randomCharGenerator(10);
		// Assert
		assertEquals(10,str.length());
	}

	@Test
	public void test_TrackingCodeGenerator_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		String str = order.trackingCodeGenerator();
		// Assert
		assertNotNull(str);		
	}

	@Test
	public void test_GetUser_ReturnUser_WhenCalled() {
		// Arrange
		User u1 = new User();
		order.setUser(u1);
		// Act
		User u2 = order.getUser();
		// Assert
		assertNotNull(u2);
	}

	@Test
	public void test_SetUser_ReturnUser_WhenSetToUser() {
		// Arrange
		User user = new User();
		// Act
		order.setUser(user);
		// Assert
		assertEquals(user, order.getUser());
	}

	@Test
	public void test_GetRecipient_ReturnRecipient_WhenCalled() {
		// Arrange
		// Act
		String str = order.getRecipient();
		// Assert
		assertEquals("recipient", str);
	}

	@Test
	public void test_SetRecipient_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setRecipient(str);
		// Assert
		assertEquals(str, order.getRecipient());
	}

	@Test
	public void test_GetShipHouseNo_ReturnShipHouseNo_WhenCalled() {
		// Arrange
		// Act
		String str = order.getShipHouseNo();
		// Assert
		assertEquals("shipHouseNo", str);
	}

	@Test
	public void test_GetOrderId_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		long id = order.getOrderId();
		// Assert
		assertNotNull(id);
	}

	@Test
	public void testSetShipHouseNo_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setShipHouseNo(str);
		// Assert
		assertEquals(str, order.getShipHouseNo());
	}

	@Test
	public void test_GetShipStreet_ReturnShipStreet_WhenCalled() {
		// Arrange
		// Act
		String str = order.getShipStreet();
		// Assert
		assertEquals("shipStreet", str);
	}

	@Test
	public void test_SetShipStreet_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setShipStreet(str);
		// Assert
		assertEquals(str, order.getShipStreet());
	}

	@Test
	public void test_GetShipTown_ReturnShipTown_WhenCalled() {
		// Arrange
		// Act
		String str = order.getShipTown();
		// Assert
		assertEquals("shipTown", str);

	}

	@Test
	public void test_SetShipTown_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setShipTown(str);
		// Assert
		assertEquals(str, order.getShipTown());
	}

	@Test
	public void test_GetShipPostcode_ReturnShipPostcode_WhenCalled() {
		// Arrange
		// Act
		String str = order.getShipPostcode();
		// Assert
		assertEquals("shipPostcode", str);
	}

	@Test
	public void test_SetShipPostcode_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setShipPostcode(str);
		// Assert
		assertEquals(str, order.getShipPostcode());
	}

	@Test
	public void test_GetShipCountry_ReturnShipCountry_WhenCalled() {
		// Arrange
		// Act
		String str = order.getShipCountry();
		// Assert
		assertEquals("shipCountry", str);

	}

	@Test
	public void test_SetShipCountry_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setShipCountry(str);
		// Assert
		assertEquals(str, order.getShipCountry());
	}

	@Test
	public void test_GetTrackingCode_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		String str = order.getTrackingCode();
		// Assert
		assertNotNull(str);
	}

	@Test
	public void test_SetTrackingCode_ReturnABC_WhenSetToABC() {
		// Arrange
		String str = "abc";
		// Act
		order.setTrackingCode(str);
		// Assert
		assertEquals(str, order.getTrackingCode());
	}

	@Test
	public void test_GetOrderedDateTime_ReturnNotNull_WhenCalled(){ 
		// Arrange
		// Act
		Date str = order.getOrderedDateTime();
		// Assert
		assertNotNull(str);
	}

	@Test
	public void test_SetOrderedDateTime_ReturnDate_WhenSetToDate() {
		// Arrange
		Date d = new Date();
		// Act
		order.setOrderedDateTime(d);
		// Assert
		assertEquals(d, order.getOrderedDateTime());
	}

	@Test
	public void test_GetPackedDateTime_ReturnNull_WhenCalled() {
		// Arrange
		// Act
		Date str = order.getPackedDateTime();
		// Assert
		assertEquals(null, str);
	}

	@Test
	public void test_SetPackedDateTime_ReturnDate_WhenSetToDate() {
		// Arrange
		Date d = new Date();
		// Act
		order.setPackedDateTime(d);
		// Assert
		assertEquals(d, order.getPackedDateTime());
	}

	@Test
	public void test_GetShippedDateTime_ReturnNull_WhenCalled() {
		// Arrange
		// Act
		Date str = order.getShippedDateTime();
		// Assert
		assertEquals(null, str);
	}

	@Test
	public void test_SetShippedDateTime_ReturnDate_WhenSetToDate() {
		// Arrange
		Date d = new Date();
		// Act
		order.setShippedDateTime(d);
		// Assert
		assertEquals(d, order.getShippedDateTime());
	}

	@Test
	public void test_GetCancelledDateTime_ReturnNull_WhenCalled() {
		// Arrange
		// Act
		Date str = order.getCancelledDateTime();
		// Assert
		assertEquals(null, str);
	}

	@Test
	public void test_SetCancelledDateTime_ReturnDate_WhenSetToDate() {
		// Arrange
		Date d = new Date();
		// Act
		order.setCancelledDateTime(d);
		// Assert
		assertEquals(d, order.getCancelledDateTime());
	}

	@Test
	public void test_GetReturnedDateTime_ReturnNull_WhenCalled() {
		// Arrange
		// Act
		Date str = order.getReturnedDateTime();
		// Assert
		assertEquals(null, str);
	}
	
	@Test
	public void test_SetReturnedDateTime_ReturnDate_WhenSetToDate() {
		// Arrange
		Date d = new Date();
		// Act
		order.setReturnedDateTime(d);
		// Assert
		assertEquals(d, order.getReturnedDateTime());
	}

}


