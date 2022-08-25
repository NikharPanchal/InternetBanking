package com.internetbanking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.service.NetBankingService;
import com.internetbanking.service.impl.NetBankingServiceImpl;

/**
 * Servlet implementation class DeleteTransactionDetails
 */
public class DeleteTransactionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    NetBankingService bankingService=new NetBankingServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTransactionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transaction_id=request.getParameter("id");
		
		int result=bankingService.deleteTransactionDetails(transaction_id);
		
		if(result>0)
		{
			System.out.println("Delete transaction details Sucess..");
			response.sendRedirect("CustomerTransaction.jsp");
		}
		else
		{
			System.out.println("Delete transaction details failed..");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
