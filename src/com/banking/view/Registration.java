package com.banking.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


import com.banking.control.BankingApplication;
//import java.util.Random;
import com.banking.model.User;



public class Registration extends BankingApplication{
	
	static int count=0;
	public  User setInfo() {
		ArrayList<User> userdetails=new ArrayList<>();
		Scanner scanner=new Scanner(System.in);
		User user=new User();
		System.out.println("=============Registration Page============");
		System.out.println("enter details of user "+count);
		
		System.out.println("First name");
		user.setFirstName(scanner.next());
		System.out.println("Last name");
		user.setLastName(scanner.next());
		System.out.println("Aadhar number");
		user.setAadharCardNo(scanner.nextLong());
		System.out.println("Account Type");
		user.setAccountType(scanner.next());
		System.out.println("Pancar number");
		user.setPanCard(scanner.next());
		System.out.println("Phone number");
		user.setPhoneNo(scanner.nextLong());
		System.out.println("Address");
		user.setAddress(scanner.next());
		System.out.println("Create password");
		user.setPassword(scanner.next());
		
		if(user.getAadharCardNo()==0 || user.getPhoneNo()==0)
		{
			System.out.println("Enter proper aadhar number ");
			user.setAadharCardNo(scanner.nextLong());
			System.out.println("Enter proper aadhar number ");
			user.setPhoneNo(scanner.nextLong());
		}
		else
		{
			
			//generate random acc number
			Random random=new Random();
			long accountNumber=Math.abs(random.nextInt());
			System.out.println("Successfully registered with Account number"+accountNumber);
			user.setAccountNo(accountNumber);
			
		}
		count++;
	
		return user;
	}
		

	public  void serializeUser(ArrayList<User> userdetails) {
		try {
			
			FileOutputStream fileoutput=new FileOutputStream("D:\\program\\userAppnDetails.txt");
			ObjectOutputStream objectouput=new ObjectOutputStream(fileoutput);		
			
			objectouput.writeObject(userdetails);
			objectouput.close();
		
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
