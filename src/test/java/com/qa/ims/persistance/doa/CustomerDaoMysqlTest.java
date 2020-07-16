package com.qa.ims.persistance.doa;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CustomerDaoMysqlTest {

	/**
	 * The thing I want to fake functionality for
	 */
//		@Mock
//		private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerDaoMysqlTest customerDaoMysqlTest;
	static String jdbcurl = "jdbc:mysql://34.105.147.13:3306/";
	static String username = "root";
	static String password = "root";

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysqlTest.class);

//		public CustomerDaoMysql(String string, String string2, String string3) {
//			// TODO Auto-generated constructor stub
//		}
//

//		public CustomerDaoMysql(String username, String password2) {
//			// TODO Auto-generated constructor stub
//			this.username = username;
//			
//		}

	// public CustomerDaoMysqlTest(String string, String string2, String string3) {
	// TODO Auto-generated constructor stub
//		}
	// public CustomerDaoMysqlTest(String username2, String password2) {
//			// TODO Auto-generated constructor stub
//		}
//		public CustomerDaoMysqlTest(String string, String string2, String string3) {
//			// TODO Auto-generated constructor stub
//		}
	@BeforeClass
	public static void init() {

		Ims ims = new Ims();
		ims.init("jdbc:mysql://34.105.147.13:3306/", "root", "root", "src/main/resources/sql-schema.sql");
	}

//		ims.init("jdbc:mysql://127.0.0.1:3306/ims_test?serverTimezone=UTC", "root", "root",
//				"src/test/resources/sql-schema.sql");
//	}
	@BeforeClass
	public static void setup() {
		try {
			Connection connection = DriverManager.getConnection(jdbcurl, username, password);
			Statement statement = connection.createStatement();
			statement.executeUpdate("create database ims_test;");

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Test
	public void bCreateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
		String firstName = "Vinesh";
		String lastName = "Ghela";
		Customer customer = new Customer(firstName, lastName);
//		String first_name2 = "James";
//		String last_name2 = "Peach";
//		Customer customer2 = new Customer(first_name2, last_name2);
//		String first_name3 = "Bob";
//		String last_name3 = "Perry";
//		Customer customer3 = new Customer(first_name3, last_name3);
		customer = customerDaoMysql.create(customer);
		Object savedCustomer = null;
		assertEquals(savedCustomer, customer);
		assertEquals(customer, customerDaoMysql.create(customer));
//		assertEquals(customer2, customerDaoMysql.create(customer2));
//		assertEquals(customer3, customerDaoMysql.create(customer3));
	}

//	private Object create(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Test
	public void cReadAllTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
		ArrayList<Customer> customers = new ArrayList<>();
//		customers.add(new Customer(1L, "Vinesh", "Ghela"));
//		customers.add(new Customer(2L, "James", "Peach"));
//		customers.add(new Customer(3L, "Bob", "Perry"));

		customerDaoMysql.create(new Customer("Vinesh", "Ghela"));
		List<Customer> Customers = customerDaoMysql.readAll();

//
//		assertEquals(customers, customerDaoMysql.readAll());
//		ArrayList<Customer> customers = new ArrayList<>();
//		customers.add(new Customer("Bob", "Perry"));
//		customerDaoMysql.create(new Customer("Bob", "Perry"));
//		List<Customer> savedcustomers = customerDaoMysql.readAll();

	}

	@Test
	public void dReadLatestTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
		Customer customer = new Customer("Vinesh", "Ghela");
		customer = customerDaoMysql.create(customer);
		Object savedcustomer = null;
		assertEquals(customer, savedcustomer);
		assertEquals(customer, customerDaoMysql.readLatest());
	}

	@Test
	public void eReadCustomerTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
		Customer customer = new Customer(2L, "James", "Peach");
		customer = customerDaoMysql.create(customer);
		Object savedcustomer = null;
		assertEquals(customer, savedcustomer);
		assertEquals(customer, customerDaoMysql.readCustomer(2L));
	}

	//
//		/**
//		 * 
//		 */
	@Test
	public void fUpdateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
//		Long id = 1L;
		String firstName = "Vinesh";
		String surname = "Ghela";
		Customer customer = new Customer(firstName, surname);
//		assertEquals(customer, customerDaoMysql.update(customer));
//		customer = customerDaoMysql.create(customer);
//		customer.setFirstName("Bob");
		customer = customerDaoMysql.update(customer);
		Object savedcustomer = null;
		assertEquals(customer, savedcustomer);
		assertEquals(customer, customerDaoMysql.update(customer));
//		customer = customerDaoMysql.create(customer);
//		Object savedCustomer = null;
//		assertEquals(savedCustomer, customer);
//		assertEquals(customer, customerDaoMysql.create(customer));
	}
//		customer = customerDaoMysql.create(customer);
//		Object savedCustomer = null;
//		assertEquals(savedCustomer, customer);
//		assertEquals(customer, customerDaoMysql.create(customer));

//		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
//		String firstName = "Vinesh";
//		String lastName = "Ghela";
//		Customer customer = new Customer(firstName, lastName);
////		String first_name2 = "James";
////		String last_name2 = "Peach";
////		Customer customer2 = new Customer(first_name2, last_name2);
////		String first_name3 = "Bob";
////		String last_name3 = "Perry";
////		Customer customer3 = new Customer(first_name3, last_name3);
//		customer = customerDaoMysql.create(customer);
//		Object savedCustomer = null;
//		assertEquals(savedCustomer, customer);
//		assertEquals(customer, customerDaoMysql.create(customer));
////		assertEquals(customer2, customerDaoMysql.create(customer2));
////		assertEquals(customer3, customerDaoMysql.create(customer3));
//	}

//		/**
//		 * makes sure that after you delete, the entry is no longer in the database.
//		 */
	@Test
	public void gDeleteTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql://34.105.147.13:3306/", "root", "root");
//		String id = "3";
//		customerDaoMysql.delete(Long.parseLong(id));
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(3L, "Bob", "Perry"));
		customers = customerDaoMysql.delete(customers);
		Object savedcustomer = null;
		assertEquals(customers, savedcustomer);
		assertEquals(customers, customerDaoMysql.readAll());
	}

	@AfterClass
	public static void cleanDB() {

		try (Connection connection = DriverManager.getConnection(jdbcurl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("drop table customers");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
