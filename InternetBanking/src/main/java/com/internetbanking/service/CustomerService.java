package com.internetbanking.service;

import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Customer;
import com.internetbanking.bean.User;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 12-Jun-2022
*/
public interface CustomerService {

	User fetchLoginData(User user);

	int saveCustomerInformation(Customer customer);

	List<Customer> fetchCustomerDetails();

	int saveCustomerAccountDetails(Account account);

	int checkEmailExit(String email);

	int deleteCustomerDetails(int parseInt);

	int updateCustomerDetails(Customer customer);

}
