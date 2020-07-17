package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao2;
import com.qa.ims.persistence.domain.OrderLine;

public class OrderLineServices implements CrudServices2<OrderLine> {

	private Dao2<OrderLine> orderLineDao;

//
//	public OrderLineServices(OrderLineDaoMysql orderlineDaoMysql) {
//		this.orderlineDao = orderlineDaoMysql;

	public OrderLineServices(Dao2<OrderLine> orderLineDao) {
		this.orderLineDao = orderLineDao;
	}

	@Override
	public List<OrderLine> readAll(Long id) {
		return orderLineDao.readAll(id);
	}

	@Override
	public OrderLine create(OrderLine orderline) {
		// TODO Auto-generated method stub
		return orderLineDao.create(orderline);
	}

	@Override
	public OrderLine update(OrderLine orderline) {
		// TODO Auto-generated method stub
		return orderLineDao.update(orderline);
	}

	@Override
	public void delete(Long line_id) {
		// TODO Auto-generated method stub
		orderLineDao.delete(line_id);

	}

	@Override
	public List<OrderLine> realAll(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	}
//
//	public List<OrderLine> readAll() {
//		return orderlineDao.readAll();
//	}
//
//	public OrderLine create(OrderLine orderline) {
//		return orderlineDao.create(orderline);
//	}
//
//	public OrderLine update(OrderLine orderline) {
//		return orderlineDao.update(orderline);
//	}
//
//	public void delete(Long id) {
//		orderlineDao.delete(id);
//	}

//	@Override
//	public List<OrderLine> realAll(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<OrderLine> readAll(Long orderline_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
