package com.fdmgroup.fdmazon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.fdmazon.model.Product;

public class ProductServicesImp implements Services {
	private EntityManager em;

	 public ProductServicesImp() {
	 this.em = Connection.getEm();
	 }

	public ProductServicesImp(EntityManager mockEm) {
		this.em = mockEm;
	}

	public void save(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public Product read(Object productId) {
		Product productFound = new Product();
		Query query = em.createQuery("FROM Product AS product WHERE product.productId=?");
		query.setParameter(0, (Long) productId);
		productFound = (Product) query.getSingleResult();
		return productFound;
	}

	public List<Product> readAll() {
		List<Product> productList = new ArrayList<Product>();
		try {
			Query query = em.createQuery("FROM Product");
			productList = (List<Product>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Failed to read products.");
		}
		return productList;
	}

	public void update(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public void delete(Object productId) {
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("FROM Product AS product WHERE product.productId=?");
			query.setParameter(0, (Long) productId);
			Product productFound = (Product) query.getSingleResult();
			em.remove(productFound);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Product not found.");
		}
	}
}
