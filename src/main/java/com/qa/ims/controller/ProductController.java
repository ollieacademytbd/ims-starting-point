package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ProductController implements CrudController<Product> {
	

	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */


		public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

		private CrudServices<Customer> customerService;

		public ProductController(CrudServices<Product> productService) {
			this.productService = productService;
		}

		String getInput() {
			return Utils.getInput();
		}

		/**
		 * Reads all customers to the logger
		 */
		@Override
		public List<Product> readAll() {
			List<Product> product = productService.readAll();
			for (Products product : products) {
				LOGGER.info(product.toString());
			}
			return product;
		}

		/**
		 * Creates a customer by taking in user input
		 */
		@Override
		public Product create() {
			LOGGER.info("Please enter a first name");
			String firstName = getInput();
			LOGGER.info("Please enter a Last Name");
			String lastName = getInput();
			Customer product = customerService.create(new Product(firstName, lastName));
			LOGGER.info("Customer created");
			return product;
		}

		/**
		 * Updates an existing customer by taking in user input
		 */
		@Override
		public Product update() {
			LOGGER.info("Please enter the id of the customer you would like to update");
			Long id = Long.valueOf(getInput());
			LOGGER.info("Please enter a first name");
			String firstName = getInput();
			LOGGER.info("Please enter a Last Name");
			String lastName = getInput();
			Customer product = productService.update(new Product(id, firstName, lastName));
			LOGGER.info("Customer Updated");
			return product;
		}

		/**
		 * Deletes an existing customer by the id of the customer
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the customer you would like to delete");
			Long id = Long.valueOf(getInput());
			productService.delete(id);
		}

	}

}
