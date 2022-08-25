package com.internetbanking.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Transaction;
import com.internetbanking.dao.AccountDao;

/**
 * @objective
 * @Developer Nikhar
 * @Date 01-Jul-2022
 */
public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> fetchActiveAccountDetails(Connection connection) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();

		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				Account account = new Account();
				account.setAccount_no(resultSet.getInt(1));
				account.setCustomer_id(resultSet.getInt(2));
				account.setAccount_type(resultSet.getString(3));
				account.setAmount(resultSet.getInt(4));
				account.setStatus(resultSet.getInt(5));

				accountList.add(account);
			}

		}

		return accountList;
	}

	@Override
	public int deactivateOpenedAccount(Connection connection, int accountNo) throws SQLException {
		int result = 0;
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("update account set status=0 where account_no=?")) {
			preparedStatement.setInt(1, accountNo);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int transferMoney(Connection connection, Transaction transaction) throws SQLException {
		int result = 0;
		try (PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into transaction(transaction_id,to_account_no,from_account_no,amount,date) values(?,?,?,?,?) ")) {

			preparedStatement.setString(1, transaction.getTransactionId());
			preparedStatement.setInt(2, transaction.getToAccountNumber());
			preparedStatement.setInt(3, transaction.getFromAccountNumber());
			preparedStatement.setInt(4, transaction.getAmount());
			preparedStatement.setString(5, transaction.getDate());

			result = preparedStatement.executeUpdate();
		}

		return result;
	}

	@Override
	public int checkAvailBalance(Connection connection, String fromaccountNumber) throws SQLException {
		int result = 0;
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select amount from account where account_no=?")) {
			preparedStatement.setInt(1, Integer.parseInt(fromaccountNumber));
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					result = resultSet.getInt(1);
				}
			}
		}
		return result;
	}

	@Override
	public void updateBalanceAferTransaction(Connection connection, Transaction transaction) throws SQLException {
		int sourceAmount = 0;// sub
		int destAmount = 0;// add
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int account_no = resultSet.getInt("account_no");
				int amount = resultSet.getInt("amount");

				if (account_no == transaction.getToAccountNumber()) {
					sourceAmount = amount + transaction.getAmount();
				}

				if (account_no == transaction.getFromAccountNumber()) {
					destAmount = amount - transaction.getAmount();
				}
			}
		}

		try (PreparedStatement preparedStatement1 = connection.prepareStatement(
				"update account set amount = ? where account_no = ?");
				PreparedStatement preparedStatement2 = connection.prepareStatement(
						"update account set amount = ? where account_no = ?")) {

			preparedStatement1.setInt(1, destAmount);
			preparedStatement1.setInt(2, transaction.getFromAccountNumber());

			preparedStatement2.setInt(1, sourceAmount);
			preparedStatement2.setInt(2, transaction.getToAccountNumber());

			preparedStatement1.executeUpdate();
			preparedStatement2.executeUpdate();
		}
	}

	@Override
	public List<Transaction> getAllTransactionDetails(Connection connection) throws SQLException {
		List<Transaction> trasactionList=new ArrayList<Transaction>();
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction");
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransactionId(resultSet.getString(1));
				transaction.setAmount(resultSet.getInt(2));
				transaction.setToAccountNumber(resultSet.getInt(3));
				transaction.setFromAccountNumber(resultSet.getInt(4));
				transaction.setDate(resultSet.getString(5));
				transaction.setStatus(resultSet.getInt(6));
				trasactionList.add(transaction);
			}

		}
		
		return trasactionList;
	}

}
