package com.app.utils;

import static com.app.utils.ContactValidation.parseDate;
import static com.app.utils.ContactValidation.validateEmail;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.app.Contact.Contact;
import com.app.ExceptionHandling.ContactException;

public class ContactValidation {
	
	public static Contact validateInput(long phoneno, String name, String dob, String email,HashSet<Contact> contactList) throws ContactException {
		checkDuplicate(phoneno,dob,contactList);
			//String emailId=validateEmail(email);
			LocalDate dateofb=parseDate(dob);
		
		
		
		
		
		return new Contact(phoneno,name,dateofb,email);
	}
	
	public static String validateEmail(String email) throws ContactException {
		String str = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if(email.matches(str))
			return email;
		throw new ContactException("Enter valid mail id .... ");
	}
	
	public static LocalDate parseDate(String dob) {
		return LocalDate.parse(dob);
		
	}
	
	
	public static void UpdateContact(long phoneno, String email, String dob,HashSet<Contact> contlist) throws ContactException {
		//validateEmail(email);
		LocalDate d1=LocalDate.parse(dob);
		//LocalDate dob1=parseDate(dob);
		Contact contact=new Contact(phoneno,d1);
		boolean status=contlist.contains(contact);
//		contlist.
		System.out.println(status);
		if(status==false) {
			throw new ContactException("Enter valid phone number od date of birth.");
		}
		Iterator<Contact> itr=contlist.iterator();
		while(itr.hasNext()) {
			Contact c=itr.next();
			System.out.println(c);
			if(c.getPhoneno()==phoneno && c.getDob().equals(d1))
			{
			c.setEmail(email);	
			System.out.println(c);
			//return itr;
			break;
			}
		}
		 
	}
	
	
	public static void checkDuplicate(long phoneno, String dob ,HashSet<Contact> contlist) throws ContactException{
		LocalDate d1=parseDate(dob);
		Contact contact=new Contact(phoneno,d1);
		if(contlist.equals(contact)) {
			
			throw new ContactException("Duplicate values are not allowed...");
		}
		
		
	}
		public static void removeContact(long phoneno, String dob,HashSet<Contact> contlist)throws ContactException {
			LocalDate dob1=parseDate(dob);
			//validateEmail(email);
			Contact contact1=new Contact(phoneno,dob1);
			boolean index=contlist.contains(contact1);
			if(index==false) {
				throw new ContactException("Enter valid phone number od date of birth.");
			}
			contlist.remove(contact1);
			
			
		}
		
		
	

}
