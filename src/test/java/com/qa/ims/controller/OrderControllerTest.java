package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy // for the methods in orderController
	@InjectMocks // for any classes our orderController calls (in this case orderService)
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(4, 65.54));
		orders.add(new Order(8, 31.48));
		orders.add(new Order(1, 567.32));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void createTest() {
		Integer quantity = 6;
		Double total = 59.00;
		Mockito.doReturn(quantity, total).when(orderController).getInput();
		Order order = new Order(quantity, total);
		Order savedOrder = new Order(1, 2, 54.77);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}

	/**
	 *
	 */
	@Test
	public void updateTest() {
		Integer order_id = 1;
		Integer quantity = 5;
		Double total = 55.66;
		Mockito.doReturn(order_id, quantity, total).when(orderController).getInput();
		Order order = new Order(1, quantity, total);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		Integer order_id = 1;
		Mockito.doReturn(order_id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}

}
