package com.internetbanking.bean;
/**
 * @objective 
 * @Developer Nikhar
 * @Date 15-Jun-2022
*/

import java.io.InputStream;

public class Customer {

		private int cust_id;
		private String cust_name;
		private String email;
		private String address;
		private String dob;
		private String aadharno;
		private String phoneno;
		private String gender;
		private InputStream image_stream;
		private String image_string;
		private int status;
				@Override
		public String toString() {
			return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", email=" + email + ", address="
					+ address + ", dob=" + dob + ", aadharno=" + aadharno + ", phoneno=" + phoneno + ", gender="
					+ gender + ", image_stream=" + image_stream + ", image_string=" + image_string + ", status="
					+ status + "]";
		}
				public int getCust_id() {
			return cust_id;
		}
		public void setCust_id(int cust_id) {
			this.cust_id = cust_id;
		}
		public String getCust_name() {
			return cust_name;
		}
		public void setCust_name(String cust_name) {
			this.cust_name = cust_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getAadharno() {
			return aadharno;
		}
		public void setAadharno(String aadharno) {
			this.aadharno = aadharno;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public InputStream getImage_stream() {
			return image_stream;
		}
		public void setImage_stream(InputStream image_stream) {
			this.image_stream = image_stream;
		}
		public String getImage_string() {
			return image_string;
		}
		public void setImage_string(String image_string) {
			this.image_string = image_string;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}
		
		
}
