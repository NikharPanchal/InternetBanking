package com.internetbanking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetbanking.service.NetBankingService;
import com.internetbanking.service.impl.NetBankingServiceImpl;

public class DeleteNetbankingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NetBankingService ns=new NetBankingServiceImpl();
       
    public DeleteNetbankingDetails() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		int result=ns.updateNetBankingStatus(Integer.parseInt(id));
		
		response.sendRedirect("NetBankingList.jsp");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}