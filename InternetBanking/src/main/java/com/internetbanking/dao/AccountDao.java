package com.internetbanking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Transaction;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 01-Jul-2022
*/
public interface AccountDao {

	List<Account> fetchActiveAccountDetails(Connection connection) throws SQLException;

	int deactivateOpenedAccount(Connection connection, int accountNo) throws SQLException;

	int transferMoney(Connection connection, Transaction transaction) throws SQLException;

	int checkAvailBalance(Connection connection, String fromaccountNumber) throws SQLException;

	void updateBalanceAferTransaction(Connection connection,Transaction transaction)throws SQLException;

	List<Transaction> getAllTransactionDetails(Connection connection)throws SQLException;	
}
