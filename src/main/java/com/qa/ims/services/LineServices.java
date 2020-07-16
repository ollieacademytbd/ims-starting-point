package com.qa.ims.services;

import java.util.List;

public interface LineServices<OrderLine> {

	public List<OrderLine> realAll(Long id);

	OrderLine create(OrderLine orderline);

	OrderLine update(OrderLine orderline);

	void delete(Long line_id);

	public List<com.qa.ims.persistence.domain.OrderLine> readAll(Long orderline_id);

}
