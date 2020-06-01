package com.fdmgroup.fdmazon.controller;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.dao.OrderServicesImp;
import com.fdmgroup.fdmazon.dao.ProductServicesImp;
import com.fdmgroup.fdmazon.dao.Connection;
import com.fdmgroup.fdmazon.dao.UserServicesImp;
import com.fdmgroup.fdmazon.model.User;

public class MainControllerTest {
	private MainController mc;

	@Mock
	private UserServicesImp mockUserServicesImp;
	@Mock
	private ProductServicesImp mockProductServicesImp;
	@Mock
	private OrderServicesImp mockOrderServicesImp;
	@Mock
	private User mockUser;
	@Mock
	private Connection mocksm;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		//when(mocksm.getUserService()).thenReturn(mockUserServicesImp);
	}

	@After
	public void tearDown() throws Exception {
	}



//	@Test
//	public void testSaveUser() {
//		mc.saveUser(mockUser);
//	}
//
//	@Test
//	public void testReadUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testListUsers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetUserList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testReadProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testListProducts() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetProductList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveOrder() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testReadOrder() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetOrder() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateOrder() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteOrder() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testListOrders() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetOrderList() {
//		fail("Not yet implemented");
//	}
//
}
