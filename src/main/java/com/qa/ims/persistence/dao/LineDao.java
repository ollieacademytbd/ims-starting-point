package com.qa.ims.persistence.dao;

import java.util.List;

public interface LineDao<T> {

	List<T> readAll(Long id);

	T create(T t);

	T update(T t);

	void delete(long orderline_id);

	/**
	 * Reads all customers from the database
	 *
	 * @return A list of customers
	 */

}
