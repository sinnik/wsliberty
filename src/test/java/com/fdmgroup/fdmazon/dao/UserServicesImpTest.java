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

import com.fdmgroup.fdmazon.model.User;

public class UserServicesImpTest {

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
	public User mockUser;
	@Mock
	public List<User> mockUserList;
	
	private UserServicesImp userServicesImp;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		userServicesImp = new UserServicesImp(mockEntityManager);
		when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
		when(mockEntityManager.createQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(mockUser);
		when(mockQuery.getResultList()).thenReturn(mockUserList);
	}

	@After
	public void tearDown() throws Exception {
		userServicesImp = null;
	}

	@Test
	public void testSave_EntityTransactionBeginExecuted_WhenCalled() {
		// Arrange
		// Act
		userServicesImp.save(mockUser);
		// Assert
		verify(mockEntityTransaction).begin();
	}

	@Test
	public void testSave_EntityTransactionCommitExecuted_WhenCalled() {
		// Arrange
		
		// Act
		userServicesImp.save(mockUser);
		// Assert
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void testSave_EntityManagerPersistExecuted_WhenCalled() {
		// Arrange
		
		// Act
		userServicesImp.save(mockUser);
		// Assert
		verify(mockEntityManager).persist(mockUser);
	}

	@Test
	public void testRead_EntityManagerCreateQueryExecuted_WhenCalled() {
		// Arrange
		
		// Act
		userServicesImp.read(mockUser.getEmail());
		// Assert
		verify(mockEntityManager).createQuery(anyString());
	}

	@Test
	public void testReadAll_QueryGetResultListExecuted_AndReturnedSameObject() {
		// Arrange
		
		// Act
		userServicesImp.readAll();
		// Assert
		verify(mockQuery).getResultList();
	}

	@Test
	public void testUpdate_EntityTransactionBeginExecuted_WhenCalled() {
		// Arrange
		// Act
		userServicesImp.update(mockUser);
		// Assert
		
		verify(mockEntityTransaction).begin();
	}

	@Test
	public void testUpdate_EntityTransactionCommitExecuted_WhenCalled() {
		// Arrange
		// Act
		userServicesImp.update(mockUser);
		// Assert
		verify(mockEntityTransaction).commit();
	}

	@Test
	public void testUpdate_EntityManagerPersistExecuted_WhenCalled() {
		// Arrange
		// Act
		userServicesImp.update(mockUser);
		// Assert
		verify(mockEntityManager).persist(mockUser);
	}

	@Test
	public void testDelete_WhenGivenMockUserEmail() {
		// Arrange
		// Act
		userServicesImp.delete(mockUser.getEmail());
		// Assert
		verify(mockEntityTransaction).begin();
		verify(mockEntityManager).createQuery(anyString());
		verify(mockQuery).getSingleResult();
		assertSame(mockUser, userServicesImp.read(anyString()));
		verify(mockEntityManager).remove(mockUser);
		verify(mockEntityTransaction).commit();
	}
	
	@Test
	public void testDelete_EntityTransactionExecuted_WhenCalled() {
		// Arrange
		// Act
		userServicesImp.delete(mockUser.getEmail());
		// Assert
		verify(mockEntityTransaction).begin();
		verify(mockEntityManager).createQuery(anyString());
		verify(mockQuery).getSingleResult();
		assertSame(mockUser, userServicesImp.read(anyString()));
		verify(mockEntityManager).remove(mockUser);
		verify(mockEntityTransaction).commit();
	}
	
	@Test
	public void testDelete_CatchException_WhenNoObjectFound() {
		// Arrange
		// Act
		userServicesImp.delete(anyString());
		// Assert
		
	}

}
