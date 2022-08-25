package com.internetbanking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internetbanking.bean.Customer;
import com.internetbanking.bean.NetBanking;
import com.internetbanking.dao.NetBankingDao;

/**
 * @objective
 * @Developer Nikhar
 * @Date 18-Jun-2022
 */
public class NetBankingDaoImpl implements NetBankingDao {

	@Override
	public int insertNetbankingDetails(Connection connection, Customer customer, NetBanking netbanking)
			throws SQLException {
		int ans = 0;
		String insertquery = "insert into netbanking(customer_aadhar_no,customer_contact,account_no,password) values(?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertquery)) {
			//ps.setString(1, netbanking.getCust_id());
			ps.setString(1, netbanking.getAadhar_no());
			ps.setString(2, netbanking.getContact());
			ps.setInt(3, netbanking.getAccount_no());
			ps.setString(4, netbanking.getPassword());
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public int checkAadharNo(Connection connection, String aadhar_no) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement("select * from customer");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				if (aadhar_no.equals(resultset.getString("customer_aadhar_no")) && resultset.getInt("status") == 1) {
					ans = 1;
					break;
				}
			}

		}
		return ans;
	}

	@Override
	public int checkAccountNo(Connection connection, String account_no) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement("select * from account");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				if (account_no.equals(resultset.getString("account_no")) && resultset.getInt("status") == 1) {
					ans = 1;
					break;
				}
			}

		}
		return ans;
	}

	@Override
	public NetBanking checkNetBankingLoginData(Connection connection, NetBanking netBanking) throws SQLException {
		NetBanking banking = new NetBanking();
		try (PreparedStatement ps = connection.prepareStatement("select * from netbanking where status=1");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				String customer_name = resultset.getString("customer_name");
				String customer_aadhar_no = resultset.getString("customer_aadhar_no");
				String customer_contact = resultset.getString("customer_contact");
				int account_no = resultset.getInt("account_no");
				String password = resultset.getString("password");
				System.out.println(account_no+" : "+netBanking.getAccount_no());
				System.out.println(password+" : "+netBanking.getPassword());
				System.out.println(password);
				if (account_no==netBanking.getAccount_no() && password.equals(netBanking.getPassword())) {

					  banking.setAccount_no(account_no); 
					  banking.setPassword(password);
					  banking.setCust_id(customer_name); 
					  banking.setAadhar_no(customer_aadhar_no);
					  banking.setContact(customer_contact);
					  banking.setRole("Customer");
					  System.out.println("in dao impl");
						System.out.println(customer_name);
						System.out.println(customer_aadhar_no);
						System.out.println(customer_contact);
						System.out.println(account_no);
						System.out.println(password);
						System.out.println("Dao impl close");
					 
				}
			}
		}

		return banking;
	}

	@Override
	public List<NetBanking> getNetBankingCustomerList(Connection connection) throws SQLException {
		List<NetBanking> netBankingList = new ArrayList<NetBanking>();
		try (PreparedStatement ps = connection.prepareStatement("select * from netbanking");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				NetBanking n = new NetBanking();
				n.setNetBankingId(resultset.getInt(1));
				n.setAadhar_no(resultset.getString(3));
				n.setContact(resultset.getString(4));
				n.setAccount_no(resultset.getInt(5));
				n.setPassword(resultset.getString(6));
				n.setStatus(resultset.getInt(7));
				netBankingList.add(n);
			}
		}
		return netBankingList;
	}

	@Override
	public int updateNetBankingStatus(Connection connection, int netbankingId) throws SQLException {
		int result=0;
		try(PreparedStatement ps=connection.prepareStatement("update netbanking set status=0 where netbanking_id=?")){
			ps.setInt(1, netbankingId);
			
			result=ps.executeUpdate();
		}
		
		return result;
	}

	@Override
	public int checkAccountNoNetBanking(Connection connection, String account_no,String loginAccountNo) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement("select * from netbanking");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				if (account_no.equals(resultset.getString("account_no")) && resultset.getInt("status") == 1 && !account_no.equals(loginAccountNo)) {		
					ans = 1;
					break;		
				}
			}

		}
		return ans;
	}

	@Override
	public int deleteTransactionData(Connection connection, String tran_id) throws SQLException {
		int result=0;
		try(PreparedStatement ps=connection.prepareStatement("update transaction set status=0 where transaction_id=?")){
			ps.setString(1, tran_id);
			
			result=ps.executeUpdate();
		}
		
		return result;
	}
}
