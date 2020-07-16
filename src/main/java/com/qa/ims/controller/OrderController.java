package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> order = orderService.readAll();
		for (Order order1 : order) {
			LOGGER.info(order1.toString());
		}
		return order;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {

		LOGGER.info("Please enter the Customer ID correpsonding to who is making the order: ");
		Long customerID1 = Long.valueOf(getInput());

		LOGGER.info("What is the ID of the product you wish to purchase?");
		Long product_id = Long.valueOf(getInput());

		LOGGER.info("How many products would you like to purchase?");
		Long quantity = Long.valueOf(getInput());

		LOGGER.info("What is the total of your order?");
		Double total = Double.valueOf(getInput());

		Order order = orderService.create(new Order(customerID1, product_id, quantity, total));
		LOGGER.info("Order created ");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update: ");
		Long order_id = Long.valueOf(getInput());

		LOGGER.info("Please enter the new total of the order: ");
		Double total = Double.valueOf(getInput());

		Order order = orderService.update(new Order(order_id, total));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = Long.valueOf(getInput());
		orderService.delete(order_id);
		LOGGER.info("Order deleted");
	}

}
