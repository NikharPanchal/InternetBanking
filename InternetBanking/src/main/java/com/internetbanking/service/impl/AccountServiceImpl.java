package com.internetbanking.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Transaction;
import com.internetbanking.dao.AccountDao;
import com.internetbanking.dao.impl.AccountDaoImpl;
import com.internetbanking.service.AccountService;

/**
 * @objective
 * @Developer Nikhar
 * @Date 01-Jul-2022
 */
public class AccountServiceImpl implements AccountService {
	AccountDao accountDao = new AccountDaoImpl();

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
	public List<Account> getOpenAccountDetails() {
		List<Account> accountList = new ArrayList<>();

		try (Connection connection = getConnection()) {
			accountList = accountDao.fetchActiveAccountDetails(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accountList;
	}

	@Override
	public int deleteAccountDetails(int accountNo) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = accountDao.deactivateOpenedAccount(connection, accountNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insertTrasactionDetails(Transaction transaction) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = accountDao.transferMoney(connection, transaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int checkAvailBalance(String fromaccountNumber) {
		int result = 0;
		try (Connection connection = getConnection()) {
			result = accountDao.checkAvailBalance(connection, fromaccountNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void updateTransferAmount(Transaction transaction) {
		try (Connection connection = getConnection()) {
			accountDao.updateBalanceAferTransaction(connection, transaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> fetchTransactionDetails() {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		try (Connection connection = getConnection()) {
			transactionList = accountDao.getAllTransactionDetails(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionList;
	}
}
