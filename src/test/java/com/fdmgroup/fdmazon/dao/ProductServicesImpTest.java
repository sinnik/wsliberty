package com.fdmgroup.fdmazon.dao;

import static org.junit.Assert.assertSame;
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

import com.fdmgroup.fdmazon.model.Product;

public class ProductServicesImpTest {

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
	public Product mockProduct;
	@Mock
	public List<Product> mockProductList;
	
	private ProductServicesImp productServicesImp;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		productServicesImp = new ProductServicesImp(mockEntityManager);
		when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
		when(mockEntityManager.createQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(mockProduct);
		when(mockQuery.getResultList()).thenReturn(mockProductList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		// Arrange
		
		// Act
		productServicesImp.save(mockProduct);
		// Assert
		verify(mockEntityTransaction).begin();
		verify(mockEntityManager).persist(mockProduct);
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void testRead() {
		// Arrange
		
		// Act
		productServicesImp.read(1L);
		// Assert
		verify(mockEntityManager).createQuery(anyString());
		verify(mockQuery).getSingleResult();
		assertSame(mockProduct, productServicesImp.read(1L));
	}

	@Test
	public void testReadAll() {
		// Arrange
		
		// Act
		productServicesImp.readAll();
		// Assert
		verify(mockQuery).getResultList();
		assertSame(mockProductList,productServicesImp.readAll());
	}

	@Test
	public void testUpdate() {
		// Arrange
		// Act
		productServicesImp.update(mockProduct);
		// Assert
		verify(mockEntityTransaction).begin();
		verify(mockEntityManager).persist(mockProduct);
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void testDelete() {
		// Arrange
		// Act
		productServicesImp.delete(anyString());
		productServicesImp.delete(1L);
		// Assert
		verify(mockEntityTransaction).begin();
		verify(mockEntityManager).createQuery(anyString());
		verify(mockQuery).getSingleResult();
		verify(mockEntityManager).remove(mockProduct);
		verify(mockEntityTransaction).commit();
	}
}
