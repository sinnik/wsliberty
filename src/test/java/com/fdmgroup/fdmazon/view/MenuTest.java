package com.fdmgroup.fdmazon.view;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.controller.MainController;
import com.fdmgroup.fdmazon.dao.OrderProductServicesImp;
import com.fdmgroup.fdmazon.dao.OrderServicesImp;
import com.fdmgroup.fdmazon.dao.ProductServicesImp;
import com.fdmgroup.fdmazon.dao.Services;
import com.fdmgroup.fdmazon.dao.UserServicesImp;
import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.Product;
import com.fdmgroup.fdmazon.model.User;

public class MenuTest {
	private Menu mockMenu;
	@Mock
	private MainController mockMc;
	@Mock
	private Services mockServices;
	@Mock
	private UserServicesImp mockUserServicesImp;
	@Mock
	private OrderServicesImp mockOrderServicesImp;
	@Mock
	private ProductServicesImp mockProductServicesImp;
	@Mock
	private OrderProductServicesImp mockOrderProductServicesImp;
	@Mock
	private User mockUser;
	
	private Scanner scanner;
	private InputStream stdin;
	
	@Before
	public void setUp() throws Exception {
		stdin = System.in;
		MockitoAnnotations.initMocks(this);
		mockMenu = new Menu(mockMc);
		doNothing().when(mockMc).saveUser(mockUser);
	}

	@After
	public void tearDown() throws Exception {
		mockMenu = null;
		scanner.close();
		System.setIn(stdin);
	}

	// @Test
	// public void testInit() {
	// // Arrange
	// // Act
	// // Assert
	//
	// }

