package com.internetbanking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.service.AccountService;
import com.internetbanking.service.impl.AccountServiceImpl;

public class DeactivateOpenedAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AccountService accountService=new AccountServiceImpl();
	
    public DeactivateOpenedAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNo=request.getParameter("id");
		System.out.println(accountNo);
		int result=accountService.deleteAccountDetails(Integer.parseInt(accountNo));
		if(result>0)
		{
			System.out.println("deactivate account sucess");
		}
		else	
		{
			System.out.println("deactivate account failed..");
		}
		response.sendRedirect("OpenedAccount.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
