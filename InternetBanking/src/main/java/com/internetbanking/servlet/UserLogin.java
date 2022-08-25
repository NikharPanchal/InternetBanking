package com.internetbanking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internetbanking.bean.NetBanking;
import com.internetbanking.service.CustomerService;
import com.internetbanking.service.NetBankingService;
import com.internetbanking.service.impl.CustomerServiceimpl;
import com.internetbanking.service.impl.NetBankingServiceImpl;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService cs = new CustomerServiceimpl();
	NetBankingService ns=new NetBankingServiceImpl();

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("Admin") && password.equals("Admin")) {
			NetBanking netbanking=new NetBanking();
		
			netbanking.setRole("Admin");
			System.out.println("username" + username);
			System.out.println("password" + password);

			//User u = cs.fetchLoginData(user);

			if (username != null && password != null && netbanking.getRole().equals("Admin")) {

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("loginDetails", netbanking);
				RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
				dispacher.forward(request, response);
			} else {
				System.out.println("Login Detail did not match");

				request.setAttribute("loginfailed", "Username or password did not match..!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);

			}

		}
		else if(!username.equals("Admin") && !password.equals("Admin"))
		{
			NetBanking netbanking=new NetBanking();
			netbanking.setAccount_no(Integer.parseInt(username));
			netbanking.setPassword(password);
			netbanking.setRole("Customer");
			System.out.println("Servlet:"+username);
			System.out.println("Servlet:"+password);
			
			
			NetBanking nb=ns.checkNetBankingLoginData(netbanking);
			//System.out.println("NetBanking bean :  "+nb.toString());
			
			if(nb.getAccount_no()!=0 && nb.getPassword()!=null && netbanking.getRole().equals("Customer"))
			{
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("loginDetails", nb);
				RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
				dispacher.forward(request, response);
			}
			else
			{
				System.out.println("Login Detail did not match for netbanking");
				request.setAttribute("loginfailed", "Username or password did not match..!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);	
			}	
		}
	}
}