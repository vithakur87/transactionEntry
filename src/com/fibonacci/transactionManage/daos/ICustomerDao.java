package com.fibonacci.transactionManage.daos;

import java.util.ArrayList;

import com.fibonacci.transactionManage.entity.Customer;
import com.fibonacci.transactionManage.entity.Transaction;

public interface ICustomerDao {
	
	public int updateCustomer(Customer customer);
	public ArrayList<Transaction> getCustomerTransactionDetails(int customerId);
	public int updateTransaction(Transaction transaction,int customerId);
	public Customer getCustomerDetail(int customerId);
	public Transaction getTransactionDetail(int transactionId);
	
}
