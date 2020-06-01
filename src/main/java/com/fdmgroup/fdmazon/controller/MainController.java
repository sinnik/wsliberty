package com.fdmgroup.fdmazon.controller;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.fdmazon.dao.OrderProductServicesImp;
import com.fdmgroup.fdmazon.dao.OrderServicesImp;
import com.fdmgroup.fdmazon.dao.ProductServicesImp;
import com.fdmgroup.fdmazon.dao.Services;
import com.fdmgroup.fdmazon.dao.Connection;
import com.fdmgroup.fdmazon.dao.UserServicesImp;
import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.OrderProduct;
import com.fdmgroup.fdmazon.model.Product;
import com.fdmgroup.fdmazon.model.User;

public class MainController {

	private Services services;
	private UserServicesImp userServicesImp;
	private ProductServicesImp productServicesImp;
	private OrderServicesImp orderServicesImp;
	private OrderProductServicesImp orderProductServicesImp;

	public MainController() {
	}

	public void init() {
		Connection.getEm();
	}

	public void close() {
		Connection.disconnect();
	}

	public void saveUser(User newUser) {
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		this.userServicesImp.save(newUser);
	}

	public void readUser(String email) {
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		User user = this.userServicesImp.read(email);
		System.out.println(user);
	}

	public User getUser(String email) {
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		User user = this.userServicesImp.read(email);
		return user;
	}

	public void updateUser(User newUser) {
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		this.userServicesImp.update(newUser);
	}

	public void deleteUser(String email) {
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		this.userServicesImp.delete(email);
	}

	public void listUsers() {
		List<User> userList = new ArrayList<User>();
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		userList = this.userServicesImp.readAll();
		for (User u : userList) {
			System.out.println(u);
		}
	}

	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		userList = this.userServicesImp.readAll();
		return userList;
	}

	public void saveProduct(Product newProduct) {
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		this.productServicesImp.save(newProduct);
	}

	public void readProduct(long productId) {
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		Product product = (Product) this.productServicesImp.read(productId);
		System.out.println(product);
	}

	public Product getProduct(long productId) {
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		Product product = (Product) this.productServicesImp.read(productId);
		return product;
	}

	public void updateProduct(long productId, Product newProduct) {
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		Product updatedProduct = (Product) this.productServicesImp.read(productId);
		updatedProduct.setCategory(newProduct.getCategory());
		updatedProduct.setProductBrand(newProduct.getProductBrand());
		updatedProduct.setProductCode(newProduct.getProductCode());
		updatedProduct.setProductDescription(newProduct.getProductDescription());
		updatedProduct.setProductImg(newProduct.getProductImg());
		updatedProduct.setProductName(newProduct.getProductName());
		updatedProduct.setProductPrice(newProduct.getProductPrice());
		updatedProduct.setStock(newProduct.getStock());
		this.productServicesImp.update(updatedProduct);
	}

	public void deleteProduct(long productId) {
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		this.productServicesImp.delete(productId);
	}

	public void listProducts() {
		List<Product> productList = new ArrayList<Product>();
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		productList = this.productServicesImp.readAll();
		for (Product p : productList) {
			System.out.println(p);
		}
	}

	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
		this.services = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services;
		productList = this.productServicesImp.readAll();
		return productList;
	}

	public void saveOrder(Order newOrder) {
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		this.orderServicesImp.save(newOrder);
	}

	public void readOrder(long orderId) {
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		Order order = (Order) this.orderServicesImp.read(orderId);
		System.out.println(order);
	}

	public Order getOrder(long orderId) {
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		Order order = (Order) this.orderServicesImp.read(orderId);
		return order;
	}

	public void updateOrder(long orderId, Order newOrder) {
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		Order order = (Order) this.orderServicesImp.read(orderId);
		order.setRecipient(newOrder.getRecipient());
		order.setShipCountry(newOrder.getShipCountry());
		order.setShipHouseNo(newOrder.getShipHouseNo());
		order.setShipPostcode(newOrder.getShipPostcode());
		order.setShipStreet(newOrder.getShipStreet());
		order.setShipTown(newOrder.getShipTown());
		order.setTrackingCode(newOrder.getTrackingCode());
		this.orderServicesImp.update(order);
	}

	public void deleteOrder(long orderId) {
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		this.orderServicesImp.delete(orderId);
	}

	public void listOrders() {
		List<Order> orderList = new ArrayList<Order>();
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		orderList = this.orderServicesImp.readAll();
		for (Order o : orderList) {
			System.out.println(o);
		}
	}

	public List<Order> getOrderList() {
		List<Order> orderList = new ArrayList<Order>();
		this.services = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services;
		orderList = this.orderServicesImp.readAll();
		return orderList;
	}
	
	
	
	
	
	
	
	public void saveOrderProduct(OrderProduct newOrderProduct) {
		this.services = new OrderProductServicesImp();
		this.orderProductServicesImp = (OrderProductServicesImp) this.services;
		this.orderProductServicesImp.save(newOrderProduct);
	}

	public void readOrderProduct(long orderId) {
		this.services = new OrderProductServicesImp();
		this.orderProductServicesImp = (OrderProductServicesImp) this.services;
		OrderProduct orderProduct = (OrderProduct) this.orderProductServicesImp.read(orderId);
		System.out.println(orderProduct);
	}

	public OrderProduct getOrderProduct(long orderId, long productId) {
		this.services = new OrderProductServicesImp();
		this.orderProductServicesImp = (OrderProductServicesImp) this.services;
		OrderProduct orderProduct = (OrderProduct) this.orderProductServicesImp.read(orderId);
		return orderProduct;
	}

}