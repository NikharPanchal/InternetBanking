package com.internetbanking.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internetbanking.bean.Customer;
import com.internetbanking.bean.NetBanking;
import com.internetbanking.dao.NetBankingDao;
import com.internetbanking.dao.impl.NetBankingDaoImpl;
import com.internetbanking.service.NetBankingService;

/**
 * @objective
 * @Developer Nikhar
 * @Date 18-Jun-2022
 */
public class NetBankingServiceImpl implements NetBankingService {
	NetBankingDao nd = new NetBankingDaoImpl();

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/internetbanking", "root",
					"root");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int saveInternetBankingData(Customer customer, NetBanking netbanking) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = nd.insertNetbankingDetails(connection, customer, netbanking);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int checkAadharNumber(String aadhar_no) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = nd.checkAadharNo(connection, aadhar_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkAccountNumber(String account_no) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = nd.checkAccountNo(connection, account_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NetBanking checkNetBankingLoginData(NetBanking netbanking) {
		NetBanking netBanking = new NetBanking();
		try (Connection connection = getConnection()) {
			netBanking = nd.checkNetBankingLoginData(connection, netbanking);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return netBanking;
	}

	@Override
	public List<NetBanking> fetchNetBankingUserList() {
		List<NetBanking> netBanking = new ArrayList<NetBanking>();
		try (Connection connection = getConnection()) {
			netBanking = nd.getNetBankingCustomerList(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return netBanking;
	}

	@Override
	public int updateNetBankingStatus(int netbankingId) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result=nd.updateNetBankingStatus(connection,netbankingId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int checkAccountNumberNetBanking(String account_no,String loginAccountNo) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = nd.checkAccountNoNetBanking(connection, account_no,loginAccountNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteTransactionDetails(String tran_id) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result=nd.deleteTransactionData(connection,tran_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
