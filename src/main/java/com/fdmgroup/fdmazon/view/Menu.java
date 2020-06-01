package com.fdmgroup.fdmazon.view;

import java.util.Date;
import java.util.Scanner;

import com.fdmgroup.fdmazon.controller.MainController;
import com.fdmgroup.fdmazon.dao.OrderProductServicesImp;
import com.fdmgroup.fdmazon.dao.OrderServicesImp;
import com.fdmgroup.fdmazon.dao.ProductServicesImp;
import com.fdmgroup.fdmazon.dao.Services;
import com.fdmgroup.fdmazon.dao.UserServicesImp;
import com.fdmgroup.fdmazon.model.Order;
import com.fdmgroup.fdmazon.model.OrderProduct;
import com.fdmgroup.fdmazon.model.Product;
import com.fdmgroup.fdmazon.model.User;

public class Menu {

	private MainController mainController;
	private Scanner scanner;
	private Services services, services1, services2, services3;
	private UserServicesImp userServicesImp;
	private ProductServicesImp productServicesImp;
	private OrderServicesImp orderServicesImp;
	private OrderProductServicesImp orderProductServicesImp;
	
	public Menu(){
		this.mainController = new MainController();
	}
	
	public Menu(MainController mainController) {
		this.mainController = mainController; 
	}
	
	public void test() {
		this.mainController.init();
		User newUser = new User("Mr", "M","M","M","M","M","M","M","M","M","M");
		Product p1 = new Product("Samsung Galaxy Tab 10", 199.99, "SGTab10","10 inch tablet, 3GB RAM, quad core 1.5GHz, 32GB, Android 6, 8 hours battery life",	"/fdmazon/images/uk_SM-T520NZKABTU_000230390_Front_black.jpg", "Samsung", "Tablet", 100);
		Product p2 = new Product("Lenovo Yoga Tab 3 Pro 10", 399.99, "LNVYogaTab3Pro10","10 inch tablet, 2GB RAM, quad core 1.6GHz, 32GB, Android 6, 9 hours battery life",	"/fdmazon/images/lenovo-yoga-tablet-3-pro-hero.png", "Lenovo", "Tablet", 45);
		Order o1 = new Order("James Bond", "1", "Whitehall Riverside", "Leeds", "LS1 4BN", "UK", "AA123456789GB");
		
		o1.setUser(newUser);
		newUser.addOrder(o1);
				
		OrderProduct op = new OrderProduct();
		op.setOrder(o1);
		op.setProduct(p1);
		op.setQuantity(1);
		o1.addOrderProduct(op);
		this.mainController.saveOrder(o1);
		this.mainController.saveOrderProduct(op);
		
		
		this.mainController.close();
	}
	
