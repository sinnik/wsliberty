package com.fdmgroup.fdmazon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.fdmazon.model.OrderProduct;

public class OrderProductServicesImp implements Services {

	private EntityManager em;

	 public OrderProductServicesImp() {
		 this.em = Connection.getEm();
	 }
	
	public OrderProductServicesImp(EntityManager mockEm) {
		this.em = mockEm;
	}

	public void save(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public List<OrderProduct> read(Long orderId) {
		List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
		try {
			Query query = em.createQuery("FROM OrderProduct AS orderProduct WHERE orderProduct.orderId=?");
			query.setParameter(0, (Long) orderId);
			orderProductList = (List<OrderProduct>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Failed to read OrderProducts by orderId.");
		}
		return orderProductList;
	}

	public List<OrderProduct> readAll() {
		List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
		try {
		Query query = em.createQuery("FROM OrderProduct");
		orderProductList = (List<OrderProduct>) query.getResultList();
		} catch (Exception e) {
		System.out.println("Failed to read orderProducts.");
		}
		return orderProductList;
	}

	public void update(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public void delete(Object orderProductId) {
		OrderProduct orderProduct = new OrderProduct();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("FROM OrderProduct AS orderProduct WHERE orderProduct.orderproductId=?");
			query.setParameter(0, (Long) orderProductId);
			orderProduct = (OrderProduct) query.getSingleResult();
			em.remove(orderProduct);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("OrderProduct not found.");
		}
	}

	public Object read(Object object) {
		return null;
	}
}
