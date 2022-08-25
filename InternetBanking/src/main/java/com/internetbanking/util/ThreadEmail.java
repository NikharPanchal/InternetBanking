package com.internetbanking.util;

import com.internetbanking.bean.Customer;

public class ThreadEmail implements Runnable {

	
	String sendemail=null;
	String msg=null;
	public void Send(String email,String message)
	{
		sendemail=email;
		msg=message;
	}
	Customer u = new Customer();

	@Override
	public void run() {
		try {
			SendEmail s = new SendEmail();
			String mail = sendemail;
			s.sendmail(mail, msg);
			System.out.println("In mail class");
			System.out.println("Mail id"+mail);
			System.out.println("msg"+msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
