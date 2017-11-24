
package com.fibonacci.transactionManage.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.fibonacci.transactionManage.entity.Customer;
import com.fibonacci.transactionManage.entity.Transaction;
import com.fibonacci.transactionManage.exceptions.CustomerException;
import com.fibonacci.transactionManage.utils.CustomerFactory;

public class CustomerDao implements ICustomerDao {
	
	CustomerFactory factory=null;
	DataSource ds=null;
	public CustomerDao() throws CustomerException {
		
		factory = new CustomerFactory();
		ds=factory.getClientDataSource();
	}

	@Override
	public int updateCustomer(Customer customer) {
		int updated=0;
		try (
				Connection connect = ds.getConnection();
				PreparedStatement prepareStatement = connect.prepareStatement("INSERT INTO CUSTOMER_MASTER(CUSTOMERID,CUSTOMERNAME) VALUES"
						+ "(CUSTOMERID_SEQ.nextval,?)");
		){
			prepareStatement.setString(1, customer.getCustomerName());
			updated = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public ArrayList<Transaction> getCustomerTransactionDetails(int customerId) {
		
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		ResultSet resultList=null;
		try (
				Connection connect = ds.getConnection();
				PreparedStatement prepareStatement = connect.prepareStatement("SELECT TRANSACTIONID,TRANSACTIONNAME,"
						+ "TRANSACTIONAMOUNT,TRANSACTIONDATE FROM TRANSACTION_NOVEMBER WHERE CUSTOMERID=?");
		){
			prepareStatement.setInt(1, customerId);
			resultList = prepareStatement.executeQuery();
			while(resultList.next()) {
				int transId = resultList.getInt(1);
				String transName = resultList.getString(2);
				double transAmount = resultList.getDouble(3);
				Date transDate = resultList.getDate(4);
				
				Transaction transaction = new Transaction(transId, transName, transAmount, transDate);
				
				transactionList.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(!resultList.isClosed()) {
					resultList.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return transactionList;
	}

	@Override
	public int updateTransaction(Transaction transaction,int customerId) {
		
		int updated=0;
		
		try (
				Connection connect = ds.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO TRANSACTION_NOVEMBER(TRANSACTIONID,CUSTOMERID,"
						+ "TRANSACTIONNAME,TRANSACTIONAMOUNT,TRANSACTIONDATE)"
						+ "VALUES(TRANSACTIONID_SEQ.nextval,?,?,?,(SELECT SYSDATE FROM DUAL))");
		){
			preparedStatement.setInt(1, customerId);
			preparedStatement.setString(2, transaction.getTransactionName());
			preparedStatement.setDouble(3, transaction.getTransactionAmount());
			
			updated = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public Customer getCustomerDetail(int customerId) {
		
		Customer customer=null;
		ResultSet resultSet=null; 
		try (
				Connection connect = ds.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement("SELECT CUSTOMERNAME FROM CUSTOMER_MASTER WHERE CUSTOMERID = ?");
		){
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String customerName = resultSet.getString(1);
				customer = new Customer(customerId, customerName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return customer;
	}

	@Override
	public Transaction getTransactionDetail(int transactionId) {
		ResultSet resultSet=null;
		Transaction transaction=null;	
		try (	
				Connection connect = ds.getConnection();
				PreparedStatement statement = connect.prepareStatement("SELECT CUSTOMERID,TRANSACTIONNAME,"
						+ "TRANSACTIONAMOUNT,TRANSACTIONDATE FROM TRANSACTION_NOVEMBER WHERE TRANSACTIONID=?");
			){
			statement.setInt(1, transactionId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int customerId = resultSet.getInt(1);
				String transactionName = resultSet.getString(2);
				double transactionAmount = resultSet.getDouble(3);
				Date transactionDate = resultSet.getDate(4);
				transaction = new Transaction(transactionName,customerId, transactionAmount, transactionDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return transaction;
	}

}
