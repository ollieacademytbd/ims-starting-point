package com.qa.ims.persistence.dao;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;

public interface Dao<T> {

	List<T> readAll();

	T create(T t);

	T update(T t);

	void delete(long id);
//	void delete(Long cusotmer_id);

	/**
	 * Deletes a customer in the database
	 *
	 * @param id - id of the customer
	 */
	Customer delete(Customer customer);
}
