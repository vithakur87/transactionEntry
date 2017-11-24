package com.fibonacci.transactionManage.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.fibonacci.transactionManage.exceptions.CustomerException;

public class CustomerProperties {
	
	private Properties props=null;
	
	public CustomerProperties() throws CustomerException{
		props = new Properties();
		try {
			InputStream is = new FileInputStream("dbConnection.properties");
			props.load(is);
		}catch(FileNotFoundException e) {
			throw new CustomerException("The file you are requesting cannot be found",e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getDbConnectionPropertyByName(String key) throws CustomerException {
		if(!props.containsKey(key))
			throw new CustomerException("Invalid Property Name");
		else
			return props.getProperty(key);
	}
}
