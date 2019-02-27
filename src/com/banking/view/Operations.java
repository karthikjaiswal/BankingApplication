package com.banking.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.banking.control.BankingApplication;
import com.banking.model.User;

public class Operations extends BankingApplication {

	static Scanner sc=new Scanner(System.in);
	
	public void operations()
	{
		
		System.out.println("==========Choose Option===========");
		System.out.println("1. Withdrawl \n 2. Deposit \n  3. Exit");
		int n=sc.nextInt();
		
		switch(n)
		{
		case 1:
			withdrawlCash();
			break;
		case 2:
			depositCash();
			break;
		case 3:
			System.exit(0);
		}
		
		
	}

	private void depositCash() {
		
		
		try {
			FileInputStream fileinput =new FileInputStream("D:\\program\\userAppnDetails.txt");
			ObjectInputStream object=new ObjectInputStream(fileinput);
			
			ArrayList<User> userdetail= (ArrayList<User>) object.readObject();
			
			User user =new User();
			user=userdetail.get(0);
			System.out.println("Your Account balance is: "+user.getBalance());
			System.out.println("Enter amount to be deposited:");
			Long deposit=sc.nextLong();
			
			user.setBalance(user.getBalance()+deposit);
			
			System.out.println("The updated balance is: " +user.getBalance());
			FileOutputStream fileoutput=new FileOutputStream("D:\\program\\userAppnDetails.txt");
			ObjectOutputStream objectouput=new ObjectOutputStream(fileoutput);		
			
			objectouput.writeObject(userdetail);
			objectouput.close();
			operations();
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

	
	
	
	
	
	
	private void withdrawlCash() {
	
		
		
		try {
			FileInputStream fileinput =new FileInputStream("D:\\program\\userAppnDetails.txt");
			ObjectInputStream object=new ObjectInputStream(fileinput);
			
			ArrayList<User> userdetail= (ArrayList<User>) object.readObject();
			
			User user =new User();
			user=userdetail.get(0);
			System.out.println("Your Account balance is: "+user.getBalance());
			
			System.out.println("Enter amount to be withdrawn:");
			Long withdraw=sc.nextLong();
			if(user.getBalance()>(withdraw+500))
			{
			user.setBalance(user.getBalance()-withdraw);
			System.out.println("The updated balance is: " +user.getBalance());
			}
			else {
				System.out.println("Your balance is insufficient");
			}
			FileOutputStream fileoutput=new FileOutputStream("D:\\program\\userAppnDetails.txt");
			ObjectOutputStream objectouput=new ObjectOutputStream(fileoutput);		
			
			objectouput.writeObject(userdetail);
			objectouput.close();
			
			operations();
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
