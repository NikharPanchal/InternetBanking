package com.internetbanking.bean;

/**
 * @objective 
 * @Developer Nikhar
 * @Date 17-Jun-2022
*/
public class NetBanking {
	
	private int netBankingId;
	private String email;
	private String aadhar_no;
	private String contact;
	private Customer customer;
	private String cust_id;
	private String password;
	private int status;
	private int account_no;
	private String role;

	
	@Override
	public String toString() {
		return "NetBanking [netBankingId=" + netBankingId + ", email=" + email + ", aadhar_no=" + aadhar_no
				+ ", contact=" + contact + ", customer=" + customer + ", cust_id=" + cust_id + ", password=" + password
				+ ", status=" + status + ", account_no=" + account_no + "]";
	}
	public int getNetBankingId() {
		return netBankingId;
	}
	public void setNetBankingId(int netBankingId) {
		this.netBankingId = netBankingId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}