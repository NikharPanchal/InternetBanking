package com.internetbanking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.internetbanking.bean.NetBanking;
import com.internetbanking.service.NetBankingService;
import com.internetbanking.service.impl.NetBankingServiceImpl;
  
/**
 * Servlet implementation class FetchNetBankingDetailsServlet
 */
public class FetchNetBankingDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    NetBankingService ns=new NetBankingServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchNetBankingDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NetBanking> netBankingList=new ArrayList<NetBanking>();
		
		netBankingList=ns.fetchNetBankingUserList();
		
		request.setAttribute("netBankingList", netBankingList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
