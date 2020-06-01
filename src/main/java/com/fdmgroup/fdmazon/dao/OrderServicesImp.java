package com.fdmgroup.fdmazon.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.fdmazon.model.Order;

public class OrderServicesImp implements Services {

	private EntityManager em;
	
	public OrderServicesImp() {
		this.em = Connection.getEm();
	}
	
	public OrderServicesImp(EntityManager em){
		this.em = em;
	}
	
	public void save(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public Order read(Object orderId) {
		Order orderFound = new Order();
		try {
			Query query = em.createQuery("FROM Order AS order WHERE order.orderId=?");
			query.setParameter(0, (Long)orderId);
			orderFound = (Order) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Failed to read order.");
		}
		return orderFound;
	}
	
	public List<Order> readAll() {
		List<Order> orderList = new ArrayList<Order>();
		try {
			Query query = em.createQuery("FROM Order");
			orderList = (List<Order>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Failed to read orders.");
		}
		return orderList;
	}

	public void update(Object object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public void delete(Object orderId) {
		Order orderFound = new Order();
		try {
			em.getTransaction().begin();
			orderFound=(Order)read((Long)orderId);
			em.remove(orderFound);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Order not found.");
		}
	}
}
