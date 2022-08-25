package com.internetbanking.bean;
/**
 * @objective 
 * @Developer Nikhar
 * @Date 16-Jun-2022
*/
public class Account {
	private int account_no;
	private int customer_id;
	private String account_type;
	private int amount;
	private int status;
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", customer_id=" + customer_id + ", account_type=" + account_type
				+ ", amount=" + amount + ", status=" + status + "]";
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
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
}
