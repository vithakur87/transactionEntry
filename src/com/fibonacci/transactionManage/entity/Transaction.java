package com.fibonacci.transactionManage.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * This class based demonstration contains details of Transaction made
 * 
 */
public class Transaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int transactionId;
	private int customerId;
	private String transactionName;
	private double transactionAmount;
	private Date transactionDate;
	
	public Transaction(String transactionName, double transactionAmount) {
		this.transactionName = transactionName;
		this.transactionAmount = transactionAmount;
	}
  
	public Transaction(int transactionId, String transactionName, double transactionAmount, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}
  
	public Transaction(String transactionName,int customerId , double transactionAmount, Date transactionDate) {
		this.customerId = customerId;
		this.transactionName = transactionName;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionName() {
		return transactionName;
	}
  
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
  
	public double getTransactionAmount() {
		return transactionAmount;
	}
  
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
  
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
  
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", transactionName="
				+ transactionName + ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ "]";
	}
}
