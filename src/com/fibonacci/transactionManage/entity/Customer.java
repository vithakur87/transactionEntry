package com.fibonacci.transactionManage.entity;

import java.io.Serializable;

/**
 * 
 * @author Vikas Thakur
 *
 *This class contains details of the customer
 */

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int customerId;
	private String customerName;
	
	public Customer() {
		
	}
	
	public Customer(String customerName) {
		
		this.customerName = customerName;
	}
	
	

	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

}
