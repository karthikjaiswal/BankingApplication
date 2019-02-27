package com.banking.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.banking.model.User;
import com.banking.view.LoginPage;
import com.banking.view.Operations;
import com.banking.view.Registration;



public class BankingApplication{

	public static void main(String[] args) {
		
		for(int i=0; i < 10;i++)
		{
			System.out.println("=========Welcome to Bank=======");
			System.out.println("1. Registration \n2. Login \n3. Exit");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
		
		if(n==1)
			{
			Registration r=new Registration();
			ArrayList<User> userdetails=new ArrayList<>();
			userdetails.add(r.setInfo());
			r.serializeUser(userdetails);
			}
		else if(n==2)
		{
			LoginPage l=new LoginPage();
			l.loginPage();
		
			Operations o=new Operations();
			o.operations();
		}
		else
			System.exit(0);
		
		}
	}
}
	

