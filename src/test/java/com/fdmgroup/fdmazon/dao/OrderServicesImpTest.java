package com.fdmgroup.fdmazon.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.fdmazon.model.Order;

public class OrderServicesImpTest {

	@Mock
	private Connection mockServicesManager;
	@Mock
	private EntityManagerFactory mockEntityManagerFactory;
	@Mock
	private EntityManager mockEntityManager;
	@Mock
	private Transaction mockTransaction;
	@Mock
	private Query mockQuery;
	@Mock
	private EntityTransaction mockEntityTransaction;
	@Mock
	public Order mockOrder;
	@Mock
	public List<Order> mockOrderList;
	
	public OrderServicesImp orderServicesImp;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		orderServicesImp = new OrderServicesImp(mockEntityManager);
		when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
		when(mockEntityManager.createQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(mockOrder);
		when(mockQuery.getResultList()).thenReturn(mockOrderList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_Save_EntityTransactionBeginExecuted_WhenCalled() {
		// Arrange
		
		// Act
		orderServicesImp.save(mockOrder);
		// Assert
		verify(mockEntityTransaction).begin();
	}

	@Test
	public void test_Save_EntityManagerPersistExecuted_WhenCalled() {
		// Arrange
		
		// Act
		orderServicesImp.save(mockOrder);
		// Assert
		verify(mockEntityManager).persist(mockOrder);
	}

	@Test
	public void test_Save_EntityTransactionCommitExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.save(mockOrder);
		// Assert
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void test_Read_EntityManagerCreateQueryExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.read(1L);
		// Assert
		verify(mockEntityManager).createQuery(anyString());
	}

	@Test
	public void test_Read_QueryGetSingleResultExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.read(1L);
		// Assert
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void test_Read_ReturnMockOrder_WhenCalled() {
		// Arrange
		// Act
		Order o = orderServicesImp.read(1L);
		// Assert
		assertSame(mockOrder, o);
	}

	@Test
	public void test_ReadAll_QueryGetResultListExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.readAll();
		// Assert
		verify(mockQuery).getResultList();
	}

	@Test
	public void test_ReadAll_ReturnMockOrderList_WhenCalled() {
		// Arrange
		// Act
		List<Order> orderList = orderServicesImp.readAll();
		// Assert
		assertSame(mockOrderList,orderList);

	}

	@Test
	public void test_Update_GetTransactionBeginExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.update(mockOrder);
		// Assert
		verify(mockEntityTransaction).begin();
	}

	@Test
	public void test_Update_GetTransactionCommitExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.update(mockOrder);
		// Assert
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void test_Update_EntityManagerPersistExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.update(mockOrder);
		// Assert
		verify(mockEntityManager).persist(mockOrder);
	}
	
	@Test
	public void test_Delete_GetTransactionBeginExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.delete(1L);
		// Assert
		verify(mockEntityTransaction).begin();
	}

	@Test
	public void test_Delete_CreateQueryExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.delete(1L);
		// Assert
		verify(mockEntityManager).createQuery(anyString());
	}

	@Test
	public void test_Delete_QueryGetSingleResultExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.delete(1L);
		// Assert
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void test_Delete_ReturnMockOrder_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.delete(1L);
		// Assert
		assertSame(mockOrder, orderServicesImp.read(1L));
	}

	@Test
	public void test_Delete_RemoveMethodExecuted_WhenCalled() {
		// Arrange
		// Act
		orderServicesImp.delete(1L);
		// Assert
		verify(mockEntityManager).remove(mockOrder);
	}

}
