package com.internetbanking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Customer;
import com.internetbanking.bean.User;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 12-Jun-2022
*/
public interface CustomerDao {

	User checkLoginData(Connection connection, User user) throws SQLException;

	int saveCustomerDetails(Connection connection, Customer customer) throws SQLException;

	List<Customer> getCustomerDetails(Connection connection) throws SQLException;

	int openCustomeraccount(Connection connection, Account account) throws SQLException;

	int checkEmailAddress(Connection connection, String email) throws SQLException;

	int updateCustomerDetails(Connection connection, int cust_id) throws SQLException;

	int editCustomerDetails(Connection connection, Customer customer)  throws SQLException;

}
