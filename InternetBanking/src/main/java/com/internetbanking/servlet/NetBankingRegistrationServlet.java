package com.internetbanking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.bean.Customer;
import com.internetbanking.bean.NetBanking;
import com.internetbanking.service.NetBankingService;
import com.internetbanking.service.impl.NetBankingServiceImpl;


public class NetBankingRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NetBankingService ns=new NetBankingServiceImpl();
    public NetBankingRegistrationServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String aadhar_no=request.getParameter("aadhar");
		String account_no=request.getParameter("account");
		String netbankingaccount_no=request.getParameter("accountNetBanking");
		String loginAccountNo=request.getParameter("loginAccountNo");
		System.out.println(aadhar_no);
		System.out.println(account_no);
		System.out.println("Login Account no "+loginAccountNo);
		if(aadhar_no!=null) {
			int result=ns.checkAadharNumber(aadhar_no);
			if(result==0) {
				response.getWriter().append("false");
			}else
			{
				response.getWriter().append("true");
			}
		}
		if(account_no!=null)
		{
			int account_result=ns.checkAccountNumber(account_no);
			if(account_result==0) {
				response.getWriter().append("false");
			}else
			{
				response.getWriter().append("true");
			}
		}
		if(netbankingaccount_no!=null)
		{
			int account_result=ns.checkAccountNumberNetBanking(netbankingaccount_no,loginAccountNo);
			if(account_result==0) {
				response.getWriter().append("false");
			}else
			{
				response.getWriter().append("true");
			}
		}
		
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NetBanking netbanking=new NetBanking();
		Customer customer=new Customer();
//		String cust_name=request.getParameter("val-username");
		String cust_email=request.getParameter("val-email");
		String aadhar_no=request.getParameter("val-digits-aadhaar");
		String account_no=request.getParameter("val-digits-account");
		String contact_no=request.getParameter("val-digits");
		String password=request.getParameter("val-password");
		
//		netbanking.setCust_id(cust_name);
		netbanking.setEmail(cust_email);
		netbanking.setAadhar_no(aadhar_no);
		netbanking.setContact(contact_no);
		netbanking.setPassword(password);
		netbanking.setCustomer(customer);
		netbanking.setAccount_no(Integer.parseInt(account_no));
		
//		System.out.println(cust_name);
		System.out.println("-"+netbanking.getAccount_no());
		System.out.println(cust_email);
		System.out.println(aadhar_no);
		System.out.println(contact_no);
		System.out.println(password);
		
		int result=ns.saveInternetBankingData(customer,netbanking);
		
		System.out.println(netbanking.toString());
		if(result>0)
		{
			System.out.println("Netbanking registration sucessfull...");
			request.setAttribute("loginfailed","Registration Sucess..");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("Netbanking registration failed...");
			request.setAttribute("loginfailed","Registration Falied...");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
