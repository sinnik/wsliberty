package com.fdmgroup.fdmazon.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public Connection() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("default");
			em = emf.createEntityManager();
		}
	}

	public static EntityManager getEm() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("default");
			em = emf.createEntityManager();
		}
		return em;
	}

	public static void disconnect() {
		if (em != null || emf != null) {
			em.close();
			em = null;
			emf.close();
			emf = null;
		}
	}
}
