package com.banking.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.banking.model.User;
import com.banking.control.BankingApplication;

public class LoginPage extends BankingApplication{

	public void loginPage() {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("============Login Page============ \n Enter Account number and password");
		long acc=sc.nextLong();
		String pass=sc.next();
		try {
			FileInputStream fileinput =new FileInputStream("D:\\program\\userAppnDetails.txt");
			ObjectInputStream object=new ObjectInputStream(fileinput);
			
			ArrayList<User> userdetail= (ArrayList<User>) object.readObject();
			
			User user =new User();
			user=userdetail.get(0);
			//System.out.println(user.getPassword());
			if(user.getPassword().equals(pass) && user.getAccountNo()==acc)
			{
				System.out.println("login successful");
			}
			else
			{
				System.out.println("Login failed");
				loginPage();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
