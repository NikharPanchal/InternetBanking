package com.internetbanking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.bean.Account;
import com.internetbanking.service.CustomerService;
import com.internetbanking.service.impl.CustomerServiceimpl;


public class OpenUserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerService cs=new CustomerServiceimpl();
    
    public OpenUserAccount() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account=new Account();
		
		int cust_name=Integer.parseInt(request.getParameter("val-custname"));
		String account_type=request.getParameter("val-accounttype");
		int amount=Integer.parseInt(request.getParameter("val-digits"));
		
		
		account.setCustomer_id(cust_name);
		account.setAccount_type(account_type);
		account.setAmount(amount);
		
		System.out.println(cust_name);
		System.out.println(account_type);
		System.out.println(amount);
		
		int result=cs.saveCustomerAccountDetails(account);
		System.out.println("open account result val"+result);
		if(result>0)
		{
			System.out.println("customer account open sucess");
			request.setAttribute("accountstatus", "Account Open Sucess");
			request.setAttribute("result", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("openaccount.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("Customer account open failed");
			request.setAttribute("accountstatus", "Account is already Opened ");
			request.setAttribute("result", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("openaccount.jsp");
			dispatcher.forward(request, response);
		}
	}
}