	@Test
	public void testMenu_UserDatabase_SaveUserMethodCalled() {
		// Arrange
		String data = "1" + System.getProperty("line.separator") 
				+ "1" + System.getProperty("line.separator") 
				+ "Mr" + System.getProperty("line.separator") 
				+ "FirstName" + System.getProperty("line.separator") 
				+ "LastName" + System.getProperty("line.separator") 
				+ "Email" + System.getProperty("line.separator") 
				+ "Password1" + System.getProperty("line.separator") 
				+ "1"+ System.getProperty("line.separator") 
				+ "Street" + System.getProperty("line.separator") 
				+ "Town" + System.getProperty("line.separator") 
				+ "Postcode" + System.getProperty("line.separator") 
				+ "Country" + System.getProperty("line.separator") 
				+ "123" + System.getProperty("line.separator") 
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).saveUser((User) anyObject());
	}
	
	@Test
	public void testMenu_UserDatabase_ReadUserMethodCalled() {
		// Arrange
		String data = "1" + System.getProperty("line.separator") 
				+ "2" + System.getProperty("line.separator") 
				+ "Email" + System.getProperty("line.separator") 
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).readUser(anyString());
	}

	@Test
	public void testMenu_UserDatabase_UpdateUserMethodCalled() {
		// Arrange
		String data = "1" + System.getProperty("line.separator") 
				+ "3" + System.getProperty("line.separator") 
				+ "Email" + System.getProperty("line.separator") 
				+ "Mr" + System.getProperty("line.separator") 
				+ "FirstName" + System.getProperty("line.separator") 
				+ "LastName" + System.getProperty("line.separator") 
				+ "Email" + System.getProperty("line.separator") 
				+ "Password1" + System.getProperty("line.separator") 
				+ "1"+ System.getProperty("line.separator") 
				+ "Street" + System.getProperty("line.separator") 
				+ "Town" + System.getProperty("line.separator") 
				+ "Postcode" + System.getProperty("line.separator") 
				+ "Country" + System.getProperty("line.separator") 
				+ "123" + System.getProperty("line.separator") 
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).updateUser((User) anyObject());
	}
	
	@Test
	public void testMenu_UserDatabase_DeleteUserMethodCalled() {
		// Arrange
		String data = "1" + System.getProperty("line.separator") 
				+ "4" + System.getProperty("line.separator") 
				+ "Email" + System.getProperty("line.separator") 
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).deleteUser(anyString());
	}	

	@Test
	public void testMenu_UserDatabase_ListUsersMethodCalled() {
		// Arrange
		String data = "1" + System.getProperty("line.separator") 
				+ "5" + System.getProperty("line.separator")  
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).listUsers();
	}	

	@Test
	public void testMenu_ProductDatabase_SaveProductMethodCalled() {
		// Arrange
		String data = "2" + System.getProperty("line.separator") 
				+ "1" + System.getProperty("line.separator") 
				+ "ProductName" + System.getProperty("line.separator") 
				+ "1.00" + System.getProperty("line.separator")
				+ "ProductCode" + System.getProperty("line.separator")
				+ "ProductDescription" + System.getProperty("line.separator")
				+ "ProductImageUrl" + System.getProperty("line.separator")
				+ "ProductBrand" + System.getProperty("line.separator")
				+ "ProductCategory" + System.getProperty("line.separator")
				+ "1" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).saveProduct((Product)anyObject());
	}	

	@Test
	public void testMenu_ProductDatabase_ReadProductMethodCalled() {
		// Arrange
		String data = "2" + System.getProperty("line.separator") 
				+ "2" + System.getProperty("line.separator")  
				+ "1" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).readProduct(anyLong());
	}	
	
	@Test
	public void testMenu_ProductDatabase_UpdateProductMethodCalled() {
		// Arrange
		String data = "2" + System.getProperty("line.separator") 
				+ "3" + System.getProperty("line.separator")
				+ "1" + System.getProperty("line.separator")
				+ "ProductName" + System.getProperty("line.separator") 
				+ "1.00" + System.getProperty("line.separator")
				+ "ProductCode" + System.getProperty("line.separator")
				+ "ProductDescription" + System.getProperty("line.separator")
				+ "ProductImageUrl" + System.getProperty("line.separator")
				+ "ProductBrand" + System.getProperty("line.separator")
				+ "ProductCategory" + System.getProperty("line.separator")
				+ "1" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).updateProduct(anyLong(),(Product)anyObject());
	}	

	@Test
	public void testMenu_ProductDatabase_DeleteProductMethodCalled() {
		// Arrange
		String data = "2" + System.getProperty("line.separator") 
				+ "4" + System.getProperty("line.separator")  
				+ "1" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).deleteProduct(anyLong());
	}	

	@Test
	public void testMenu_ProductDatabase_ListProductsMethodCalled() {
		// Arrange
		String data = "2" + System.getProperty("line.separator") 
				+ "5" + System.getProperty("line.separator")  
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).listProducts();
	}	

	@Test
	public void testMenu_OrderDatabase_SaveOrderMethodCalled() {
		// Arrange
		String data = "3" + System.getProperty("line.separator") 
				+ "1" + System.getProperty("line.separator")
				+ "recipient" + System.getProperty("line.separator")
				+ "shipHouseNo" + System.getProperty("line.separator") 
				+ "shipStreet" + System.getProperty("line.separator")
				+ "shipTown" + System.getProperty("line.separator")
				+ "shipPostcode" + System.getProperty("line.separator")
				+ "shipCountry" + System.getProperty("line.separator")
				+ "trackingCode" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).saveOrder((Order)anyObject());
	}	

	@Test
	public void testMenu_OrderDatabase_ReadOrderMethodCalled() {
		// Arrange
		String data = "3" + System.getProperty("line.separator") 
				+ "2" + System.getProperty("line.separator")
				+ "1" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).readOrder(anyLong());
	}	
	
	@Test
	public void testMenu_OrderDatabase_UpdateOrderMethodCalled() {
		// Arrange
		String data = "3" + System.getProperty("line.separator") 
				+ "3" + System.getProperty("line.separator")
				+ "1" + System.getProperty("line.separator")
				+ "recipient" + System.getProperty("line.separator")
				+ "shipHouseNo" + System.getProperty("line.separator") 
				+ "shipStreet" + System.getProperty("line.separator")
				+ "shipTown" + System.getProperty("line.separator")
				+ "shipPostcode" + System.getProperty("line.separator")
				+ "shipCountry" + System.getProperty("line.separator")
				+ "trackingCode" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).updateOrder(anyLong(),(Order)anyObject());
	}	

	@Test
	public void testMenu_OrderDatabase_DeleteOrderMethodCalled() {
		// Arrange
		String data = "3" + System.getProperty("line.separator") 
				+ "4" + System.getProperty("line.separator")
				+ "1" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).deleteOrder(anyLong());
	}	
	
	@Test
	public void testMenu_OrderDatabase_ListOrdersMethodCalled() {
		// Arrange
		String data = "3" + System.getProperty("line.separator") 
				+ "5" + System.getProperty("line.separator")
				+ "0" + System.getProperty("line.separator") 
				+ "00" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		// Act
		mockMenu.menu();
		if (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		// Assert
		verify(mockMc).listOrders();
	}	
	
}
