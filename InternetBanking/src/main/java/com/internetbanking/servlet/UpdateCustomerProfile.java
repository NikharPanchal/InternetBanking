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

/**
 * Servlet implementation class UpdateCustomerProfile
 */
public class UpdateCustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerService cs=new CustomerServiceimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer=new Customer();
		String userId=request.getParameter("custId");
		String userName=request.getParameter("val-username");
		String userEmail=request.getParameter("val-email");
		String address=request.getParameter("address");
		String contact=request.getParameter("val-phoneus");
		Part part=request.getPart("photo");
		if (null != part && part.getSize()>0) {
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			customer.setImage_stream(part.getInputStream());
		}
		customer.setCust_name(userName);
		customer.setCust_id(Integer.parseInt(userId));
		customer.setEmail(userEmail);
		customer.setAddress(address);
		customer.setPhoneno(contact);
		
		
		int ans=cs.updateCustomerDetails(customer);
		
		if(ans>0)
		{
			System.out.println("Customer Details update Sucess...");
			request.setAttribute("customerUpdate","Update Sucess...");
			RequestDispatcher dispatcher =request.getRequestDispatcher("Profile.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			System.out.println("Customer Details update failed...");
			request.setAttribute("customerUpdate","Update falied...");
			RequestDispatcher dispatcher =request.getRequestDispatcher("Profile.jsp");
			dispatcher.forward(request, response);
		}
	}

}
