package com.fdmgroup.fdmazon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.fdmazon.model.User;

public class UserServicesImp implements Services {

	private EntityManager em;

	public UserServicesImp() {
		this.em = Connection.getEm();
	}

	public UserServicesImp(EntityManager em) {
		this.em = em;
	}

	public void save(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public User read(Object email) {
		User userFound = new User();
		Query query = em.createQuery("FROM User AS user WHERE user.email=?");
		query.setParameter(0, (String) email);
		userFound = (User) query.getSingleResult();
		return userFound;
	}

	public List<User> readAll() {
		List<User> userList = new ArrayList<User>();
		try {
			Query query = em.createQuery("FROM User");
			userList = (List<User>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Failed to read all records.");
		}
		return userList;
	}

	public void update(Object user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public void delete(Object email) {
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("FROM User AS user WHERE user.email=?");
			query.setParameter(0, (String) email);
			User userFound = (User) query.getSingleResult();
			em.remove(userFound);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("User not found.");
		}
	}
}
