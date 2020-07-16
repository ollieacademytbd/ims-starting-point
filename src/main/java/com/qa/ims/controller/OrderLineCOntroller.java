package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.LineServices;
import com.qa.ims.utils.Utils;

public class OrderLineCOntroller implements CrudController<OrderLine> {

	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */

	public static final Logger LOGGER = Logger.getLogger(OrderLineCOntroller.class);

	private LineServices<OrderLine> orderlineService;

	public OrderLineCOntroller(LineServices<OrderLine> orderlineService) {
		this.orderlineService = orderlineService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<OrderLine> readAll() {
		LOGGER.info("WHat is the ID of the OrderLine you want to return: ");

		Long orderline_id = Long.valueOf(getInput());
		List<OrderLine> orderline = orderlineService.readAll(orderline_id);
		for (OrderLine orderline2 : orderline) {
			LOGGER.info(orderline2.toString());
		}
		return orderline;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public OrderLine create() {

		LOGGER.info("Please enter the Order Line ID of this order: ");
		Long order_id = Long.valueOf(getInput());

		LOGGER.info("What is the ID of the product: ");
		Long product_id = Long.valueOf(getInput());

		LOGGER.info("How many products would you like to add: ");
		Long quantity = Long.valueOf(getInput());

//			LOGGER.info("What is the total of your order?");
//			Double total = Double.valueOf(getInput());
//	      add total into order order
		OrderLine orderline = orderlineService.create(new OrderLine(order_id, product_id, quantity));
		LOGGER.info("Order Line created ");
		return orderline;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public OrderLine update() {

		LOGGER.info("OrderLine ID to update: ");
		Long orderline_id = Long.valueOf(getInput());

		LOGGER.info("Please enter the id of the order you would like to update: ");
		Long order_id = Long.valueOf(getInput());

		LOGGER.info("Please enter the id of the product to add to order: ");
		Long product_id = Long.valueOf(getInput());

		LOGGER.info("Please enter the new quantity of the order: ");
		Long quantity = Long.valueOf(getInput());

		CrudServices<OrderLine> orderlineService = null;
		@SuppressWarnings("null")
		OrderLine orderline = orderlineService.update(new OrderLine(orderline_id, order_id, product_id, quantity));
		LOGGER.info("Order Updated");
		return orderline;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the orderline you would like to delete");
		Long orderline_id = Long.valueOf(getInput());
		orderlineService.delete(orderline_id);
		LOGGER.info("Order deleted");
	}

}
