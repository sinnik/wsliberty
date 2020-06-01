package com.fdmgroup.fdmazon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bhh_2user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	private long userId;
	@Column(name = "userTitle")
	private String userTitle;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email", unique = true, nullable = false)
	private String email; // username
	@Column(name = "password")
	private String password;
	@Column(name = "houseNo")
	private String houseNo;
	@Column(name = "street")
	private String street;
	@Column(name = "town")
	private String town;
	@Column(name = "postcode")
	private String postcode;
	@Column(name = "country")
	private String country;
	@Column(name = "phone")
	private String phone;
	@Temporal(TemporalType.DATE)
	@Column(name = "registeredDate")
	private Date registeredDate;
	@Column(name = "balance")
	private double balance;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Order> orderList = new ArrayList<Order>();

	public List<Order> getOrderList() {
		return this.orderList;
	}

	public void addOrder(Order order) {
		this.orderList.add(order);
	}

	public User() {
	}

	public User(String userTitle, String firstName, String lastName, String email, String password, String houseNo,
			String street, String town, String postcode, String country, String phone) {
		this.userTitle = userTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.houseNo = houseNo;
		this.street = street;
		this.town = town;
		this.postcode = postcode;
		this.country = country;
		this.phone = phone;
		this.registeredDate = new Date();
		this.balance = 0.00d;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userTitle=" + userTitle + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", houseNo=" + houseNo + ", street=" + street + ", town=" + town
				+ ", postcode=" + postcode + ", country=" + country + ", phone=" + phone + ", registeredDate="
				+ registeredDate + ", balance=" + balance + "]";
	}

}