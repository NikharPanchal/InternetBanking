package com.internetbanking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.internetbanking.bean.Customer;
import com.internetbanking.service.CustomerService;
import com.internetbanking.service.impl.CustomerServiceimpl;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService cs = new CustomerServiceimpl();

	public UserRegistrationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email=request.getParameter("email");
		
		int ans=cs.checkEmailExit(email);
		if(ans==0)
		{
			response.getWriter().append("false");
		}
		else
		{
			response.getWriter().append("true");
		}
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer customer = new Customer();

		String username = request.getParameter("val-username");
		String email = request.getParameter("val-email");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String aadhar_no = request.getParameter("aadhaar");
		String phone_no = request.getParameter("val-digits");
		String gender = request.getParameter("gender");
		Part part = request.getPart("photo");
		if (null != part) {
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			customer.setImage_stream(part.getInputStream());
		}
		customer.setCust_name(username);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setDob(dob);
		customer.setAadharno(aadhar_no);
		customer.setPhoneno(phone_no);
		customer.setGender(gender);

		System.out.println(username);
		System.out.println(email);
		System.out.println(address);
		System.out.println(dob);
		System.out.println(aadhar_no);
		System.out.println(phone_no);
		System.out.println(gender);

		int result = cs.saveCustomerInformation(customer);
		if (result > 0) {
			
			System.out.println("insert data sucessful..");
			request.setAttribute("registermsg","Customer Registration Sucess");
			RequestDispatcher dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("insert user data failed..");
			request.setAttribute("registermsg","Customer Registration Falied");
			RequestDispatcher dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
	}

}
