package com.fdmgroup.fdmazon.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bhh_2orderproduct")
public class OrderProduct {

	@EmbeddedId
	private OrderProductId orderProductId = new OrderProductId();
	
	@Column(name="quantity")
	private int quantity;

	@MapsId("orderId")
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "orderId")
	private Order order;

	@MapsId("productId")
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "productId")
	private Product product;

	public OrderProduct() {
	}
	
	public OrderProduct(int quantity) {
		super();
		this.quantity = quantity;
	}

	public OrderProductId getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(OrderProductId orderProductId) {
		this.orderProductId.setOrderId(order.getOrderId());
		this.orderProductId.setProductId(product.getProductId());
		//this.orderProductId = orderProductId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderProduct [quantity=" + quantity + ", order=" + order + ", product=" + product + "]";
	}

	
}