package com.internetbanking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.service.CustomerService;
import com.internetbanking.service.impl.CustomerServiceimpl;

/**
 * Servlet implementation class DeleteCustomerDetails
 */
public class DeleteCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerService cs=new CustomerServiceimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String custId=request.getParameter("id");
		System.out.println("Delete id "+custId);
		
		int result=cs.deleteCustomerDetails(Integer.parseInt(custId));
		//System.out.println("Deletion result :-"+result);
		
			System.out.println("Customer Details deleted..");
			response.sendRedirect("CustomerList.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
