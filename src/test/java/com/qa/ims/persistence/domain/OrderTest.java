package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	private Order other;

	@Before
	public void setUp() {
		order = new Order(1L, 1L, 6L, 33.33);
		other = new Order(1L, 1L, 6L, 33.33);
	}

	@Test
	public void settersTest() {
		assertNotNull(order.getOrder_id());
		assertNotNull(order.getQuantity());
		assertNotNull(order.getTotal());

		order.setOrder_id(null);
		assertNull(order.getOrder_id());
		order.setQuantity(null);
		assertNull(order.getQuantity());
		order.setTotal(null);
		assertNull(order.getTotal());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void createCustomerWithId() {
		assertEquals(1L, order.getOrder_id(), 0);
		assertEquals(6L, order.getQuantity(), 0);
		assertEquals(33.33, order.getTotal(), 0);
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		order.setOrder_id(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setOrder_id(6L);
		assertFalse(order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setQuantity(null);
		other.setQuantity(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void nullId() {
		order.setOrder_id(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		order.setOrder_id(null);
		other.setOrder_id(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setOrder_id(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullTotal() {
		order.setTotal(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullSurnameOnBoth() {
		order.setTotal(null);
		other.setTotal(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setTotal(44.44);
		assertFalse(order.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Order order = new Order(1L, 6L, 33.33);
//		assertNull(order.getOrder_id());
		assertNotNull(order.getCustomer_id());
		assertNotNull(order.getQuantity());
		assertNotNull(order.getTotal());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null);
		Order other = new Order(null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "Order ID: 1 Customer ID: 1 Quantity: 6 Total: 33.33";
		assertEquals(toString, order.toString());
	}
}
