package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.qa.ims.persistence.domain.Product;
import com.qa.ims.services.ProductServices;

public class ProductControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private ProductServices productServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy // for the methods in productController
	@InjectMocks // for any classes our productController calls (in this case productService)
	private ProductController productController;

	@Test
	public void readAllTest() {
		ProductController productController = new ProductController(productServices);
		List<Product> products = new ArrayList<>();
		products.add(new Product("Ham", 3.0));
		products.add(new Product("Rice", 0.5));
		products.add(new Product("Yogurt", 1.5));
		Mockito.when(productServices.readAll()).thenReturn(products);
		assertEquals(products, productController.readAll());
	}

	@Test
	public void createTest() {
//		ProductController productController = new ProductController(productServices);
		String product_name = "Cheese";
		Double price = 2.49;
		Mockito.doReturn(product_name, price).when(productController).getInput();
		Product product = new Product(product_name, price);
		Product savedProduct = new Product(1L, "Cheese", 2.49);
		Mockito.when(productServices.create(product)).thenReturn(savedProduct);
		assertEquals(savedProduct, productController.create());
	}

	/**
	 *
	 */
	@Test
	public void updateTest() {
//		ProductController productController = new ProductController(productServices);
		String product_id = "1L";
		String product_name = "Milk";
		Double price = 1.45;
		Mockito.doReturn(product_name, price).when(productController).getInput();
		Product product = new Product(1L, product_name, price);
		Mockito.when(productServices.update(product)).thenReturn(product);
		assertEquals(product, productController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		Long product_id = (long) 1;
		Mockito.doReturn(product_id).when(productController).getInput();
		productController.delete();
		Mockito.verify(productServices, Mockito.times(1)).delete(1L);
	}

}
