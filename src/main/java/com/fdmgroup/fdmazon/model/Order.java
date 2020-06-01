package com.fdmgroup.fdmazon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bhh_2order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId", unique = true, nullable = false)
	private long orderId;
	@Column(name = "recipient")
	private String recipient;
	@Column(name = "shipHouseNo")
	private String shipHouseNo;
	@Column(name = "shipStreet")
	private String shipStreet;
	@Column(name = "shipTown")
	private String shipTown;
	@Column(name = "shipPostcode")
	private String shipPostcode;
	@Column(name = "shipCountry")
	private String shipCountry;
	@Column(name = "trackingCode")
	private String trackingCode;
	@Column(name = "orderStatus")
	private String orderStatus;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date packedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelledDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnedDateTime;

	public Order() {
	}
	
	public Order(String recipient, String shipHouseNo, String shipStreet, String shipTown, String shipPostcode,
			String shipCountry, String trackingCode) {
		this.recipient = recipient;
		this.shipHouseNo = shipHouseNo;
		this.shipStreet = shipStreet;
		this.shipTown = shipTown;
		this.shipPostcode = shipPostcode;
		this.shipCountry = shipCountry;
		this.trackingCode = trackingCodeGenerator();
		this.orderedDateTime = new Date();
		this.packedDateTime = null;
		this.shippedDateTime = null;
		this.cancelledDateTime = null;
		this.returnedDateTime = null;
		
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "order")
	private List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
	
	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}
	
	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}
	
	public void addOrderProduct(OrderProduct orderProduct){
		orderProduct.setOrder(this);
		this.orderProductList.add(orderProduct);
	}
	
	public String randomCharGenerator(int number) {
		Random r = new Random();
		String alpha = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String generatedRandomChar = "";
		for (int i = 0; i < number; i++) {
			generatedRandomChar += String.valueOf(alpha.charAt(r.nextInt(alpha.length())));
		}
		return generatedRandomChar;
	}

	public String trackingCodeGenerator() {
		return randomCharGenerator(12);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getShipHouseNo() {
		return shipHouseNo;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setShipHouseNo(String shipHouseNo) {
		this.shipHouseNo = shipHouseNo;
	}

	public String getShipStreet() {
		return shipStreet;
	}

	public void setShipStreet(String shipStreet) {
		this.shipStreet = shipStreet;
	}

	public String getShipTown() {
		return shipTown;
	}

	public void setShipTown(String shipTown) {
		this.shipTown = shipTown;
	}

	public String getShipPostcode() {
		return shipPostcode;
	}

	public void setShipPostcode(String shipPostcode) {
		this.shipPostcode = shipPostcode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public Date getOrderedDateTime() {
		return orderedDateTime;
	}

	public void setOrderedDateTime(Date orderedDateTime) {
		this.orderedDateTime = orderedDateTime;
	}

	public Date getPackedDateTime() {
		return packedDateTime;
	}

	public void setPackedDateTime(Date packedDateTime) {
		this.packedDateTime = packedDateTime;
	}

	public Date getShippedDateTime() {
		return shippedDateTime;
	}

	public void setShippedDateTime(Date shippedDateTime) {
		this.shippedDateTime = shippedDateTime;
	}

	public Date getCancelledDateTime() {
		return cancelledDateTime;
	}

	public void setCancelledDateTime(Date cancelledDateTime) {
		this.cancelledDateTime = cancelledDateTime;
	}

	public Date getReturnedDateTime() {
		return returnedDateTime;
	}

	public void setReturnedDateTime(Date returnedDateTime) {
		this.returnedDateTime = returnedDateTime;
	}

	@Override
	public String toString() {
		return "Order [recipient=" + recipient + ", shipHouseNo=" + shipHouseNo + ", shipStreet=" + shipStreet
				+ ", shipTown=" + shipTown + ", shipPostcode=" + shipPostcode + ", shipCountry=" + shipCountry
				+ ", trackingCode=" + trackingCode + ", orderedDateTime="
				+ orderedDateTime + ", packedDateTime=" + packedDateTime + ", shippedDateTime=" + shippedDateTime
				+ ", cancelledDateTime=" + cancelledDateTime + ", returnedDateTime=" + returnedDateTime + "]";
	}
}
