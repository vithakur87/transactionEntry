package com.fibonacci.transactionManage.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.fibonacci.transactionManage.exceptions.CustomerException;

import oracle.jdbc.pool.OracleDataSource;

public class CustomerFactory {
	
	CustomerProperties props=null;
	DataSource source=null;
	public CustomerFactory(){
		// TODO Auto-generated constructor stub
		try {
			props = new CustomerProperties();
			OracleDataSource ds = new OracleDataSource();
			ds.setURL(props.getDbConnectionPropertyByName("url"));
			ds.setPortNumber(Integer.parseInt(props.getDbConnectionPropertyByName("portNumber")));
			ds.setUser(props.getDbConnectionPropertyByName("userName"));
			ds.setPassword(props.getDbConnectionPropertyByName("password"));
			source=ds;
		} catch (CustomerException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public DataSource getClientDataSource() throws CustomerException {
		if(source!=null)
			return source;
		else 
			throw new CustomerException("No resource found in database connection source");
	}
}
