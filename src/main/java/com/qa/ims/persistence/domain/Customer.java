package com.qa.ims.persistence.domain;

public class Customer {

	private Long customer_id;
	private String firstName;
	private String lastName;

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(Long customer_id, String firstName, String lastName) {
		this.customer_id = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setId(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return "Customer ID: " + customer_id + " First Name: " + firstName + " Last Name: " + lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
