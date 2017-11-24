package com.fibonacci.transactionManage.services;

import java.util.ArrayList;

import com.fibonacci.transactionManage.daos.CustomerDao;
import com.fibonacci.transactionManage.daos.ICustomerDao;
import com.fibonacci.transactionManage.entity.Customer;
import com.fibonacci.transactionManage.entity.Transaction;
import com.fibonacci.transactionManage.exceptions.CustomerException;

public class CustomerService implements ICustomerService {

	ICustomerDao dao=null;
	
	public CustomerService() throws CustomerException {
		dao = new CustomerDao();
	}

	@Override
	public int updateCustomer(Customer customer) {
		
		return dao.updateCustomer(customer);
	}

	@Override
	public ArrayList<Transaction> getCustomerTransactionDetails(int customerId) {
		
		return dao.getCustomerTransactionDetails(customerId);
	}

	@Override
	public int updateTransaction(Transaction transaction,int customerId) {
		
		return dao.updateTransaction(transaction,customerId);
	}

	@Override
	public Customer getCustomerDetail(int customerId) {
		
		return dao.getCustomerDetail(customerId);
	}

	@Override
	public Transaction getTransactionDetail(int transactionId) {
		
		return dao.getTransactionDetail(transactionId);
	}

}
