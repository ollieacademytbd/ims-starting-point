package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long product_id;
	private Long quantity;
	private Double total;

	public Order(Long order_id, Long customer_id, Long product_id, Long quantity, Double total) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.total = total;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Order(Long customer_id, Long product_id, Long quantity) {
		super();
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	public Order(Long order_id, Double total) {
		// TODO Auto-generated constructor stub

		super();
		this.order_id = order_id;
		this.total = total;

	}

	public Order(Long order_id, Long customer_id, Long quantity, Double total) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.total = total;
	}

	public Order(Long customer_id, Long quantity, Double total) {
		super();
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.total = total;
	}

	public String toString() {
		return "Order ID: " + order_id + " Customer ID: " + customer_id + " Quantity: " + quantity + " Total: " + total;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
