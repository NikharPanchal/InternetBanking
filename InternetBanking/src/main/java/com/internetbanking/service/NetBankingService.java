package com.internetbanking.service;

import java.util.List;

import com.internetbanking.bean.Customer;
import com.internetbanking.bean.NetBanking;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 18-Jun-2022
*/
public interface NetBankingService {

	int saveInternetBankingData(Customer customer, NetBanking netbanking);

	int checkAadharNumber(String aadhar_no);

	int checkAccountNumber(String account_no);

	NetBanking checkNetBankingLoginData(NetBanking netbanking);

	List<NetBanking> fetchNetBankingUserList();

	int updateNetBankingStatus(int parseInt);

	int checkAccountNumberNetBanking(String account_no, String loginAccountNo);

	int deleteTransactionDetails(String parseInt);

}
