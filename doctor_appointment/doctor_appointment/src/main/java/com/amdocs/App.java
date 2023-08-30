package com.amdocs;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.amdocs.dao.impl.CustomerDaoImpl;
import com.amdocs.model.Customer;
public class App 
{
	static CustomerDaoImpl ud = new CustomerDaoImpl();
	static Scanner scan = new Scanner(System.in);
	static AppointmentMenu app =new AppointmentMenu();
    public static void main( String[] args ) throws SQLException
    {
        System.out.println("1. Customer");
        System.out.println("2. Doctor");
        System.out.println("3. Appointment");
        System.out.println("0. Exit");
        int choice =Integer.parseInt(scan.nextLine());
        if (choice == 1) {
        	CustomerMenu();
        } 
        else if(choice == 2) {
        	app.appointmentMenu();
        }
        else if(choice ==3) {
        	app.viewSingleRecord();
        }
        else {
            System.exit(0);
        }
    }
    private static void CustomerMenu() throws SQLException {
    	System.out.println("1. Register Customer");
    	System.out.println("2. Modify Customer Details");
    	System.out.println("3. Delet Customer Record");
    	System.out.println("4. view single record");
    	System.out.println("5. view all records");
    	System.out.println("0. Exit");
    	int choice =Integer.parseInt(scan.nextLine());
        if (choice == 1) {
        	registration();
        } 
        else if(choice == 2) {
        	modifyCustomerDetails();
        }
        else if(choice ==3) {
        	deleteRecord();
        }
        else if(choice == 4){
        	findSingleRecord();
        }
        else if(choice == 5) {
        	viewAllRecords();
        }
        else {
        	System.exit(0);
        }
    	
    }
    private static void deleteRecord() {
    	System.out.println("Enter email to delete");
    	String email = scan.nextLine();
		// TODO Auto-generated method stub
    	ud.deleteRecord(email);
		
	}
	private static void viewAllRecords() {
		List<Customer> view = ud.viewAllRecords();
		for (Customer customer : view) {
			System.out.println(customer);
		}
		
	}
	private static void AppointmentMenu() {
    	System.out.println("1. Book an appointment");
    	System.out.println("2. Modify appointment details");
    	System.out.println("3. Delete an appointment");
    	System.out.println("4. View single record");
    	System.out.println("5. view all records");
    	System.out.println("0. Exit");
    }
	private static void registration() throws SQLException {
		System.out.println("First Name : " );
		String firstname = scan.nextLine();
		System.out.println("Last Name:" );
		String lastname = scan.nextLine();
		System.out.println("Email Id :");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		System.out.println("Confirm Password :");
		String cpassword = scan.nextLine();
		System.out.println("Age:");
		int age = Integer.parseInt(scan.nextLine());
		Customer ur = new Customer(firstname,lastname,email,password,age);
		
		 if (password.equals(cpassword)) {
			 ud.insert(ur);
			 System.out.println("Password and confirmation match. Password set successfully!");
	     } 
		 else {
	            System.out.println("Password and confirmation do not match. Please try again.");
	        }
	}
	private static void modifyCustomerDetails()  {
		System.out.println("First Name : " );
		String firstname = scan.nextLine();
		System.out.println("Last Name:" );
		String lastname = scan.nextLine();
		System.out.println("Email Id :");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		System.out.println("Age:");
		int age = Integer.parseInt(scan.nextLine());
		Customer ur = new Customer(firstname,lastname,email,password,age);
		ud.update_user(ur);
	
}
	 public static void findSingleRecord() {
			System.out.println("Enter Emailid:");
	    	String email=scan.nextLine();
	    	Customer findById = ud.findById(email);
	    	System.out.println(findById);
	 }
	 
	   
}
