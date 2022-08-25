package com.internetbanking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.bean.Account;
import com.internetbanking.service.AccountService;
import com.internetbanking.service.impl.AccountServiceImpl;


public class FetchOpenedAccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountService ac=new AccountServiceImpl();
	
    public FetchOpenedAccountDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Account> accountList=ac.getOpenAccountDetails();
		
		System.out.println(accountList.toString());
		
		request.setAttribute("accountList", accountList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
