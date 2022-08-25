package com.internetbanking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.bean.Transaction;
import com.internetbanking.service.AccountService;
import com.internetbanking.service.impl.AccountServiceImpl;
import com.internetbanking.util.TransactionId;

/**
 * Servlet implementation class TransferMoneyServlet
 */
public class TransferMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountService accountService = new AccountServiceImpl();

	public TransferMoneyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Transaction transaction = new Transaction();

		TransactionId id = new TransactionId();
		String randomId = id.generateID();
		String toaccountNumber = request.getParameter("val-digits-account");
		String fromaccountNumber = request.getParameter("val-digits-from-account");
		int amount = Integer.parseInt(request.getParameter("val-digits-amount"));

		int availBalance = accountService.checkAvailBalance(fromaccountNumber);
		System.out.println("Available Balance :-"+availBalance);
		System.out.println("Entered Amount"+amount);
		if (availBalance > 0 && availBalance>=amount) {

			transaction.setTransactionId(randomId);
			transaction.setToAccountNumber(Integer.parseInt(toaccountNumber));
			transaction.setFromAccountNumber(Integer.parseInt(fromaccountNumber));
			transaction.setAmount(amount);

			transaction.setDate((new java.util.Date()).toLocaleString());

			int result = accountService.insertTrasactionDetails(transaction);

			if (result > 0) {
				
				accountService.updateTransferAmount(transaction);
				
				System.out.println("Money Transfer Sucessfull");
				request.setAttribute("trasactionStatus", "Money Transfer Sucess");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("Transfer-Money.jsp");
				requestDispatcher.forward(request, response);
			} else {
				System.out.println("Money Transfer failed...");
				request.setAttribute("trasactionStatus", "Money Transfer failed...");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("Transfer-Money.jsp");
				requestDispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("trasactionStatus", "Sorry...Insufficient Balance");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Transfer-Money.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("insufficient Balance");
		}
	}

}