	public void init() {
		this.mainController.init();
		
		this.services = new UserServicesImp();
		this.userServicesImp = (UserServicesImp) this.services;
		this.services1 = new OrderServicesImp();
		this.orderServicesImp = (OrderServicesImp) this.services1;
		this.services2 = new ProductServicesImp();
		this.productServicesImp = (ProductServicesImp) this.services2;
		this.services3 = new OrderProductServicesImp();
		this.orderProductServicesImp = (OrderProductServicesImp) this.services3;
 
		User u = new User("God", "Admin", "Admin", "admin@fdm", "Password1", "Admin", "Admin", "Admin", "Admin","Admin", "Admin");
		User nu1 = new User("Mr", "Boon Hon", "Hong", "boon@fdm.com", "Aaaaaaaa1", "221B", "Baker Street", "London","NW1 2NJ", "UK", "0207000000");
		Product p1 = new Product("Samsung Galaxy Tab 10", 199.99, "SGTab10","10 inch tablet, 3GB RAM, quad core 1.5GHz, 32GB, Android 6, 8 hours battery life",	"/fdmazon/images/uk_SM-T520NZKABTU_000230390_Front_black.jpg", "Samsung", "Tablet", 100);
		Product p2 = new Product("Lenovo Yoga Tab 3 Pro 10", 399.99, "LNVYogaTab3Pro10","10 inch tablet, 2GB RAM, quad core 1.6GHz, 32GB, Android 6, 9 hours battery life",	"/fdmazon/images/lenovo-yoga-tablet-3-pro-hero.png", "Lenovo", "Tablet", 45);
		Product p3 = new Product("Apple iPad Air 2", 359.99, "AppleiPadAir2","Apple A8X, iOS 9, 9.7, Wi-Fi, 32GB, Space Grey", "/fdmazon/images/2015-iPad-Air-2.jpg", "Apple","Tablet", 50);
		Product p4 = new Product("Samsung Galaxy S7", 449.99, "SGS7","5 inch Super AMOLED, 4GB, Quad core, 32GB, White, Android 6, IP68", "/fdmazon/images/sgs6.jpg","Samsung", "Phone", 234);
		Product p5 = new Product("Asus ZenPad Z300M", 99.99, "ASUSZENPAD","10.1 inch, 2GB RAM, Quad core 1.3GHz, 16GB, Grey, Android 6", "/fdmazon/images/asuszenpad.jpg", "Asus","Tablet", 28);
		Product p6 = new Product("Samsung Galaxy Tab E", 159.99, "SGTabE","9.6 inch, 1GB RAM, Quad-core 1.3GHz, 8GB, White, Android 4.4", "/fdmazon/images/samsunggalaxytabe.jpg","Samsung", "Tablet", 7);
		Product p7 = new Product("Google Pixel", 600, "GooglePixel101","5 inch AMOLED, 4GB, QS821 Quad-core 2.4GHz, 32GB, Silver, Android 7.1",	"/fdmazon/images/googlepixel.jpg", "Google", "Phone", 1);

		this.userServicesImp.save(u);
		this.userServicesImp.save(nu1);
		this.productServicesImp.save(p1);
		this.productServicesImp.save(p2);
		this.productServicesImp.save(p3);
		this.productServicesImp.save(p4);
		this.productServicesImp.save(p5);
		this.productServicesImp.save(p6);
		this.productServicesImp.save(p7);

		Order o1 = new Order("James Bond", "1", "Whitehall Riverside", "Leeds", "LS1 4BN", "UK", "AA123456789GB");
		Order o2 = new Order("Jane Smith", "10", "Downing Street", "London", "SW1A 2AA", "UK", "BB12E45D789GB");

		this.orderServicesImp.save(o1);
		this.orderServicesImp.save(o2);

		OrderProduct op1 = new OrderProduct();
		op1.setOrder(o1);op1.setProduct(p1);op1.setQuantity(1);
		OrderProduct op2 = new OrderProduct();
		op2.setOrder(o1);op2.setProduct(p2);op2.setQuantity(2);
		OrderProduct op3 = new OrderProduct();
		op3.setOrder(o2);op3.setProduct(p6);op3.setQuantity(2);

		o1.addOrderProduct(op1);
		o1.addOrderProduct(op2);
		o1.addOrderProduct(op3);
		o1.setUser(nu1);
		nu1.addOrder(o1);

		OrderProduct op4 = new OrderProduct();
		op4.setOrder(o2);
		op4.setProduct(p5);
		op4.setQuantity(1);

		o2.addOrderProduct(op3);
		o2.addOrderProduct(op4);
		o2.setUser(nu1);
		nu1.addOrder(o2);

		this.orderProductServicesImp.save(op1);
		this.orderProductServicesImp.save(op2);
		this.orderProductServicesImp.save(op3);
		this.orderProductServicesImp.save(op4);

		User user = (User) this.userServicesImp.read("boon@fdm.com");
		user.setBalance(20000L);
		this.userServicesImp.save(user);

		Order o = (Order) this.orderServicesImp.read(10L);
		o.setPackedDateTime(new Date());
		o.setShippedDateTime(new Date());
		this.orderServicesImp.save(o);

		this.mainController.close();
	}

