package com.amdocs.dao.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.*;
import com.amdocs.dao.CustomerDao;
import com.amdocs.model.Customer;
import com.amdocs.util.Dbutil;
public class CustomerDaoImpl implements CustomerDao {
	private final static String INSERT = "insert into user(firstname,lastname,email,password,age) values(?,?,?,?,?)";
	private final static String SELECT_BY_ID = "SELECT * FROM user WHERE email=?";
	private final static String viewAllRecords = "SELECT * FROM user";
	private final static String deleteRecord = "DELETE FROM user WHERE email=?";
	private static Connection connection=Dbutil.getConnection();
	
	@Override
	public void insert(Customer user) throws SQLException {
        PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getAge());
            if (preparedStatement.executeUpdate() > 0) {
        	  // result=true;
               System.out.println("Data inserted successfully.");
           } else {
               System.out.println("Data insertion failed.");
           }
           preparedStatement.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		
	}
	public void update_user(Customer user) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement("UPDATE user SET  firstname=?, lastname=?,password=?,age=? WHERE email = ?");
			preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getEmail());
            if (preparedStatement.executeUpdate() > 0) {
          	  // result=true;
                 System.out.println("Data updated successfully.");
             } else {
                 System.out.println("Data updation failed.");
             }
            preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Customer findById(String emailid) {
		Customer user=new Customer();
		try {
			PreparedStatement st=connection.prepareStatement(SELECT_BY_ID);
			st.setString(1, emailid);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 user.setFirstname(rs.getString("firstname"));
			 user.setLastname(rs.getString("lastname"));
			 user.setEmail(rs.getString("email"));
			 user.setPassword(rs.getString("password"));
			 user.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public static List<Customer> viewAllRecords() {
		List<Customer> customers = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(viewAllRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setAge(rs.getInt("age"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
			
	 }
	public void deleteRecord(String email) {
		
		    try {
		        PreparedStatement st = connection.prepareStatement(deleteRecord);
		        st.setString(1, email);
		        st.executeUpdate();
		        System.out.println("Your Details Deleted Succesfully");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		
	}
	
	


