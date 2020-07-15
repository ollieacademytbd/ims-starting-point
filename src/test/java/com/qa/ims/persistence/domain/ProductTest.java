package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product product;
	private Product other;

	@Before
	public void setUp() {
		product = new Product(1L, "Chips", 3.10);
		other = new Product(1L, "Chips", 3.10);
	}

	@Test
	public void settersTest() {
		assertNotNull(product.getProduct_id());
		assertNotNull(product.getProduct_name());
		assertNotNull(product.getPrice());

		product.setProduct_id(null);
		assertNull(product.getProduct_id());
		product.setProduct_name(null);
		assertNull(product.getProduct_name());
		product.setPrice((Double) null);
		assertNull(product.getPrice());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(product.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(product.equals(new Object()));
	}

	@Test
	public void createProductWithId() {
		assertEquals(1L, product.getProduct_id(), 0);
		assertEquals("Chips", product.getProduct_name());
		assertEquals(3.10, product.getPrice(), 0);
	}

	@Test
	public void checkEquality() {
		assertTrue(product.equals(product));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(product.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		product.setProduct_name(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setProduct_name("Cheese");
		assertFalse(product.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		product.setProduct_name(null);
		other.setProduct_name(null);
		assertTrue(product.equals(other));
	}

	@Test
	public void nullId() {
		product.setProduct_id(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		product.setProduct_id(null);
		other.setProduct_id(null);
		assertTrue(product.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setProduct_id(2L);
		assertFalse(product.equals(other));
	}

	@Test
	public void nullSurname() {
		product.setPrice(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void nullSurnameOnBoth() {
		product.setPrice(null);
		other.setPrice(null);
		assertTrue(product.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setPrice(2.0);
		assertFalse(product.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Product product = new Product("Chips", 3.10);
		assertNull(product.getProduct_id());
		assertNotNull(product.getProduct_name());
		assertNotNull(product.getPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(product.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Product product = new Product(null, null);
		Product other = new Product(null, null);
		assertEquals(product.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 first name:Chips Price: 3.10";
		assertEquals(toString, product.toString());
	}
}