	public void menu() {
		this.scanner = new Scanner(System.in);
		User newUser;
		Product newProduct;
		Order newOrder;
		boolean run = true;
		boolean run1 = true;
		String option = "";
		String option1 = "";
		while (run) {
			run1 = true;
			System.out.println("DATABASE:");
			System.out.println("1.  User");
			System.out.println("2.  Product");
			System.out.println("3.  Order");
			System.out.println("00. EXIT");
			option = this.scanner.nextLine();
			switch (option) {
			case "1": // User database
				while (run1) {
					System.out.println("DATABASE >> USER:");
					System.out.println("1.  Create new record");
					System.out.println("2.  Read record");
					System.out.println("3.  Update record");
					System.out.println("4.  Delete record");
					System.out.println("5.  List all records");
					System.out.println("0.  GO BACK");
					option1 = this.scanner.nextLine();
					String userTitle = "", firstName = "", lastName = "", email = "", password = "", houseNo = "",
							street = "", town = "", postcode = "", country = "", phone = "";
					switch (option1) {
					case "1": // create user
						System.out.println("DATABASE >> USER >> CREATE NEW RECORD:");
						System.out.println("Enter title (Mr,Mrs,Miss,Ms,Other):");
						userTitle = this.scanner.nextLine();
						System.out.println("Enter first name:");
						firstName = this.scanner.nextLine();
						System.out.println("Enter last name:");
						lastName = this.scanner.nextLine();
						System.out.println("Enter email(username):");
						email = this.scanner.nextLine();
						System.out.println("Enter password:");
						password = this.scanner.nextLine();
						System.out.println("Enter house no.:");
						houseNo = this.scanner.nextLine();
						System.out.println("Enter street:");
						street = this.scanner.nextLine();
						System.out.println("Enter town:");
						town = this.scanner.nextLine();
						System.out.println("Enter postcode:");
						postcode = this.scanner.nextLine();
						System.out.println("Enter country:");
						country = this.scanner.nextLine();
						System.out.println("Enter phone number:");
						phone = this.scanner.nextLine();
						newUser = new User(userTitle, firstName, lastName, email, password, houseNo, street, town,
								postcode, country, phone);
						this.mainController.saveUser(newUser);
						break;
					case "2": // read user(email)
						System.out.println("DATABASE >> USER >> READ RECORD BY EMAIL:");
						System.out.println("Enter email:");
						email = this.scanner.nextLine();
						this.mainController.readUser(email);
						break;
					case "3": // update user(user)
						System.out.println("DATABASE >> USER >> UPDATE RECORD BY EMAIL:");
						System.out.println("Enter email(username) of user to be updated:");
						email = this.scanner.nextLine();
						System.out.println("Enter new title (Mr,Mrs,Miss,Ms,Other):");
						userTitle = this.scanner.nextLine();
						System.out.println("Enter new first name:");
						firstName = this.scanner.nextLine();
						System.out.println("Enter new last name:");
						lastName = this.scanner.nextLine();
						System.out.println("Enter new password:");
						password = this.scanner.nextLine();
						System.out.println("Enter new house no.:");
						houseNo = this.scanner.nextLine();
						System.out.println("Enter new street:");
						street = this.scanner.nextLine();
						System.out.println("Enter new town:");
						town = this.scanner.nextLine();
						System.out.println("Enter new postcode:");
						postcode = this.scanner.nextLine();
						System.out.println("Enter new country:");
						country = this.scanner.nextLine();
						System.out.println("Enter new phone number:");
						phone = this.scanner.nextLine();
						newUser = new User(userTitle, firstName, lastName, email, password, houseNo, street, town,
								postcode, country, phone);
						this.mainController.updateUser(newUser);
						break;
					case "4": // delete user(email)
						System.out.println("DATABASE >> USER >> DELETE RECORD BY EMAIL:");
						System.out.println("Enter email of user to be deleted:");
						email = this.scanner.nextLine();
						this.mainController.deleteUser(email);
						break;
					case "5": // list users
						System.out.println("DATABASE >> USER >> LIST ALL RECORDS:");
						this.mainController.listUsers();
						break;
					case "0":
						run1 = false;
						break;
					default:
						System.out.println("? ? ? ? Try again.");
						break;
					}
				}
				break;
			case "2": // Product database
				while (run1) {
					System.out.println("DATABASE >> PRODUCT:");
					System.out.println("1.  Create new record");
					System.out.println("2.  Read record");
					System.out.println("3.  Update record");
					System.out.println("4.  Delete record");
					System.out.println("5.  List all records");
					System.out.println("0.  GO BACK");
					option1 = this.scanner.nextLine();
					String productName = "", productCode = "", productDescription = "", productImg = "",
							productBrand = "", category = "";
					long productId = 0L;
					double productPrice;
					int stock;
					switch (option1) {
					case "1": // create
						System.out.println("DATABASE >> PRODUCT >> CREATE NEW RECORD");
						System.out.println("Enter product name:");
						productName = this.scanner.nextLine();
						System.out.println("Enter product price:");
						productPrice = Double.valueOf(this.scanner.nextLine());
						System.out.println("Enter product code:");
						productCode = this.scanner.nextLine();
						System.out.println("Enter product description:");
						productDescription = this.scanner.nextLine();
						System.out.println("Enter product image url:");
						productImg = this.scanner.nextLine();
						System.out.println("Enter product brand:");
						productBrand = this.scanner.nextLine();
						System.out.println("Enter category:");
						category = this.scanner.nextLine();
						System.out.println("Enter stock:");
						stock = Integer.valueOf(this.scanner.nextLine());
						newProduct = new Product(productName, productPrice, productCode, productDescription, productImg,
								productBrand, category, stock);
						this.mainController.saveProduct(newProduct);
						break;
					case "2": // read product (productId)
						System.out.println("DATABASE >> PRODUCT >> READ RECORD BY ID:");
						System.out.println("Enter product ID:");
						productId = Long.valueOf(this.scanner.nextLine());
						this.mainController.readProduct(productId);
						break;
					case "3": // update product
						System.out.println("DATABASE >> PRODUCT >> UPDATE RECORD BY ID:");
						System.out.println("Enter product Id of record to be updated:");
						productId = Long.valueOf(this.scanner.nextLine());
						System.out.println("Enter product name:");
						productName = this.scanner.nextLine();
						System.out.println("Enter product price:");
						productPrice = Double.valueOf(this.scanner.nextLine());
						System.out.println("Enter product code:");
						productCode = this.scanner.nextLine();
						System.out.println("Enter product description:");
						productDescription = this.scanner.nextLine();
						System.out.println("Enter product image url:");
						productImg = this.scanner.nextLine();
						System.out.println("Enter product brand:");
						productBrand = this.scanner.nextLine();
						System.out.println("Enter category:");
						category = this.scanner.nextLine();
						System.out.println("Enter stock:");
						stock = Integer.valueOf(this.scanner.nextLine());
						newProduct = new Product(productName, productPrice, productCode, productDescription, productImg,
								productBrand, category, stock);
						this.mainController.updateProduct(productId, newProduct);
						break;
					case "4": // delete product
						System.out.println("DATABASE >> PRODUCT >> DELETE RECORD BY ID:");
						System.out.println("Enter product ID of record to be deleted:");
						productId = Long.valueOf(this.scanner.nextLine());
						this.mainController.deleteProduct(productId);
						break;
					case "5": // list products
						System.out.println("DATABASE >> PRODUCT >> LIST ALL RECORDS:");
						this.mainController.listProducts();
						break;
					case "0":
						run1 = false;
						break;
					default:
						System.out.println("? ? ? ? Try again.");
						break;
					}
				}
				break;
			case "3":
				while (run1) {
					System.out.println("DATABASE >> ORDER:");
					System.out.println("1.  Create new record");
					System.out.println("2.  Read record");
					System.out.println("3.  Update record");
					System.out.println("4.  Delete record");
					System.out.println("5.  List all records");
					System.out.println("0.  GO BACK");
					option1 = this.scanner.nextLine();
					String recipient = "", shipHouseNo = "", shipStreet = "", shipTown = "", shipPostcode = "",
							shipCountry = "", trackingCode = "";
					long orderId = 0L;
					switch (option1) {
					case "1": // create
						System.out.println("DATABASE >> ORDER >> CREATE NEW RECORD");
						System.out.println("Enter recipient:");
						recipient = this.scanner.nextLine();
						System.out.println("Enter house no.:");
						shipHouseNo = this.scanner.nextLine();
						System.out.println("Enter street:");
						shipStreet = this.scanner.nextLine();
						System.out.println("Enter town:");
						shipTown = this.scanner.nextLine();
						System.out.println("Enter postcode:");
						shipPostcode = this.scanner.nextLine();
						System.out.println("Enter country:");
						shipCountry = this.scanner.nextLine();
						System.out.println("Enter tracking code:");
						trackingCode = this.scanner.nextLine();
						newOrder = new Order(recipient, shipHouseNo, shipStreet, shipTown, shipPostcode, shipCountry,
								trackingCode);
						this.mainController.saveOrder(newOrder);
						break;
					case "2": // read order (orderId)
						System.out.println("DATABASE >> ORDER >> READ RECORD BY ID:");
						System.out.println("Enter order ID:");
						orderId = Long.valueOf(this.scanner.nextLine());
						this.mainController.readOrder(orderId);
						break;
					case "3": // update order
						System.out.println("DATABASE >> ORDER >> UPDATE RECORD BY ID:");
						System.out.println("Enter order Id of record to be updated:");
						orderId = Long.valueOf(this.scanner.nextLine());
						System.out.println("Enter recipient:");
						recipient = this.scanner.nextLine();
						System.out.println("Enter house no.:");
						shipHouseNo = this.scanner.nextLine();
						System.out.println("Enter street:");
						shipStreet = this.scanner.nextLine();
						System.out.println("Enter town:");
						shipTown = this.scanner.nextLine();
						System.out.println("Enter postcode:");
						shipPostcode = this.scanner.nextLine();
						System.out.println("Enter country:");
						shipCountry = this.scanner.nextLine();
						System.out.println("Enter tracking code:");
						trackingCode = this.scanner.nextLine();
						newOrder = new Order(recipient, shipHouseNo, shipStreet, shipTown, shipPostcode, shipCountry,
								trackingCode);
						this.mainController.updateOrder(orderId, newOrder);
						break;
					case "4": // delete
						System.out.println("DATABASE >> ORDER >> DELETE RECORD BY ID:");
						System.out.println("Enter order ID of record to be deleted:");
						orderId = Long.valueOf(this.scanner.nextLine());
						this.mainController.deleteOrder(orderId);
						break;
					case "5":
						System.out.println("DATABASE >> ORDER >> LIST ALL RECORDS:");
						this.mainController.listOrders();
						break;
					case "0":
						run1 = false;
						break;
					default:
						System.out.println("? ? ? ? Try again.");
						break;
					}
				}
				break;
			case "00":
				run = false;
				System.out.println("Good bye");
				break;
			default:
				System.out.println("? ? ? ? Try again.");
				break;
			}
		}
		this.scanner.close();
	}
}