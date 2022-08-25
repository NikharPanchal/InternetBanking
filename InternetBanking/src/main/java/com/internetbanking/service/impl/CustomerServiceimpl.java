package com.internetbanking.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Customer;
import com.internetbanking.bean.User;
import com.internetbanking.dao.CustomerDao;
import com.internetbanking.dao.impl.CustomerDaoImpl;
import com.internetbanking.service.CustomerService;

/**
 * @objective
 * @Developer Nikhar
 * @Date 12-Jun-2022
 */
public class CustomerServiceimpl implements CustomerService {
	CustomerDao cd = new CustomerDaoImpl();

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/internetbanking", "root",
					"root");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public User fetchLoginData(User user) {

		User u = new User();
		try (Connection connection = getConnection()) {
			u = cd.checkLoginData(connection, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int saveCustomerInformation(Customer customer) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = cd.saveCustomerDetails(connection, customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Customer> fetchCustomerDetails() {
		List<Customer> custList = new ArrayList<Customer>();
				try(Connection connection=getConnection()) {
					custList=cd.getCustomerDetails(connection);
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
		
		return custList;
	}

	@Override
	public int saveCustomerAccountDetails(Account account) {
		int result=0;
		try (Connection connection = getConnection()) {
			return result=cd.openCustomeraccount(connection, account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int checkEmailExit(String email) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = cd.checkEmailAddress(connection,email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int deleteCustomerDetails(int cust_id) {
		int result=0;
		try(Connection connection=getConnection()){
			result=cd.updateCustomerDetails(connection,cust_id);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomerDetails(Customer customer) {
		int ans=0;
		try(Connection connection=getConnection()){
			ans=cd.editCustomerDetails(connection,customer);
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return ans;
	}
}
