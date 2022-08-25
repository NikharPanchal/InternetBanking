package com.internetbanking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.bean.Customer;
import com.internetbanking.service.CustomerService;
import com.internetbanking.service.impl.CustomerServiceimpl;

public class FetchRegisterUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerService cs=new CustomerServiceimpl();
  
    public FetchRegisterUserDetails() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customer> customerList= cs.fetchCustomerDetails();
		
		request.setAttribute("customerList", customerList);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
