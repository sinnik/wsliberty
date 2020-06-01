package com.fdmgroup.fdmazon.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable{

	private static final long serialVersionUID = -4454365395185591409L;
	private long orderId;
	private long productId;
	
	public OrderProductId() {
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderProductId [orderId=" + orderId + ", productId=" + productId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductId other = (OrderProductId) obj;
		if (orderId != other.orderId)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	
	
	
}
