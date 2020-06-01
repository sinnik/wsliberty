package com.fdmgroup.fdmazon.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fdmazon.model.User;

public class UserTest {
	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User("userTitle", "firstName", "lastName", "email", "password", "houseNo", "street", "town", "postcode", "country", "phone");
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void test_GetUserTitle_ReturnUserTitle_WhenCalled() {
		// Arrange

		// Act
		String s = user.getUserTitle();
		// Assert
		assertEquals("userTitle",s);
	}

	@Test
	public void test_GetUserId_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		long s = user.getUserId();
		// Assert
		assertNotNull(s);
	}

	@Test
	public void test_SetUserTitle_ReturnMr_WhenSetToMr() {
		// Arrange
		// Act
		user.setUserTitle("Mr");
		// Assert
		assertEquals("Mr", user.getUserTitle());
	}

	@Test
	public void test_GetFirstName_ReturnFirstName_WhenCalled() {
		// Arrange
		// Act
		String s = user.getFirstName();
		// Assert
		assertEquals("firstName",s);
	}

	@Test
	public void test_SetFirstName_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setFirstName("abc");
		// Assert
		assertEquals("abc", user.getFirstName());
	}

	@Test
	public void test_GetLastName_ReturnLastName_WhenCalled() {
		// Arrange
		// Act
		String s = user.getLastName();
		// Assert
		assertEquals("lastName",s);
	}

	@Test
	public void test_SetLastName_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setLastName("abc");
		// Assert
		assertEquals("abc", user.getLastName());
	}

	@Test
	public void test_GetEmail_ReturnEmail_WhenCalled() {
		// Arrange
		// Act
		String s = user.getEmail();
		// Assert
		assertEquals("email",s);
	}

	@Test
	public void test_SetEmail_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setEmail("abc");
		// Assert
		assertEquals("abc", user.getEmail());
	}

	@Test
	public void test_GetPassword_ReturnPassword_WhenCalled() {
		// Arrange
		// Act
		String s = user.getPassword();
		// Assert
		assertEquals("password",s);
	}

	@Test
	public void test_SetPassword_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setPassword("abc");
		// Assert
		assertEquals("abc", user.getPassword());
	}

	@Test
	public void test_GetHouseNo_ReturnHouseNo_WhenCalled() {
		// Arrange
		// Act
		String s = user.getHouseNo();
		// Assert
		assertEquals("houseNo",s);
	}

	@Test
	public void testSetHouseNo_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setHouseNo("abc");
		// Assert
		assertEquals("abc", user.getHouseNo());
	}

	@Test
	public void test_GetStreet_ReturnStreet_WhenCalled() {
		// Arrange
		// Act
		String s = user.getStreet();
		// Assert
		assertEquals("street",s);
	}

	@Test
	public void testSetStreet_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setStreet("abc");
		// Assert
		assertEquals("abc", user.getStreet());	}

	@Test
	public void test_GetTown_ReturnTown_WhenCalled() {
		// Arrange
		// Act
		String s = user.getTown();
		// Assert
		assertEquals("town",s);
	}

	@Test
	public void testSetTown_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setTown("abc");
		// Assert
		assertEquals("abc", user.getTown());	}

	@Test
	public void test_GetPostcode_ReturnPostcode_WhenCalled() {
		// Arrange
		// Act
		String s = user.getPostcode();
		// Assert
		assertEquals("postcode",s);
	}

	@Test
	public void testSetPostcode_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setPostcode("abc");
		// Assert
		assertEquals("abc", user.getPostcode());	}

	@Test
	public void test_GetCountry_ReturnCountry_WhenCalled() {
		// Arrange
		// Act
		String s = user.getCountry();
		// Assert
		assertEquals("country",s);
	}

	@Test
	public void testSetCountry_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setCountry("abc");
		// Assert
		assertEquals("abc", user.getCountry());	}

	@Test
	public void test_GetPhone_ReturnPhone_WhenCalled() {
		// Arrange
		// Act
		String s = user.getPhone();
		// Assert
		assertEquals("phone",s);
	}

	@Test
	public void test_SetPhone_ReturnABC_WhenSetToABC() {
		// Arrange
		// Act
		user.setPhone("abc");
		// Assert
		assertEquals("abc", user.getPhone());	}

	@Test
	public void test_GetRegisteredDate_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		Date s = user.getRegisteredDate();
		// Assert
		assertNotNull(s);
	}

	@Test
	public void test_SetRegisteredDate_ReturnNewDate_WhenSetToNewDate() {
		// Arrange
		Date newDate = new Date();
		// Act
		user.setRegisteredDate(newDate);
		// Assert
		assertEquals(newDate, user.getRegisteredDate());	}

	@Test
	public void test_GetBalance_ReturnZero_WhenCalled() {
		// Arrange
		// Act
		double s = user.getBalance();
		// Assert
		assertEquals(0, s, 0.00);
	}

	@Test
	public void test_SetBalance_ReturnOneHundred_WhenSetToOneHundred() {
		// Arrange
		// Act
		user.setBalance(100.00d);
		// Assert
		assertEquals(100.00d, user.getBalance(),0.00);
	}
	
	
	@Test
	public void test_ToString_ReturnNotNull_WhenCalled() {
		// Arrange
		// Act
		String someString = user.toString();
		// Assert
		assertNotNull(someString);
	}
}
