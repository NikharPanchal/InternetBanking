package com.internetbanking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.internetbanking.bean.Account;
import com.internetbanking.bean.Customer;
import com.internetbanking.bean.User;
import com.internetbanking.dao.CustomerDao;
import com.internetbanking.util.ThreadEmail;

/**
 * @objective
 * @Developer Nikhar
 * @Date 12-Jun-2022
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public User checkLoginData(Connection connection, User user) throws SQLException {
		User loginData = new User();
		try (PreparedStatement ps = connection.prepareStatement("select * from user");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				String username = resultset.getString("user_name");
				String password = resultset.getString("password");
				String role = resultset.getString("role");
				if (username.equalsIgnoreCase(user.getUser_name()) && password.equals(user.getPassword())
						&& user.getRole() == "Admin") {
					loginData.setUser_name(username);
					loginData.setPassword(password);
					loginData.setRole(role);
				}
			}
		}

		return loginData;
	}

	@Override
	public int saveCustomerDetails(Connection connection, Customer customer) throws SQLException {
		int ans = 0;
		String insertquery = "insert into customer(customer_name,customer_email,customer_address,customer_dob,customer_aadhar_no,customer_contact,customer_gender,customer_image) values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertquery)) {
			ps.setString(1, customer.getCust_name());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getDob());
			ps.setString(5, customer.getAadharno());
			ps.setString(6, customer.getPhoneno());
			ps.setString(7, customer.getGender());
			ps.setBlob(8, customer.getImage_stream());
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<Customer> getCustomerDetails(Connection connection) throws SQLException {
		List<Customer> custList = new ArrayList<Customer>();
		try (PreparedStatement ps = connection.prepareStatement("select * from customer");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				Customer c = new Customer();
				c.setCust_id(resultset.getInt(1));
				c.setCust_name(resultset.getString(2));
				c.setEmail(resultset.getString(3));
				c.setAddress(resultset.getString(4));
				c.setDob(resultset.getString(5));
				c.setAadharno(resultset.getString(6));
				c.setPhoneno(resultset.getString(7));
				c.setGender(resultset.getString(8));
				byte[] imagedata = resultset.getBytes(9);
				if (null != imagedata && imagedata.length > 0) {
					String imgstring = Base64.getEncoder().encodeToString(imagedata);
					c.setImage_string(imgstring);
				}
				c.setStatus(resultset.getInt(10));
				custList.add(c);
			}

		}
		return custList;
	}

	@Override
	public int openCustomeraccount(Connection connection, Account account) throws SQLException {
		
		int account_no = 0;
		String email = null;
		String insertquery = "insert into account(customer_id,account_type,amount) values(?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertquery)) {
			ps.setInt(1, account.getCustomer_id());
			ps.setString(2, account.getAccount_type());
			ps.setInt(3, account.getAmount());
			int ans = ps.executeUpdate();
			System.out.println("ans val in dao" + ans);

			if (ans>0) {
				String selectquery = "select customer_email from customer where customer_id = ?";
				String selectquery2="select account_no from account where customer_id=?";
				try (PreparedStatement ps1 = connection.prepareStatement(selectquery);
						PreparedStatement ps2 = connection.prepareStatement(selectquery2))
				{
					ps1.setInt(1, account.getCustomer_id());
					ps2.setInt(1, account.getCustomer_id());
					try (ResultSet resultSet = ps1.executeQuery()) {
						while (resultSet.next()) {
							email = resultSet.getString("customer_email");
						}
					}
					try (ResultSet resultSet = ps2.executeQuery()) {
						while (resultSet.next()) {
							account_no = resultSet.getInt("account_no");
						}
					}
				}

				String msg = "\n<font color=red size=5>YOUR Account no is</font>\n\n<h3>YOUR A/C NO IS  ::  " + account_no
						+ "</h3>";
				System.out.println("Account number in dao"+account_no);
				ThreadEmail threadEmail = new ThreadEmail();
				threadEmail.Send("nikharp2000@gmail.com", msg);
				Thread t1 = new Thread(threadEmail);
				t1.start();

				System.out.println("ans val in dao end" + ans);
			}

			return ans;
		}
	}

	@Override
	public int checkEmailAddress(Connection connection, String email) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement("select * from customer");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				if (email.equals(resultset.getString("customer_email")) && resultset.getInt("status") == 1) {
					ans = 1;
					break;
				}
			}

		}
		return ans;
	}

	@Override
	public int updateCustomerDetails(Connection connection, int cust_id) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement("update customer set status=0 where customer_id=?")) {

			ps.setInt(1, cust_id);

			ans = ps.executeUpdate();
			return ans;
		}
	}

	@Override
	public int editCustomerDetails(Connection connection, Customer customer) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"update customer set customer_name=?, customer_email=?, customer_address=?, customer_contact = ?, customer_image = COALESCE(?,customer_image) where customer_id =?")) {
			ps.setString(1, customer.getCust_name());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getPhoneno());
			ps.setBlob(5, customer.getImage_stream());
			ps.setInt(6, customer.getCust_id());

			ans = ps.executeUpdate();
		}

		return ans;
	}

}
