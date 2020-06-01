package com.fdmgroup.fdmazon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bhh_2product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId",unique=true,nullable=false)
	private long productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productPrice")
	private double productPrice;
	@Column(name = "productCode")
	private String productCode;
	@Column(name = "productDescription")
	private String productDescription;
	@Column(name = "productImg")
	private String productImg;
	@Column(name = "productBrand")
	private String productBrand;
	@Column(name = "category")
	private String category;
	@Column(name = "stock")
	private int stock;

	@OneToMany(cascade=CascadeType.ALL, mappedBy ="product")
	private List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();

	public List<OrderProduct> getOrderProductList(){
		return orderProductList;
	}
	
	public void setOrderProductList(List<OrderProduct> orderProductList){
		this.orderProductList = orderProductList;
	}
	
	public void addOrderProduct(OrderProduct orderProduct){
		orderProduct.setProduct(this);
		this.orderProductList.add(orderProduct);
	}
	
	
	public Product() {
	}
	
	public Product(String productName, double productPrice, String productCode,
			String productDescription, String productImg, String productBrand, String category, int stock) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCode = productCode;
		this.productDescription = productDescription;
		this.productImg = productImg;
		this.productBrand = productBrand;
		this.category = category;
		this.stock = stock;
	}

	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCode=" + productCode + ", productDescription=" + productDescription + ", productImg="
				+ productImg + ", productBrand=" + productBrand + ", category=" + category + ", stock=" + stock + "]";
	}

	

}
