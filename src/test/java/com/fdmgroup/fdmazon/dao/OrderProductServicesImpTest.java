package com.fdmgroup.fdmazon.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

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

import com.fdmgroup.fdmazon.model.OrderProduct;

public class OrderProductServicesImpTest {

	@Mock
	private Connection mockServicesManager;
	@Mock
	private EntityManager mockEntityManager;
	@Mock
	private Query mockQuery;
	@Mock
	private EntityTransaction mockEntityTransaction;
	@Mock
	private Transaction mockTransaction;
	@Mock
	public OrderProduct mockOrderProduct;
	@Mock
	public List<OrderProduct> mockOrderProductList;
	
	public OrderProductServicesImp orderProductServicesImp;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		orderProductServicesImp = new OrderProductServicesImp(mockEntityManager);
		when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
		when(mockEntityManager.createQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(mockOrderProduct);
		when(mockQuery.getResultList()).thenReturn(mockOrderProductList);
	}

	@After
	public void tearDown() throws Exception {
		orderProductServicesImp = null;
	}

	@Test
	public void test_Save_VerifyTransactionUsedTwice_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.save(mockOrderProduct);
		// Assert
		verify(mockEntityManager,atLeastOnce()).getTransaction();
	}
	
	@Test
	public void test_Save_VerifyEntityManagerPersistUsed_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.save(mockOrderProduct);
		// Assert
		verify(mockEntityManager).persist(mockOrderProduct);
	}

	@Test
	public void test_Read_VerifyEntityManagerCreateQueryUsed_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.read(1L);
		// Assert
		verify(mockEntityManager).createQuery(anyString());
	}

	@Test
	public void test_Read_VerifyMockQueryGetResultList_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.read(1L);
		// Assert
		verify(mockQuery).getResultList();
	}
	
	@Test
	public void test_ReadAll_EntityManagerCreateQueryExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.readAll();
		// Assert
		verify(mockEntityManager).createQuery(anyString());
	}

	@Test
	public void test_ReadAll_QueryGetResultListExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.readAll();
		// Assert
		verify(mockQuery).getResultList();
	}

	@Test
	public void test_ReadAll_ReturnMockOrderProductList_WhenCalled() {
		// Arrange
		// Act
		List<OrderProduct> list = orderProductServicesImp.readAll();
		// Assert
		assertEquals(mockOrderProductList,list);
	}

	@Test
	public void test_Update_EntityTransactionBeginExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.update(mockOrderProduct);
		// Assert
		verify(mockEntityTransaction).begin();
	}

	@Test
	public void test_Update_EntityManagerPersistExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.update(mockOrderProduct);
		// Assert
		verify(mockEntityManager).persist(mockOrderProduct);
	}

	@Test
	public void test_Update_EntityManagerGetTransactionExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.update(mockOrderProduct);
		// Assert
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void testDelete_EntityTransactionExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.delete(mockOrderProduct.getOrderProductId());
		// Assert
		verify(mockEntityTransaction).begin();
	}	
	
	@Test
	public void testDelete_EntityManagerCreateQueryExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.delete(mockOrderProduct.getOrderProductId());
		// Assert
		verify(mockEntityManager).createQuery(anyString());
	}	

	@Test
	public void test_Delete_QueryGetSingleResultExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.delete(mockOrderProduct.getOrderProductId());
		// Assert
		verify(mockQuery).getSingleResult();
	}	

	@Test
	public void test_Delete_EntityTransactionExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.delete(mockOrderProduct.getOrderProductId());
		// Assert
		verify(mockEntityManager).remove(mockOrderProduct);
	}	

	@Test
	public void test_Delete_EntityTransactionCommitExecuted_WhenCalled() {
		// Arrange
		// Act
		orderProductServicesImp.delete(mockOrderProduct.getOrderProductId());
		// Assert
		verify(mockEntityTransaction).commit();
	}	
	
	@Test
	public void testReadObject_ReturnNull(){
		// Arrange
		// Act
		// Assert
		assertNull(orderProductServicesImp.read("122"));
	}
	
}
