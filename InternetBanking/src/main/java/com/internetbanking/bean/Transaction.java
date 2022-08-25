package com.internetbanking.bean;

import java.sql.Date;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 01-Jul-2022
*/
public class Transaction {
	
	private String transactionId;
	private int toaccountNumber;
	private int fromAccountNumber;
	private int amount;
	private String date;
	private int status;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getToAccountNumber() {
		return toaccountNumber;
	}
	public void setToAccountNumber(int toaccountNumber) {
		this.toaccountNumber = toaccountNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", toaccountNumber=" + toaccountNumber
				+ ", fromAccountNumber=" + fromAccountNumber + ", amount=" + amount + ", date=" + date + ", status="
				+ status + "]";
	}
	public int getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(int fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	

}
