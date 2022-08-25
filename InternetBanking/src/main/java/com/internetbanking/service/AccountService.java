package com.internetbanking.service;

import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Transaction;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 01-Jul-2022
*/
public interface AccountService {

	List<Account> getOpenAccountDetails();

	int deleteAccountDetails(int parseInt);

	int insertTrasactionDetails(Transaction transaction);

	int checkAvailBalance(String fromaccountNumber);

	void updateTransferAmount(Transaction transaction);

	List<Transaction> fetchTransactionDetails();

}
