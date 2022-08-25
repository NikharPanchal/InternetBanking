package com.internetbanking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.internetbanking.bean.Customer;
import com.internetbanking.bean.NetBanking;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 18-Jun-2022
*/
public interface NetBankingDao {

	int insertNetbankingDetails(Connection connection, Customer customer, NetBanking netbanking) throws SQLException;

	int checkAadharNo(Connection connection, String aadhar_no) throws SQLException;

	int checkAccountNo(Connection connection, String account_no) throws SQLException;

	NetBanking checkNetBankingLoginData(Connection connection, NetBanking netBanking) throws SQLException;

	List<NetBanking> getNetBankingCustomerList(Connection connection) throws SQLException;

	int updateNetBankingStatus(Connection connection, int netbankingId) throws SQLException;

	int checkAccountNoNetBanking(Connection connection, String account_no, String loginAccountNo) throws SQLException;

	int deleteTransactionData(Connection connection, String tran_id) throws SQLException;
	
}
