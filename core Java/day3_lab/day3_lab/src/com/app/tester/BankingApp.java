package com.app.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.app.banking.AcType;
import com.app.banking.BankAccount;
import static com.app.utils.BankingValidations.*;

public class BankingApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// start up : init phase
			boolean exit = false;
			double amount;
			// init D.S -- array
			System.out.println("Enter max no of bank accounts");
			BankAccount[] accounts = new BankAccount[sc.nextInt()];// 100
			int counter = 0;
			while (!exit) {
				// clnt servicing phase
				System.out.println("Options : 1. Create A/C \n" + "2. Display All Accounts \n" + "3. Withdraw money"+"4. Deposite Money"+"5. Transfer Money"+ "0. Exit ");
				System.out.println("Choose an option");
				switch (sc.nextInt()) {
				case 1:
					// boundary condition checking
					if (counter < accounts.length) {
						System.out.println("Enter a/c details -  acctNo,  firstName,"

								+ " lastName,  acType,  dob, creationDate, balance");
						BankAccount acct = validateInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble());
						accounts[counter++] = acct;
						System.out.println("A/c created !");

					} else
						System.out.println("Bank capacity full !!!!");

					break;
				case 2:
					for(int i=0;i<counter;i++) {
						System.out.println(accounts[i]);
					}
					break;
					
				case 3:
				{
					System.out.println("Enter amount to withdraw");
					 amount=sc.nextDouble();
					 System.out.println("Enter Account number. ");
					 int ano=sc.nextInt();
					int  flag=0;
					
					 for(int j=0;j<counter;j++) {
						 if(accounts[j].getAcctNo()==ano) {
							 accounts[j].withdraw(amount);
							 flag=0;
							 break;
						 }
						 else {
							 //
							 flag=1;
						 }
						 if(flag==1) {
							 System.out.println("Account number not found. ");
						 }
					 }
					 break; 
				}
				case 4:{
					System.out.println("Enter amount to withdraw");
					 amount=sc.nextDouble();
					 System.out.println("Enter Account number. ");
					 int ano=sc.nextInt();
					 int flag1=0;
					 for(int j=0;j<counter;j++) {
						 if(accounts[j].getAcctNo()==ano) {
							 accounts[j].withdraw(amount);
							 flag1=0;
							 break;
						 }
						 else {
							 //System.out.println("Account number not found. ");
							 flag1=1;
						 }
						 
					 }
					 if(flag1==1) {
						 System.out.println("Account number not found.");
					 }
					 break; 
				}
				case 5:{
					System.out.println("Enter amount to withdraw");
					 amount=sc.nextDouble();
					 System.out.println("Enter Account number. ");
					 int ano=sc.nextInt();
					int flag1=0;
					int flag=0;
					System.out.println("Enter Account number. ");
					 int depositer_acountnumber=sc.nextInt();
					 for(int j=0;j<counter;j++) {
						 
						 if(accounts[j].getAcctNo()==ano) {
							 flag=0;
							 accounts[j].withdraw(amount);
							 break;
						 }
						 else {
							
							 flag=1;
						 } 
					 if(accounts[j].getAcctNo()==depositer_acountnumber) {
						 accounts[j].deposit(amount);
						 flag=0;
						 break;
					 }
					 else {
						 //System.out.println("Account number not found. ");
						 flag1=1;
					 }
					 }
					 if(flag==1) {
						 System.out.println("withdrawre Account number not found. ");
					 }
					 if(flag1==1) {
						 System.out.println("Depositer Account number not found. ");
					 }
					 break;
				}
				case 0:
					exit = true;
					break;
			
				}
			}
		
		} // JVM : sc.close()
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
